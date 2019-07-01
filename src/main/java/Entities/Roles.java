package main.java.Entities;


public enum Roles {
    OBSERVER, SUPPORT , CONTRIBUTOR, OWNER, ADMIN // Order is important here as we use ordinal to sort min to max roles to check for
}
