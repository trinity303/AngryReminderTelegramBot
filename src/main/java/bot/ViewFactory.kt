package bot

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

private const val INITIAL_STATE_CHOOSE_TWO_SECONDS_PERIOD: String = "2 seconds"
private const val INITIAL_STATE_CHOOSE_FIVE_SECONDS_PERIOD: String = "5 seconds"
private const val INITIAL_STATE_CHOOSE_CUSTOM_PERIOD: String = "Custom period"

private const val CHOOSE_PERIOD_STATE_STOP: String = "STOP"

class ViewFactory {

    fun createInitialStateKeyboard(): ReplyKeyboardMarkup {
        val keyboard = ReplyKeyboardMarkup().apply {
            selective = true
            resizeKeyboard = false
        }

        val firstKeyboardRow = KeyboardRow().apply {
            add(KeyboardButton(INITIAL_STATE_CHOOSE_TWO_SECONDS_PERIOD))
            add(KeyboardButton(INITIAL_STATE_CHOOSE_FIVE_SECONDS_PERIOD))
        }
        val secondKeyboardRow = KeyboardRow().apply {
            add(KeyboardButton(INITIAL_STATE_CHOOSE_CUSTOM_PERIOD))
        }

        keyboard.keyboard = listOf(firstKeyboardRow, secondKeyboardRow)

        return keyboard
    }

    fun createChoosePeriodStateKeyboard(): ReplyKeyboardMarkup {
        val keyboard = ReplyKeyboardMarkup().apply {
            selective = true
            resizeKeyboard = false
        }

        val keyboardRow = KeyboardRow().apply {
            add(KeyboardButton(CHOOSE_PERIOD_STATE_STOP))
        }

        keyboard.keyboard = listOf(keyboardRow)

        return keyboard
    }
}