package MiniTwitter;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import GUI.MainFrame;

//Singleton pattern
public class ControlPanel {
    protected static ControlPanel instance;
    private HashMap<Integer, User> UserBank = new HashMap<>();
    private List<String> feedBank = new ArrayList<>();

    protected ControlPanel() {
        // initialize();
    }

    public static ControlPanel getInstance() {
        if (instance == null) {
            instance = new ControlPanel();
        }
        return instance;
    }

    public void initialize() {
        // frame = new MainFrame();
        // UserBank = new HashMap<>();
        // UserBank.put(12345, new User(12345, "Tracy"));
        // UserBank.put(11, new User(11, "joe"));

    }

    public HashMap<Integer, User> getUserBank() {
        return this.UserBank;
    }

    public void addUser(Integer id, String name, DefaultMutableTreeNode parent) {

        UserGroup obj = (UserGroup) parent.getUserObject();
        User u = new User(id, name);
        obj.addMember(u);
        UserBank.put(id, u);
        parent.add(new DefaultMutableTreeNode(u));
    }

    public void addGroup(Integer id, String name, DefaultMutableTreeNode parent) {

        UserGroup obj = (UserGroup) parent.getUserObject();
        UserGroup m = new UserGroup(id, name);
        obj.addMember(m);
        parent.add(new DefaultMutableTreeNode(m, true));

    }

    public void storePost(String s) {
        feedBank.add(s);
    }

    public int countUsers() {
        return UserBank.size();
    }

    public int countGroups() {
        return 0;
    }

    public int countFeed() {
        return feedBank.size();
    }

    public String positivity() {
        int pos = 0;
        for (String s : feedBank) {
            if (s.contains("happy") || s.contains("good") || s.contains("nice") || s.contains("excellent")
                    || s.contains("great")) {
                pos += 1;
            }
        }
        return "Post Positivity: " + pos * 100 / countFeed() + "%";
    }

    // create users and user groups
    // 1) output the total number of users;
    // 2) output the total number of groups;
    // 3) output the total number of Tweet messages in all the users’ news feed;
    // 4) output the percentage of the positive
    // Tweet messages in all the users’ news feed (the message containing positive
    // words,
    // such as good, great, excellent, etc.) Free free to decide the positive word
}
