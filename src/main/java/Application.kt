import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.util.concurrent.Executors

private const val POOL_SIZE: Int = 1

fun main() {
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
    telegramBotsApi.registerBot(createAngryReminderBot())
}

fun createAngryReminderBot() = AngryReminderBot(
        executor = Executors.newScheduledThreadPool(POOL_SIZE)
)