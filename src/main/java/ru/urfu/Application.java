package ru.urfu;

/**
 * Класс для запуска приложения
 */
public class Application {

    public static void main(String[] args) {
        ReturningMessage returningMessage = new ReturningMessage();

        String telegramBotName = System.getenv("telegram_botName");
        String telegramToken = System.getenv("telegram_token");
        new TelegramBot(telegramBotName, telegramToken,returningMessage)
                .start();

        String discordToken = System.getenv("discord_token");
        new DiscordBot(discordToken,returningMessage)
                .start();

        // сколько угодно чат платформ и все должны работать одинаково
    }

}
