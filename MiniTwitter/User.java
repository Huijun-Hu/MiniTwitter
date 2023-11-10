package MiniTwitter;

import java.util.*;

public class User {
    private int id;
    private String userName;
    private List<Integer> followers;
    private List<Integer> followings;
    private final NotificationService notificationService;

    public User(int id, String name) {
        this.id = id;
        userName = name;
        followers = new ArrayList<>();
        followings = new ArrayList<>();
        followings.add(id);
        notificationService = new NotificationService();
    }

    public int getID() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void update() {
        // see new feed
    }
    // feed list

    // postFeed()
    //
}
// Users can choose to follow other users (not user groups) by providing the
// target user

// Users can also post a short Tweet message (a String), so that all the
// followers can see
// this message in their news feed lists. Of course, the user can also see his
// or her own
// posted messages
