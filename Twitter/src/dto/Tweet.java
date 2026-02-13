package dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tweet {
    String id;
    String content;
    LocalDateTime time;
    String userId;
    int likes;
    int dislikes;
    public Tweet(String content,String userid) {
        this.id= UUID.randomUUID().toString();
        this.content = content;
        this.time=LocalDateTime.now();
        this.userId=userid;
        this.likes=0;
        this.dislikes=0;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getUserId() {
        return userId;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void like(){
        likes++;
    }
    public void unlike(){
        dislikes++;
    }
    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", userId='" + userId + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
