package edu.java.bot.core.communication.command.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.core.communication.command.Command;
import edu.java.bot.core.telegram.service.BotService;
import edu.java.bot.core.validation.Validator;
import edu.java.bot.entity.Link;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommandSetLinkName extends Command {

    private final Link link;

    @Override
    protected boolean start(BotService botService, Update update) {
        String linkName = update.message().text();

        if (!Validator.isValidLinkName(linkName)) {
            return false;
        }

        link.setName(linkName);
        return true;
    }
}
