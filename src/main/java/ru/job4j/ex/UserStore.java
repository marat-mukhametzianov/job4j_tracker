package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                result = users[i];
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("There is no user whith the such login.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("The user is not valid.");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("The user login length is not enough.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr", true)};
        User user = null;
        try {
            user = findUser(users, "Petr");
            if (validate(user)) {
                System.out.println("This user has an access.");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
