package main.java.StorageService;

import main.java.Entities.AccessTypes;
import main.java.Entities.Resource;
import main.java.Entities.Roles;

import java.util.EnumSet;
import java.util.HashMap;

public class ResourceStore {

    HashMap<String,Resource> resourceStore = new HashMap<>();

    public ResourceStore(){
        Resource S3 = new Resource();
        S3.resourceName="S3";
        HashMap<Roles, EnumSet<AccessTypes>> rolesToAccess = new HashMap<>();
        EnumSet<AccessTypes> adminRole = EnumSet.allOf(AccessTypes.class);
        EnumSet<AccessTypes> observerRole = EnumSet.of(AccessTypes.READ);
        EnumSet<AccessTypes> supportRole = EnumSet.of(AccessTypes.MODIFY_SCALING, AccessTypes.REBOOT_SERVER, AccessTypes.SUPPORT_OWNER, AccessTypes.UPDATE_SERVER, AccessTypes.VIEW_SERVER);
        rolesToAccess.put(Roles.ADMIN,adminRole);
        rolesToAccess.put(Roles.OBSERVER, observerRole);
        rolesToAccess.put(Roles.SUPPORT, supportRole);
        S3.RolesvsAccessTypes=rolesToAccess;
    }

    public Resource getResource(String resourceName){
        return resourceStore.get(resourceName);
    }
}
