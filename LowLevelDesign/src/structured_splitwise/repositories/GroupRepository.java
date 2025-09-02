package structured_splitwise.repositories;

import structured_splitwise.entities.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {

    //map<string, group> : groupId --> group
    private final Map<String, Group> groupMap = new HashMap<>();

    public void save(Group group) {
        groupMap.put(group.getGroupId(), group);
    }

    public Group findById(String groupId) {
        return groupMap.get(groupId);
    }

    public List<Group> findAll() {
        return new ArrayList<>(groupMap.values());
    }
}
