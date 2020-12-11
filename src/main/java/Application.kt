import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

class Application: KoinComponent {

    fun onStart() {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)

        val angryReminderBot: TelegramLongPollingBot = get()
        telegramBotsApi.registerBot(angryReminderBot)
    }
}