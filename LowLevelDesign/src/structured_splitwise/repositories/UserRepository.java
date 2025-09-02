package structured_splitwise.repositories;

import structured_splitwise.entities.Group;
import structured_splitwise.entities.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private List<User> userList = new ArrayList<>();

    // Save user
    public void save(User user) {
        userList.add(user);
    }

    // Find user by ID
    public User findById(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Return all users
    public List<User> findAll() {
        return userList;
    }
}
