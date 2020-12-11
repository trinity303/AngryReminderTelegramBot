package bot.state.states

import bot.MessagePresenter
import bot.ViewFactory
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

private const val CHOOSE_PERIOD_MESSAGE: String = "Choose remind period"

class InitialState(
    private val viewFactory: ViewFactory
) : State {

    private var presenter: MessagePresenter? = null

    override fun onStart(update: Update) {
        val keyboard = viewFactory.createInitialStateKeyboard()

        val message = SendMessage().apply {
            text = CHOOSE_PERIOD_MESSAGE
            chatId = update.message.chatId.toString()
            enableMarkdown(true)
            replyMarkup = keyboard
        }

        presenter?.onMessageReady(message)
    }

    override fun setMessagePresenter(presenter: MessagePresenter) {
        this.presenter = presenter
    }
}