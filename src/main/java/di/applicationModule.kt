package di

import bot.AngryReminderBot
import bot.ScheduledReminder
import bot.ViewFactory
import org.koin.dsl.module
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import java.util.concurrent.Executors

private const val POOL_SIZE: Int = 1

val applicationModule = module {

    single<TelegramLongPollingBot> {
        AngryReminderBot(
            stateMachine = get()
        )
    }

    single { ViewFactory() }

    single {
        ScheduledReminder(
            executor = Executors.newScheduledThreadPool(POOL_SIZE)
        )
    }
}