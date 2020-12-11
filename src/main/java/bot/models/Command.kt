package bot.models

const val START_COMMAND_MESSAGE: String = "/start"
const val TWO_SECONDS_COMMAND_MESSAGE: String = "2 seconds"
const val FIVE_SECONDS_COMMAND_MESSAGE: String = "5 seconds"
const val STOP_COMMAND_MESSAGE: String = "STOP"

sealed class Command(
        val commandSet: Set<String>
) {

    object InitialState: Command(setOf(START_COMMAND_MESSAGE))

    object ChoosePeriodState: Command(setOf(TWO_SECONDS_COMMAND_MESSAGE, FIVE_SECONDS_COMMAND_MESSAGE))

    object Stop: Command(setOf(STOP_COMMAND_MESSAGE))
}

