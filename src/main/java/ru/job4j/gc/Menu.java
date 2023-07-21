package ru.job4j.gc;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Menu {

    public static void main(String[] args) {
        Random random = new Random();
        UserGenerator userGenerator = new UserGenerator(random);
        CommentGenerator commentGenerator = new CommentGenerator(random, userGenerator);
        Scanner scanner = new Scanner(System.in);
        PostStore postStore = new PostStore();
        start(commentGenerator, scanner, userGenerator, postStore);
    }

    private static void start(CommentGenerator commentGenerator, Scanner scanner, UserGenerator userGenerator,
                              PostStore postStore) {
        boolean run = true;
        while (run) {
            StringJoiner sj = new StringJoiner(System.lineSeparator());
            sj.add("Введите 1 для создание поста.");
            sj.add("Введите 2, чтобы создать определенное количество постов.");
            sj.add("Введите 3, чтобы показать все посты.");
            sj.add("Введите 4, чтобы удалить все посты.");
            sj.add("Введите любое другое число для выхода.");
            System.out.println(sj);
            System.out.println("Выберите меню");
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            String textOfPost = "Введите текст";
            if (userChoice == 1) {
                System.out.println(textOfPost);
                String text = scanner.nextLine();
                userGenerator.generate();
                commentGenerator.generate();
                postStore.add(new Post(text, CommentGenerator.getComments()));
            } else if (userChoice == 2) {
                System.out.println(textOfPost);
                String text = scanner.nextLine();
                System.out.println("Выберите количество создаваемых постов");
                String count = scanner.nextLine();
                for (int i = 0; i < Integer.parseInt(count); i++) {
                    createPost(commentGenerator, userGenerator, postStore, text);
                }
            } else if (userChoice == 3) {
                System.out.println(PostStore.getPosts());
            } else if (userChoice == 4) {
                System.out.println("Все посты удалены");
                postStore.removeAll();
            } else {
                run = false;
                System.out.println("Конец работы");
            }
        }
    }

    private static void createPost(CommentGenerator commentGenerator,
                                   UserGenerator userGenerator, PostStore postStore, String text) {
        userGenerator.generate();
        commentGenerator.generate();
        postStore.add(new Post(text, CommentGenerator.getComments()));
    }
}
