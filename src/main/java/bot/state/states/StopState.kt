package bot.state.states

import bot.MessagePresenter
import bot.ScheduledReminder
import org.telegram.telegrambots.meta.api.objects.Update

class StopState(
    private val scheduledReminder: ScheduledReminder
): State {

    private var presenter: MessagePresenter? = null

    override fun onStart(update: Update) {
        scheduledReminder.future?.cancel(true)
    }

    override fun setMessagePresenter(presenter: MessagePresenter) {
        this.presenter = presenter
    }
}