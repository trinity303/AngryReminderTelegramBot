package bot.state.machine

import bot.MessagePresenter
import org.telegram.telegrambots.meta.api.objects.Update

interface StateMachine {

    fun onStart(
        update: Update
    )

    fun setMessagePresenter(
        presenter: MessagePresenter
    )
}