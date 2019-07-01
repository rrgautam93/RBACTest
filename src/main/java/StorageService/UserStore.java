package main.java.StorageService;

import main.java.Entities.Resource;
import main.java.Entities.Roles;
import main.java.Entities.User;

import java.util.HashMap;
import java.util.TreeSet;

public class UserStore {
    HashMap<String, User> store = new HashMap<>();

    public UserStore(){
        User one = new User();
        one.setUserId(1);
        one.setUserAlias("one");
        HashMap<String,TreeSet<Roles>> oneRoles = new HashMap<>();
        TreeSet<Roles> S3Roles = new TreeSet<>();
        S3Roles.add(Roles.SUPPORT);
        oneRoles.put("S3",S3Roles);
        one.setResourceVsRoles(oneRoles);
    }
    public User get(String username){
        return store.get(username);
    }

    public void put(User user){
        store.put(user.getUserAlias(),user);
    }
}
