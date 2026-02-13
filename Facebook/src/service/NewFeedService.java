package service;

import entities.*;
import strategy.ChronologicalNewsFeedGenerationStrategy;
import strategy.NewFeedGenerationStrategy;

import java.util.List;

public class NewFeedService {
    private NewFeedGenerationStrategy strategy;

    public NewFeedService() {
        this.strategy = new ChronologicalNewsFeedGenerationStrategy();// Default strategy
    }

    public void setStrategy(NewFeedGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Post> getNewsFeed(User user) {
        return strategy.generateFeed(user);
    }
}
