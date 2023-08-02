package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dfc = new DirFileCache("docs");
        System.out.println(dfc.getText("test.txt"));
    }
}