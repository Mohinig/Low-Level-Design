package strategy;

import dto.Tweet;

import java.util.Comparator;

public interface FeedStrategy {
    Comparator<Tweet> getComparator();
}


