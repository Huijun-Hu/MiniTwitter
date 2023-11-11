package MiniTwitter;

import java.util.*;

public class NotificationService {
    private List<User> followerList;

    public NotificationService(User u) {
        this.followerList = u.getFollowers();
    }

    public void newFeed(User u, String msg) {
        followerList.forEach(user -> user.update(u, msg));
    }
}
