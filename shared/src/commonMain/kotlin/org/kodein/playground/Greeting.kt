package org.kodein.playground

import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bindConstant
import org.kodein.di.bindSingleton
import org.kodein.di.instance

class Greeting {
    private val di: DI = DI {
        importAll(straightModule)
    }

    private val platform: Platform by di.instance()
    private val url: String by di.instance(tag = "URL")

    fun greeting(): String {
        return "Hello, ${platform.get()}!\nGet in touch on $url"
    }
}

val straightModule: DI.Module = DI.Module(name = "my module") {
    bindSingleton { Platform() }
    bindConstant("URL") { "http://kodein.net/" }
}