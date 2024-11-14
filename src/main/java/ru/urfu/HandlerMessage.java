package ru.urfu;

/**
 * Класс для обработки сообщения отправленным пользователем
 */
public class HandlerMessage {
    /**
     * Обрабатывает сообщение для ответа пользователю
     *
     * @param messageFromUser сообщение от пользователя
     * @return измененое сообщение
     */
    public String handlingMessage(String messageFromUser) {
        return "Ваше сообщение: " + messageFromUser;
    }
}
