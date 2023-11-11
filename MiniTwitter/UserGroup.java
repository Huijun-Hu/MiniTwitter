package MiniTwitter;

import java.util.*;

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
    public TreeNode getChildAt(int childIndex) {
        return null;
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
    public TreeNode getParent() {
        return null;
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
}
// A user group has an unique ID, which can be used to group users. A user group
// can
// contain any number of users. The same user can only be included in one group.
// Of
// course, a user group can contain other user groups recursively. There is
// always a root
// group called Root to include everythin