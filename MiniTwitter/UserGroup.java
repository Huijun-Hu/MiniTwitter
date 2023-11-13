package MiniTwitter;

import java.util.*;
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
    public int accept(Visitor v) {
        return v.visit(this);
    }

    @Override
    public int getChildCount() {
        // use visitor pattern to count child and difficiate different child type
        return 0;
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
