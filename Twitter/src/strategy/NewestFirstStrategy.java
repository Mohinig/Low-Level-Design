package strategy;

import dto.Tweet;

import java.util.Comparator;

public class NewestFirstStrategy implements FeedStrategy {
    public Comparator<Tweet> getComparator() {
        return Comparator.comparing(Tweet::getTime).reversed();
    }
}
