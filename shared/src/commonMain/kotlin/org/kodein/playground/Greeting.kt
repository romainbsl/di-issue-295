package org.kodein.playground

import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.bindConstant
import org.kodein.di.bindSingleton
import org.kodein.di.bindings.Scope
import org.kodein.di.bindings.ScopeRegistry
import org.kodein.di.bindings.StandardScopeRegistry
import org.kodein.di.instance
import org.kodein.di.scoped
import org.kodein.di.singleton

val greetingScope: Scope<Greeting> = object: Scope<Greeting> {
    override fun getRegistry(context: Greeting): ScopeRegistry = StandardScopeRegistry()
}

class Greeting {
    private val di: DI = DI {
        importAll(straightModule)
    }

    private val platform: Platform by di.instance()
    private val url: String by di.instance(tag = "URL")

    fun greeting(): String {
        return "Hello, ${platform}!\nGet in touch on $url"
    }
}

val straightModule: DI.Module = DI.Module(name = "my module") {
    bind { scoped(greetingScope).singleton { Platform() } }
    bindConstant("URL") { "http://kodein.net/" }
}