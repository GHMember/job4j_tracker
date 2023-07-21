package ru.job4j.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {

    private final String separator = System.lineSeparator();
    private static final List<Comment> COMMENTS = new ArrayList<>();
    private List<String> phrases;
    private final UserGenerator userGenerator;
    private final Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read("src/main/java/ru/job4j/gc/leak/files/phrases.txt");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } finally {
            System.out.println();
        }
    }

    public static List<Comment> getComments() {
        return COMMENTS;
    }

    @Override
    public void generate() {
        COMMENTS.clear();
        for (int i = 0; i < 50; i++) {
            String comment = String.format("%s%s%s%s%s",
                    phrases.get(random.nextInt(phrases.size())), separator,
                    phrases.get(random.nextInt(phrases.size())), separator,
                    phrases.get(random.nextInt(phrases.size())));
                    COMMENTS.add(new Comment(comment, userGenerator.randomUser()));
        }
    }
}
