package ru.urfu;
/**Класс для изменения сообщения отыравленым пользователем
 * */
public class ReturningMessage {
    /**
     * Изменение сообщение для ответа пользователю
     * @param messageFromUser сообщение от пользователя
     * @return измененое сообщение
     */
    public String formatUserMessage(String messageFromUser) {
        return String.format("Ваше сообщение: %s"+messageFromUser);
    }
}
