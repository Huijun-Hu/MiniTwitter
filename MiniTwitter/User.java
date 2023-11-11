package MiniTwitter;

import java.util.*;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class User extends Member {

    private List<User> followers;
    private List<User> followings;
    private final NotificationService notificationService;
    private Dictionary<User, String> feedList;
    private final int size = 1;

    public User(int id, String name) {
        super(id, name);
        notificationService = new NotificationService(this);

        followers = new ArrayList<>();
        followings = new ArrayList<>();
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

    public void follow(User u) {
        this.followings.add(u);
        u.beFollowedBy(this);

    }

    public void beFollowedBy(User u) {
        this.followers.add(u);
    }

    public void postFeed(String msg) {
        feedList.put(this, msg);
        notificationService.newFeed(this, msg);
    }

    public void update(User u, String msg) {
        feedList.put(u, msg);
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
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
    public Enumeration<? extends TreeNode> children() {
        return null;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
// Users can choose to follow other users (not user groups) by providing the
// target user

// Users can also post a short Tweet message (a String), so that all the
// followers can see
// this message in their news feed lists. Of course, the user can also see his
// or her own
// posted messages
