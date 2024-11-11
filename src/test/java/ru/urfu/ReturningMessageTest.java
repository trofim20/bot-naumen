package ru.urfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестирование класса ReturningMessage
 */
class ReturningMessageTest {
    /**
     * Проверяем, что метод корректно форматирует сообщение
     */
    @Test
    void testFormatUserMessage() {
        ReturningMessage returningMessage = new ReturningMessage();
        String messageFromUser = "Привет";
        String expectedMessage = "Ваше сообщение: Привет";
        String returnMessage = returningMessage.formatUserMessage(messageFromUser);
        assertEquals(expectedMessage, returnMessage);
    }
}