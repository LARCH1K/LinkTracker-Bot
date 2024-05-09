package edu.java.scrapper.core.service.impl;

import edu.java.scrapper.api.bot.dto.request.LinkDto;
import edu.java.scrapper.api.bot.dto.request.LinkViewDto;
import edu.java.scrapper.api.bot.dto.request.UntrackLinkDto;
import edu.java.scrapper.core.dao.ChatDao;
import edu.java.scrapper.core.dao.ChatLinksDao;
import edu.java.scrapper.core.dao.LinkDao;
import edu.java.scrapper.core.service.ChatService;
import edu.java.scrapper.core.service.LinkService;
import edu.java.scrapper.entity.Chat;
import edu.java.scrapper.entity.ChatLinks;
import edu.java.scrapper.entity.Link;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultLinkService implements LinkService {

    private final LinkDao linkDao;

    private final ChatDao chatDao;

    private final ChatLinksDao chatLinksDao;

    private final ChatService chatService;

    @Override
    public void track(LinkDto linkDto) {
        Link link = linkDao.findByValue(linkDto.getValue())
            .orElseGet(() -> this.create(linkDto.getValue()));
        Chat chat = chatDao.findByTgChatId(linkDto.getChatId())
            .orElseGet(() -> chatService.create(linkDto.getChatId()));

        if (chatLinksDao.findByChatIdAndLinkId(chat.getId(), link.getId()).isPresent()) {
            return;
        }

        ChatLinks chatLinks = new ChatLinks();
        chatLinks.setChatId(chat.getId());
        chatLinks.setLinkId(link.getId());
        chatLinks.setShortName(linkDto.getShortName());
        chatLinksDao.add(chatLinks);
    }

    @Override
    public void untrack(UntrackLinkDto untrackLinkDto) {
        var optionalLink = linkDao.findByShortName(untrackLinkDto.getShortName(), untrackLinkDto.getChatId());
        var optionalChat = chatDao.findByTgChatId(untrackLinkDto.getChatId());

        if (optionalLink.isEmpty() || optionalChat.isEmpty()) {
            return;
        }

        chatLinksDao.findByChatIdAndLinkId(optionalChat.get().getId(), optionalLink.get().getId())
            .ifPresent(chatLinks -> chatLinksDao.delete(chatLinks.getId()));
    }

    @Override
    public List<Link> getAllLinksSortedByUpdateDate(int pageSize) {
        return linkDao.findAllLinksSortedByUpdateDate(pageSize);
    }

    @Override
    public List<LinkViewDto> getAllForChat(long tgChatId) {
        return linkDao.findAllLinksForChat(tgChatId);
    }

    @Override
    public List<Chat> findAllChatsConnectedWithLink(String value) {
        return chatLinksDao.findAllChatsConnectedWithLink(value);
    }

    @Override
    public void update(Link link, int newHashsum) {
        linkDao.update(link.getId(), newHashsum);
    }

    @Override
    public String getShortName(long tgChatId, String value) {
        return chatLinksDao.getShortName(tgChatId, value);
    }

    @Override
    public Link create(String value) {
        Link link = new Link();
        link.setValue(value);
        linkDao.add(link);
        return linkDao.findByValue(value).get();
    }

    @Override
    public void deleteUntracked() {
        var trackedLinksId = chatLinksDao.findAll()
            .stream()
            .map(ChatLinks::getLinkId)
            .toList();

        linkDao.findAll()
            .stream()
            .filter(link -> !trackedLinksId.contains(link.getId()))
            .forEach(link -> linkDao.delete(link.getId()));
    }

}
