package main.java.AccessControlService;

import main.java.Entities.AccessTypes;
import main.java.Entities.Resource;
import main.java.Entities.Roles;
import main.java.Entities.User;
import main.java.StorageService.ResourceStore;
import main.java.StorageService.UserStore;

import java.util.Iterator;
import java.util.TreeSet;

public class AccessControlServiceImpl implements AccessControlService{

    UserStore userStore = new UserStore();
    ResourceStore resourceStore = new ResourceStore();


    @Override
    public boolean authorize(String user, String resource, String accessType) {
        User requestor = userStore.get(user);

        if(requestor==null)
            return false;

        AccessTypes accType;
        try {
            accType = AccessTypes.valueOf(accessType.toUpperCase());
        }catch (IllegalArgumentException e){
            System.out.println("Invalid AccessType");
            return false;
        }

        TreeSet<Roles> roles = requestor.getResourceVsRoles().get(resource);

        Resource targetResource = resourceStore.getResource(resource);

        Iterator<Roles> userRoleIterator= roles.iterator();
        while(userRoleIterator.hasNext()){
            Roles currRole = userRoleIterator.next();
            if(targetResource.RolesvsAccessTypes.get(currRole)!=null && targetResource.RolesvsAccessTypes.get(currRole).contains(accType))
                return true;
        }

        return false;
    }
}
