package edu.java.scrapper.core.service.impl;

import edu.java.scrapper.api.bot.dto.response.IsActiveChatDto;
import edu.java.scrapper.core.dao.ChatDao;
import edu.java.scrapper.core.service.ChatService;
import edu.java.scrapper.entity.Chat;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultChatService implements ChatService {

    private final ChatDao chatDao;

    @Override
    public IsActiveChatDto checkIfActivated(long tgChatId) {
        if (chatDao.findByTgChatId(tgChatId).isEmpty()) {
            create(tgChatId);
        }

        return IsActiveChatDto.builder()
            .isOpen(chatDao.findByTgChatId(tgChatId).get().getIsActive())
            .build();
    }

    @Override
    public void activate(long tgChatId) {
        if (chatDao.findByTgChatId(tgChatId).isEmpty()) {
            create(tgChatId);
        }

        chatDao.changeStatus(tgChatId, true);
    }

    @Override
    public void delete(long tgChatId) {
        chatDao.deleteByTgChatId(tgChatId);
    }

    @Override
    public Chat create(long tgChatId) {
        Chat chat = new Chat();
        chat.setTgChatId(tgChatId);
        chatDao.add(chat);
        return chatDao.findByTgChatId(tgChatId).get();
    }

}
