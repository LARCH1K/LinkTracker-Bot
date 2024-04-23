package edu.java.bot.core.communication.command.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.core.communication.command.Command;
import edu.java.bot.core.telegram.service.BotService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommandSendMessage extends Command {

    private final String message;
    private final boolean result;

    @Override
    protected boolean start(BotService botService, Update update) {
        botService.sendMessage(message, update, null);
        return result;
    }
}
