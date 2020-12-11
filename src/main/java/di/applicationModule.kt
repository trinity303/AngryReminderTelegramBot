package di

import AngryReminderBot
import org.koin.dsl.module
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import java.util.concurrent.Executors

private const val POOL_SIZE: Int = 1

val applicationModule = module {

    single<TelegramLongPollingBot> {
        AngryReminderBot(
            executor = Executors.newScheduledThreadPool(POOL_SIZE)
        )
    }
}