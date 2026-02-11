package repo;

import dto.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTweetRepository implements TweetRepository {
    private final Map<String, Tweet> tweets = new HashMap<>();
    private final Map<String, List<Tweet>> userTweets = new HashMap<>();
    @Override
    public void save(Tweet tweet) {
          tweets.put(tweet.getId(),tweet);
          userTweets.computeIfAbsent(tweet.getUserId(), k -> new ArrayList<>()).add(tweet);
    }

    @Override
    public Tweet findById(String tweetId) {
        return tweets.get(tweetId);
    }

    @Override
    public void delete(String  tweetId) {
          tweets.remove(tweetId);
    }

    @Override
    public List<Tweet> findByUser(String userId) {
        return userTweets.getOrDefault(userId,new ArrayList<>());
    }
}
