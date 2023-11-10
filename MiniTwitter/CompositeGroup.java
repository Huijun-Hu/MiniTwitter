package MiniTwitter;

import java.util.*;

public class CompositeGroup extends UserGroup {
    private List<Member> members;

    public CompositeGroup(int id, String name) {
        super(id, name);
        members = new ArrayList<>();
    }

    public int totalMember() {
        int sum = 0;

        for (Member m : members) {
            sum += m.size();
        }

        return sum;
    }
}
