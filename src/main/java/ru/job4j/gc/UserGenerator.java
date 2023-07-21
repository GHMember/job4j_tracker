package ru.job4j.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class UserGenerator implements Generate {

    private List<String> names;
    private List<String> surnames;
    private List<String> patrons;
    private final List<User> users = new ArrayList<>();
    private final Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < 1000; i++) {
            StringJoiner sj = new StringJoiner(" ");
            sj.add(surnames.get(random.nextInt(surnames.size())));
            sj.add(names.get(random.nextInt(names.size())));
            sj.add(patrons.get(random.nextInt(patrons.size())));
            users.add(new User(sj.toString()));
        }
    }

    private void readAll() {
        try {
            names = read("src/main/java/ru/job4j/gc/leak/files/names.txt");
            surnames = read("src/main/java/ru/job4j/gc/leak/files/surnames.txt");
            patrons = read("src/main/java/ru/job4j/gc/leak/files/patr.txt");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } finally {
            System.out.println();
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public List<User> getUsers() {
        return users;
    }
}
