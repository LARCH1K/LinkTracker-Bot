package edu.java.bot.api.controller.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.api.controller.BotProcessor;
import edu.java.bot.core.telegram.service.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static edu.java.bot.api.Commands.HELP_COMMAND;

@Component
@RequiredArgsConstructor
public class MessageBotProcessor implements BotProcessor {

    private final BotService botService;

    @Override
    public void process(Update update) {
        if (botService.isUserInDialog(update)) {
            botService.consumeDialog(update);
        } else {
            botService.sendMessage("How can I help you? Send a command or use " + HELP_COMMAND + ".", update);
        }
    }
}
