package service;

import dto.Tweet;
import repo.TweetRepository;
import java.util.concurrent.atomic.AtomicInteger;

public class TweetService {
    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public String postTweet(String userId, String content) {
        Tweet tweet = new Tweet(userId, content);
        tweetRepository.save(tweet);
        return tweet.getId();
    }

    public void deleteTweet(String tweetId) {
        tweetRepository.delete(tweetId);
    }

    public void likeTweet(String tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId);
        if (tweet != null) tweet.like();
    }

    public void dislikeTweet(String tweetId){
        Tweet tweet = tweetRepository.findById(tweetId);
        if (tweet != null) tweet.unlike();
    }
}
