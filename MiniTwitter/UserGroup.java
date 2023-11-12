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

    public List<Member> getMembers() {
        return this.members;
    }

    public void addMember(Member m) {
        members.add(m);
    }

    @Override
    public int getSize() {
        return this.getChildCount();
    }

    @Override
    public int getChildCount() {
        int sum = 0;

        while (this.children().hasMoreElements()) {
            sum += this.children().nextElement().getSize();
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
    public Enumeration<Member> children() {
        Enumeration<Member> e = Collections.enumeration(members);
        return e;
    }

}
