package MiniTwitter;

import java.util.*;

public class User extends Member {

    private List<User> followers;
    private List<User> followings;
    private final NotificationService notificationService;
    private Dictionary<User, String> feedList;

    public User(int id, String name) {
        super(id, name);
        followers = new ArrayList<>();
        followings = new ArrayList<>();
        notificationService = new NotificationService();
        feedList = new Hashtable<>();
    }

    // public int getID() {
    // return id;
    // }

    // public String getUserName() {
    // return userName;
    // }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public Dictionary<User, String> getFeedList() {
        return feedList;
    }

    public void postFeed(String msg) {
        feedList.put(this, msg);
        notificationService.newFeed(this, msg);
    }

    public void update(User u, String msg) {
        feedList.put(u, msg);
    }

}
// Users can choose to follow other users (not user groups) by providing the
// target user

// Users can also post a short Tweet message (a String), so that all the
// followers can see
// this message in their news feed lists. Of course, the user can also see his
// or her own
// posted messages
