package MiniTwitter;

import java.util.*;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class UserGroup extends Member {

    private List<Member> members;

    public UserGroup(int id, String name) {
        super(id, name);
        members = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int sum = 0;

        for (Member m : members) {
            sum += m.getSize();
        }

        return sum;
    }

    @Override
    public int getChildCount() {
        int sum = 0;
        while (this.children().hasMoreElements()) {
            sum += this.children().nextElement().getChildCount();
        }
        return sum;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        Enumeration<Member> e = Collections.enumeration(members);
        return e;
    }

    // @Override
    // public void insert(MutableTreeNode child, int index) {}

    // @Override
    // public void remove(int index) {}

    // @Override
    // public void remove(MutableTreeNode node) {}

    // @Override
    // public void setUserObject(Object object) {}

    // @Override
    // public void removeFromParent() {}

    // @Override
    // public void setParent(MutableTreeNode newParent) {}

    // @Override
    // public String toString() {
    // return this.getName();
    // }
}
