package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        System.out.println("Enter directory name: ");
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.nextLine();
        DirFileCache dfc = new DirFileCache(dirName);
        while (true) {
            System.out.println("Enter file name to get text or enter \"out\" to exit: ");
            String fileName = scanner.nextLine();
            if (fileName.equalsIgnoreCase("out")) {
                scanner.close();
                break;
            }
            System.out.println(dfc.getText(fileName));
        }
    }
}