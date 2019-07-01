package main.java.AccessControlService;

public interface AccessControlService {

    boolean authorize(String user, String resource, String accessType);
}
