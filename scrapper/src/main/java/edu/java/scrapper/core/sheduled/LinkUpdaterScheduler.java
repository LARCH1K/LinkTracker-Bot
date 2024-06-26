package edu.java.scrapper.core.sheduled;

import edu.java.scrapper.api.bot.client.BotClient;
import edu.java.scrapper.api.bot.dto.response.UpdateDto;
import edu.java.scrapper.api.bot.producer.Producer;
import edu.java.scrapper.core.service.LinkService;
import edu.java.scrapper.core.tracked.UpdateStrategy;
import edu.java.scrapper.entity.Link;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class LinkUpdaterScheduler {

    private static final int LINKS_TO_UPDATE = 20;

    private final LinkService linkService;

    private final BotClient botClient;

    private final Producer producer;

    private final UpdateStrategy updateStrategy = new UpdateStrategy();

    @Scheduled(fixedDelayString = "#{@deleteInterval}")
    public void deleteUntracked() {
        log.trace("[SCHEDULED] :: Deleting untracked links ...");
        linkService.deleteUntracked();
        log.trace("[SCHEDULED] :: Deleting untracked links ... Done!");

    }

    @Scheduled(fixedDelayString = "#{@updateInterval}")
    public void update() {
        log.trace("[SCHEDULED] :: Updating links ...");

        var links = linkService.getAllLinksSortedByUpdateDate(LINKS_TO_UPDATE);
        List<Pair<Link, String>> updatedLinks = new ArrayList<>();

        links.forEach(link -> {
            var rawUpdate = updateStrategy.countHashsum(link.getValue());
            if (rawUpdate.newHashsum() != link.getHashsum()) {
                updatedLinks.add(Pair.of(link, rawUpdate.message()));
            }
            linkService.update(link, rawUpdate.newHashsum());
        });

        log.trace("[SCHEDULED] :: Sending updates ...");

        updatedLinks.stream()
            .map(pair -> this.getUpdates(pair.getLeft(), pair.getRight()))
            .flatMap(List::stream)
            .forEach(producer::sendUpdate);

        log.trace("[SCHEDULED] :: Sending updates ... Done!");

        log.trace("[SCHEDULED] :: Updating links ... Done!");
    }

    private List<UpdateDto> getUpdates(Link link, String message) {
        var chats = linkService.findAllChatsConnectedWithLink(link.getValue());
        return chats.stream()
            .map(chat -> {
                var update = new UpdateDto();
                update.setChatId(chat.getTgChatId());
                update.setLink(link.getValue());
                update.setName(linkService.getShortName(chat.getTgChatId(), link.getValue()));
                update.setInfo(message);
                return update;
            })
            .toList();
    }

}
