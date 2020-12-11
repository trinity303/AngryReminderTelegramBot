package bot.state.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import bot.state.*
import bot.state.machine.DefaultStateMachine
import bot.state.machine.StateMachine
import bot.state.states.*
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.math.sin

const val INITIAL_STATE_KEY: String = "initial_state_key"
const val NO_STATE_KEY: String = "no_state_key"
const val CHOOSE_PERIOD_STATE_KEY: String = "choose_state_key"
const val STOP_STATE_KEY: String = "stop_state_key"

val stateModule = module {

    factory<StateMachine> {
        DefaultStateMachine(
            stateFactory = get()
        )
    }

    factory { StateFactory() }

    single<State>(named(INITIAL_STATE_KEY)) {
        InitialState(
            viewFactory = get()
        )
    }

    single<State>(named(NO_STATE_KEY)) {
        NoState()
    }

    single<State>(named(CHOOSE_PERIOD_STATE_KEY)) { (period: Long) ->
        ChoosePeriodState(
            period = period,
            scheduledReminder = get(),
            viewFactory = get()
        )
    }

    single<State>(named(STOP_STATE_KEY)) {
        StopState(
            scheduledReminder = get()
        )
    }
}