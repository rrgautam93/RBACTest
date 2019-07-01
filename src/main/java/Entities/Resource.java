package main.java.Entities;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public class Resource {

    public int resourceID;
    public String resourceName;
    public HashMap<Roles,EnumSet<AccessTypes>> RolesvsAccessTypes;
}
