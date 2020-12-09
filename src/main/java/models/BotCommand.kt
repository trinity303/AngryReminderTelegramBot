package models

sealed class BotCommand(
        val command: String
) {

    object Start: BotCommand("/start")

    object Stop: BotCommand("/stop")
}