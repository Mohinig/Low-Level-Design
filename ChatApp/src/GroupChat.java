import java.util.List;

class GroupChat extends Chat {
    private String groupName;

    public GroupChat(String groupName, List<User> initialMembers) {
        super();
        this.groupName = groupName;
        this.users.addAll(initialMembers);
    }

    public void addMember(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeMember(User user) {
        users.remove(user);
    }

    @Override
    public String getName(User perspectiveUser) {
        return groupName;
    }
}