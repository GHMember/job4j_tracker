package ru.job4j.cache;

import java.io.*;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringJoiner value = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(cachingDir + "/" + key))) {
            reader.lines().forEach(value::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value.toString();
    }

    public String getText(String key) {
        put(key, load(key));
        return get(key);
    }

}
