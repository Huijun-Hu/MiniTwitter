package MiniTwitter;

import java.util.*;

public class UserGroup {
    private int id;
    private String GroupName;

    public UserGroup(int id, String name) {
        this.id = id;
        this.GroupName = name;
    }

}
// A user group has an unique ID, which can be used to group users. A user group
// can
// contain any number of users. The same user can only be included in one group.
// Of
// course, a user group can contain other user groups recursively. There is
// always a root
// group called Root to include everythin