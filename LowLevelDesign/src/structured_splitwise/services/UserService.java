package structured_splitwise.services;

import structured_splitwise.entities.User;
import structured_splitwise.repositories.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = this.userRepository;
    }

    //add-user
    public void addUser(User user) {
        if(user == null) {
            throw new RuntimeException("User Not found");
        }
        userRepository.save(user);
    }

    //getUserById
    public User getUserById(String userID) {
        return userRepository.findById(userID);
    }

    //getAllUser
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
