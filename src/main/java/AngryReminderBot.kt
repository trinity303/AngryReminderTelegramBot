import models.BotCommand
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import java.util.concurrent.Future
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

private const val TOKEN: String = "1442758729:AAGnHg76GGf_xcKUQrYKv-NUCdV5tuPZgFA"
private const val BOT_NAME: String = "AngryReminderBot"

private const val INITIAL_DELAY: Long = 2
private const val PERIOD: Long = 2

class AngryReminderBot(
        private val executor: ScheduledExecutorService
) : TelegramLongPollingBot() {

    private var future: Future<*>? = null

    private val runnable = Runnable {
        sendMessage()
    }

    private var chatId: Long? = null

    override fun getBotToken(): String = TOKEN

    override fun getBotUsername(): String = BOT_NAME

    override fun onUpdateReceived(update: Update) {
        chatId = update.message.chatId

        when (update.message.text.toString()) {
            BotCommand.Start.command -> {
                future = executor.scheduleAtFixedRate(runnable, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS)
            }
            BotCommand.Stop.command -> {
                future?.cancel(true)
            }
        }
    }

    private fun sendMessage() {
        val message = SendMessage().apply {
            chatId = this@AngryReminderBot.chatId.toString()
            text = "Hayyya"
        }

        execute(message)
    }
}