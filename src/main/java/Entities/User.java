package main.java.Entities;

import java.util.HashMap;
import java.util.TreeSet;

public class User {

    int userId;
    String userAlias;
    HashMap<String,TreeSet<Roles>> ResourceVsRoles; //TreeSet used to order roles from least expansive to most expansive

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public HashMap<String, TreeSet<Roles>> getResourceVsRoles() {
        return ResourceVsRoles;
    }

    public void setResourceVsRoles(HashMap<String, TreeSet<Roles>> resourceVsRoles) {
        ResourceVsRoles = resourceVsRoles;
    }
}
