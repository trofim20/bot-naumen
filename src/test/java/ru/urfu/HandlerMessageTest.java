package ru.urfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестирование класса HandlerMessage
 */
class HandlerMessageTest {
    /**
     * Проверяем, что метод корректно обрабатывает сообщение
     */
    @Test
    void testHandlingMessageMessage() {
        HandlerMessage handlerMessage = new HandlerMessage();
        String messageFromUser = "Привет";
        String expectedMessage = "Ваше сообщение: Привет";
        String handlingMessage = handlerMessage.handlingMessage(messageFromUser);
        assertEquals(expectedMessage, handlingMessage);
    }
}