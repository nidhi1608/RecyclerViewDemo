package com.nesquena.recyclerviewdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    public String name;
    public String hometown;

    public User(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    public static ArrayList<User> getThronesCharacters() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Dany Targaryen", "Valyria"));
        users.add(new User("Rob Stark", "Winterfell"));
        users.add(new User("Jon Snow", "Castle Black"));
        users.add(new User("Tyrion Lanister", "King's Landing"));
        return users;
    }
}
