package edu.java.bot.core.communication.command.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.core.communication.command.Command;
import edu.java.bot.core.telegram.service.BotService;
import edu.java.bot.core.validation.Validator;
import edu.java.bot.entity.Link;
import edu.java.bot.entity.TrackingResource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommandSetLinkValue extends Command {

    private final Link link;

    @Override
    protected boolean start(BotService botService, Update update) {

        String linkValue = update.message().text();

        if (!Validator.isValidLink(linkValue)) {
            return false;
        }

        link.setValue(linkValue);
        link.setResource(TrackingResource.parseResource(linkValue));
        return true;
    }
}
