package splitwise.user;

public class User {

    String userId;
    String name;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
