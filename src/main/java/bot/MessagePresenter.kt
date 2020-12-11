package bot

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

interface MessagePresenter {

    fun onMessageReady(message: SendMessage)
}