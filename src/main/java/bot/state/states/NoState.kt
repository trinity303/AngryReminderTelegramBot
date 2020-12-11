package bot.state.states

import bot.MessagePresenter
import org.telegram.telegrambots.meta.api.objects.Update

class NoState : State {

    private var presenter: MessagePresenter? = null

    override fun onStart(update: Update) {
        TODO("Not yet implemented")
    }

    override fun setMessagePresenter(presenter: MessagePresenter) {
        this.presenter = presenter
    }
}