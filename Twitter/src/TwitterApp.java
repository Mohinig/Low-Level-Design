import repo.InMemoryTweetRepository;
import repo.InMemoryUserRepository;
import repo.TweetRepository;
import repo.UserRepository;
import service.FeedService;
import service.TweetService;
import service.UserService;
import strategy.MostLikedStrategy;
import strategy.NewestFirstStrategy;

public class TwitterApp {
    public static void main(String[] args) {

        UserRepository userRepo = new InMemoryUserRepository();
        TweetRepository tweetRepo = new InMemoryTweetRepository();

        UserService userService = new UserService(userRepo);
        TweetService tweetService = new TweetService(tweetRepo);
        FeedService feedService = new FeedService(userRepo, tweetRepo);

        String u1 = userService.createUser("mohinig");
        String u2 = userService.createUser("pinakis");

        userService.follow(u1, u2);

        String t1 = tweetService.postTweet(u2, "Hello from u2");
        String t2 = tweetService.postTweet(u2, "Another tweet");

        tweetService.likeTweet(t1);
        tweetService.likeTweet(t1);

        System.out.println("Newest Feed:");
        System.out.println(feedService.getFeed(u1,
                new NewestFirstStrategy(), 10));

        System.out.println("Most Liked Feed:");
        System.out.println(feedService.getFeed(u1,
                new MostLikedStrategy(), 10));
    }
}
