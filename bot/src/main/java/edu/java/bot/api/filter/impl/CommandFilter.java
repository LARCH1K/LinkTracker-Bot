package edu.java.bot.api.filter.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.api.controller.BotProcessor;
import edu.java.bot.api.filter.BotFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static edu.java.bot.api.Commands.COMMAND_PREFIX;

@Component
@RequiredArgsConstructor
public class CommandFilter implements BotFilter {

    private final BotProcessor commandBotProcessor;

    @Override
    public void doFilter(Update update) {
        if (update.message().text().startsWith(COMMAND_PREFIX)) {
            commandBotProcessor.process(update);
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
