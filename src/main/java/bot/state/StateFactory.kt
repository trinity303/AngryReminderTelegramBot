package bot.state

import bot.models.FIVE_SECONDS_COMMAND_MESSAGE
import bot.models.TWO_SECONDS_COMMAND_MESSAGE
import bot.state.di.CHOOSE_PERIOD_STATE_KEY
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.named
import bot.state.di.INITIAL_STATE_KEY
import bot.state.di.NO_STATE_KEY
import bot.state.di.STOP_STATE_KEY
import bot.state.states.State
import org.koin.core.parameter.parametersOf

private const val TWO_SECONDS_PERIOD: Long = 2
private const val FIVE_SECONDS_PERIOD: Long = 5
private const val NO_PERIOD: Long = 0

class StateFactory: KoinComponent {

    fun createInitialState(): State = get(named(INITIAL_STATE_KEY))

    fun createNoState(): State = get(named(NO_STATE_KEY))

    fun createChoosePeriodState(
        text: String
    ): State = get(named(CHOOSE_PERIOD_STATE_KEY)) { parametersOf(getPeriod(text)) }

    private fun getPeriod(
        text: String
    ): Long = when (text) {
        TWO_SECONDS_COMMAND_MESSAGE -> TWO_SECONDS_PERIOD
        FIVE_SECONDS_COMMAND_MESSAGE -> FIVE_SECONDS_PERIOD
        else -> NO_PERIOD
    }

    fun createStopState(): State = get(named(STOP_STATE_KEY))
}