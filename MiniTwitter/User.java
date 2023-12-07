package MiniTwitter;

import java.util.*;
import GUI.UserFrame;

public class User extends Member {

    private List<User> followers;
    private List<User> followings;
    private final NotificationService notificationService;
    private Dictionary<User, String> feedList;
    private UserFrame window;
    private long lastUpdateTime;

    public User(int id, String name) {
        super(id, name);

        followers = new ArrayList<>();
        followings = new ArrayList<>();
        feedList = new Hashtable<>();
        notificationService = new NotificationService(this);

    }

    public void setWindow(UserFrame w) {
        this.window = w;
    }

    public UserFrame getWindow() {
        return this.window;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setLastUpdateTime(long time){
        lastUpdateTime = time;
    }

    public long getLastUpdateTime(){
        return lastUpdateTime;
    }

    public List<String> getFeedList() {
        List<String> msgs = new ArrayList<>();

        Enumeration<User> e = feedList.keys();
        while (e.hasMoreElements()) {
            User u = e.nextElement();
            msgs.add(u.getName() + " : " + feedList.get(u));
        }
        return msgs;
    }

    public void follow(User u) {
        this.followings.add(u);
        u.beFollowedBy(this);
    }

    public void beFollowedBy(User u) {
        this.followers.add(u);
    }

    public void postFeed(String msg) {
        feedList.put(this, msg);
        this.setLastUpdateTime(System.currentTimeMillis());
        notificationService.newFeed(this, msg);
    }

    public void update(User u, String msg) {
        feedList.put(u, msg);
        this.setLastUpdateTime(u.getLastUpdateTime());
        window.updateFeed(u, msg);
    }

    @Override
    public int accept(Visitor v) {
        return v.visit(this);
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration<Member> children() {
        return null;
    }
}
