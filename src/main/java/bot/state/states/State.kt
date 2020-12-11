package bot.state.states

import bot.MessagePresenter
import org.telegram.telegrambots.meta.api.objects.Update

interface State {

    fun onStart(
        update: Update
    )

    fun setMessagePresenter(
        presenter: MessagePresenter
    )
}