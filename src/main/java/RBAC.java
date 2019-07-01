package main.java;

import main.java.AccessControlService.AccessControlService;
import main.java.AccessControlService.AccessControlServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBAC {

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Load roles and user details
        AccessControlService acs = new AccessControlServiceImpl();

        try {
            //Take input and check if entered data is valid
            System.out.println("Enter number of cases");
            String input = br.readLine();
            System.out.println("Enter User, Resource, Action in each line in same order and press enter afterwards");
            int cases = Integer.parseInt(input.trim());
            for (int i = 0; i <cases; i++) {
                System.out.println("Enter User name");
                String user= br.readLine();
                System.out.println("Enter Resource name");
                String resource = br.readLine();
                System.out.println("Enter AccessType");
                String accessType = br.readLine();

                System.out.println(acs.authorize(user, resource, accessType));
            }

        }catch (IOException e){
            System.out.println("IO failure");
            System.out.println(e.getMessage());
        }

    }
}
