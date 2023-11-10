package MiniTwitter;

import java.util.*;

public class NotificationService {
    private List<User> followers;

    public NotificationService() {
        followers = new ArrayList<>();
    }

    public void subscribe(User u) {
        followers.add(u);
    }

    public void unsubcribe(User u) {
        followers.remove(u);
    }

    public void newFeed(User u, String msg) {
        followers.forEach(user -> user.update(u, msg));
    }
}
