package MiniTwitter;

import java.util.*;

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
}
// A user group has an unique ID, which can be used to group users. A user group
// can
// contain any number of users. The same user can only be included in one group.
// Of
// course, a user group can contain other user groups recursively. There is
// always a root
// group called Root to include everythin