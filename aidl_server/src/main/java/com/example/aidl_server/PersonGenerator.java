package com.example.aidl_server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

    //    TODO does this need to be inserted into the database, populate
    PersonDatabase personDatabase;

    public List<Person> generate(int count) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            personList.add(new Person(getRandomName(), getRandomAge(), getRandomGender()));
        }

        return personList;
    }

    public static String getRandomName() {
        List<String> names = new ArrayList<>();
        names.add("Josh");
        names.add("Nathan");
        names.add("Assem");
        names.add("Keenan");
        names.add("Mikhail");
        names.add("Tim");
        names.add("Bernardo");

        return names.get(new Random().nextInt(names.size()));

    }

    public static String getRandomAge() {
        return String.valueOf(new Random().nextInt(40));
    }

    public static String getRandomGender() {
        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        return genders.get(new Random().nextInt(2));
    }

}
