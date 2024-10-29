package ru.urfu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Телеграм бот
 */
public class TelegramBot extends TelegramLongPollingBot {

    private final String telegramBotName;

    private final ReturningMessage returningMessage;
    /**
     * Конструктор TelegramBot
     *
     * @param telegramBotName имя бота
     * @param token токен
     * @param returningMessage объект, c помощью которого изменяется сообщение
     */
    public TelegramBot(String telegramBotName, String token,ReturningMessage returningMessage) {
        super(token);
        this.telegramBotName = telegramBotName;
        this.returningMessage = returningMessage;
    }
    /**
     * Запуск бота
     */
    public void start() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
            System.out.println("Telegram бот запущен");
        } catch (TelegramApiException e) {
            throw new RuntimeException("Не удалось запустить телеграм бота", e);
        }
    }
    /**
     * Обрабатывает полученные сообщения
     * @param update информация о новом сообщении
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message updateMessage = update.getMessage();
            Long chatId = updateMessage.getChatId();
            String messageFromUser = updateMessage.getText();
            String returnMessage = returningMessage.formatUserMessage(messageFromUser);
            sendMessage(chatId.toString(), returnMessage);
        }
    }

    /**
     * Отправить сообщение
     * @param chatId идентификатор чата
     * @param message текст сообщения
     */
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.err.println("Не удалось отправить сообщение. " + e.getMessage());
        }
    }
    /**
     * Возвращает имя бота
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return telegramBotName;
    }
}
