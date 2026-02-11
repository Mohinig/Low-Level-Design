package strategy;

import dto.Tweet;

import java.util.Comparator;

public class MostLikedStrategy implements FeedStrategy {
    public Comparator<Tweet> getComparator() {
        return (a, b) -> Integer.compare(b.getLikes(), a.getLikes());
    }
}

