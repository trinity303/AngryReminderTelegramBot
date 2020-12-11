package di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import bot.state.di.stateModule

class DIContainer {

    fun onStart() {
        startKoin {
            printLogger()

            modules(getModules())
        }
    }

    private fun getModules(): List<Module> = listOf(
        applicationModule,
        stateModule
    )
}