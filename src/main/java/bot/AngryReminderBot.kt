package bot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import bot.state.machine.StateMachine

private const val TOKEN: String = "1442758729:AAHGEsUjsus784c_ElxTMVnNYwagUEf99mA"
private const val BOT_NAME: String = "AngryReminderBot"

class AngryReminderBot(
    private val stateMachine: StateMachine
) : TelegramLongPollingBot(), MessagePresenter {

    init {
        stateMachine.setMessagePresenter(this)
    }

    override fun getBotToken(): String = TOKEN

    override fun getBotUsername(): String = BOT_NAME

    override fun onUpdateReceived(update: Update) {
        stateMachine.onStart(update)
    }

    override fun onMessageReady(message: SendMessage) {
        execute(message)
    }
}