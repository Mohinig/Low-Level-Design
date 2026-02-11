package service;

import dto.Tweet;
import dto.User;
import repo.TweetRepository;
import repo.UserRepository;
import strategy.FeedStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FeedService {
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public FeedService(UserRepository userRepository,
                       TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getFeed(String userId, FeedStrategy strategy, int limit) {
        User user = userRepository.findById(userId);
        if (user == null) return new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>(strategy.getComparator());

        pq.addAll(tweetRepository.findByUser(userId));

        for (String followee : user.getFollowing()) {
            pq.addAll(tweetRepository.findByUser(followee));
        }

        List<Tweet> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < limit) {
            feed.add(pq.poll());
        }
        return feed;
    }
}

