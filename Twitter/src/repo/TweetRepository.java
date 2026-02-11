package repo;

import dto.Tweet;

import java.util.List;

public interface TweetRepository {
    void save(Tweet tweet);
    Tweet findById(String tweetId);
    void delete(String tweetId);
    List<Tweet> findByUser(String userId);
}

