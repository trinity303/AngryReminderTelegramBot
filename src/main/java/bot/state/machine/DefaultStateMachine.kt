package bot.state.machine

import bot.MessagePresenter
import bot.models.Command
import bot.state.states.State
import bot.state.StateFactory
import org.telegram.telegrambots.meta.api.objects.Update

class DefaultStateMachine(
    private val stateFactory: StateFactory
) : StateMachine {

    private lateinit var currentState: State
    private lateinit var presenter: MessagePresenter

    override fun onStart(
        update: Update
    ) {
        val text: String = update.message.text

        currentState = when {
            isInitialStateCommand(text) -> stateFactory.createInitialState()
            isChoosePeriodStateCommand(text) -> stateFactory.createChoosePeriodState(text)
            isStopStateCommand(text) -> stateFactory.createStopState()
            else -> stateFactory.createNoState()
        }

        currentState.setMessagePresenter(presenter)
        currentState.onStart(update)
    }

    override fun setMessagePresenter(
        presenter: MessagePresenter
    ) {
        this.presenter = presenter
    }

    private fun isInitialStateCommand(
        message: String
    ): Boolean = Command.InitialState.commandSet.contains(message)

    private fun isChoosePeriodStateCommand(
        message: String
    ): Boolean = Command.ChoosePeriodState.commandSet.contains(message)

    private fun isStopStateCommand(
        message: String
    ): Boolean = Command.Stop.commandSet.contains(message)
}