package edu.java.bot.api.filter.impl;

import com.pengrad.telegrambot.model.Update;
import edu.java.bot.api.controller.BotProcessor;
import edu.java.bot.api.filter.BotFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static edu.java.bot.api.Commands.COMMAND_PREFIX;

@Component
@RequiredArgsConstructor
public class MessageFilter implements BotFilter {

    private final BotProcessor messageBotProcessor;

    @Override
    public void doFilter(Update update) {
        if (!update.message().text().startsWith(COMMAND_PREFIX)) {
            messageBotProcessor.process(update);
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
