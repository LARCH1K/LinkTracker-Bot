package edu.java.scrapper.core.sheduled;

import edu.java.scrapper.api.resources.client.GithubClient;
import edu.java.scrapper.api.resources.client.StackOverflowClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class LinkUpdaterScheduler {

    private final GithubClient githubClient;
    private final StackOverflowClient stackOverflowClient;

    @Scheduled(fixedDelayString = "#{@interval}")
    @SuppressWarnings("MagicNumber")
    public void update() {

        log.info("getting all tracked links ...");

        String repo = "Tinkoff-Backend";
        String owner = "larchik";
        long questionId = 66675088;

        log.info("getting all updates ...");

        var newCommits = githubClient.getUpdates(repo, owner);
        var newAnswers = stackOverflowClient.getUpdates(questionId);

        log.info("saving all updates ...");

        log.info("Done");
    }

}
