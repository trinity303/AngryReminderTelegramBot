package bot.state.states

import bot.MessagePresenter
import bot.ScheduledReminder
import bot.ViewFactory
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import java.util.concurrent.Future
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

private const val DEFAULT_CHAT_ID_VALUE: Long = 0

private const val KEYBOARD_MESSAGE: String = "You always can stop the reminder. Just click on STOP"

class ChoosePeriodState(
    private val period: Long,
    private val scheduledReminder: ScheduledReminder,
    private val viewFactory: ViewFactory
) : State {

    private var presenter: MessagePresenter? = null
    private var currentChatId: Long = DEFAULT_CHAT_ID_VALUE

    private val runnable = Runnable {
        presenter?.onMessageReady(getMessage())
    }

    override fun onStart(update: Update) {
        currentChatId = update.message.chatId

        scheduledReminder.changeExecutor(
            runnable = runnable,
            period = period
        )

        val keyboard: ReplyKeyboardMarkup = viewFactory.createChoosePeriodStateKeyboard()
        val message = SendMessage().apply {
            text = KEYBOARD_MESSAGE
            chatId = update.message.chatId.toString()
            enableMarkdown(true)
            replyMarkup = keyboard
        }

        presenter?.onMessageReady(message)
    }

    override fun setMessagePresenter(presenter: MessagePresenter) {
        this.presenter = presenter
    }

    private fun getMessage() = SendMessage().apply {
        chatId = currentChatId.toString()
        text = "Hayyya"
    }
}