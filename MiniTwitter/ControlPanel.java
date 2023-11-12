package MiniTwitter;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import GUI.MainFrame;

//Singleton pattern
public class ControlPanel {
    protected static ControlPanel instance;
    private HashMap<Integer, User> UserBank;

    private static JFrame frame;

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
        frame = new MainFrame();
        UserBank = new HashMap<>();

    }

    public void addUser(Integer id, String name, DefaultMutableTreeNode parent) {

        parent.add(new DefaultMutableTreeNode(new User(id, name)));
    }

    public void addGroup(Integer id, String name, DefaultMutableTreeNode parent) {

        UserGroup obj = (UserGroup) parent.getUserObject();
        UserGroup m = new UserGroup(id, name);
        obj.addMember(m);
        parent.add(new DefaultMutableTreeNode(m, true));

    }

    public void countTotalUser(DefaultMutableTreeNode rootNode) {

        Member m = (Member) rootNode.getUserObject();
        System.out.print(m.getChildCount());
    }

    public void countTotalGroup(DefaultMutableTreeNode rootNode) {

    }

    // public int countUsers()
    // public int countGroups()
    // public int countFeed()

    // public String positivity()

    // create users and user groups
    // 1) output the total number of users;
    // 2) output the total number of groups;
    // 3) output the total number of Tweet messages in all the users’ news feed;
    // 4) output the percentage of the positive
    // Tweet messages in all the users’ news feed (the message containing positive
    // words,
    // such as good, great, excellent, etc.) Free free to decide the positive word
}
