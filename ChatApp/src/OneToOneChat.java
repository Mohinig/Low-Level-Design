import java.util.List;

public class OneToOneChat extends  Chat{
    public OneToOneChat(User user1,User user2) {
        super();
        this.users.addAll(List.of(user1,user2));
    }

    @Override
    public String getName(User perspectiveUser) {
        return users.stream()
                .filter(member->!member.equals(perspectiveUser))
                .findFirst()
                .map(User::getName)
                .orElse("UnknowChat");
    }
}
