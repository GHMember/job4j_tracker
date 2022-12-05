package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.getScore();
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                score += subject.getScore();
            }
            list.add(new Label(pupil.name(), score / count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.getName(), 0);
                score += subject.getScore();
                map.put(subject.getName(), score);
            }
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            rsl.add(new Label(item.getKey(), (double) item.getValue() / map.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double score = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.getScore();
            }
            list.add(new Label(pupil.name(), score));
            score = 0D;
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.getName(), 0);
                score += subject.getScore();
                map.put(subject.getName(), score);
            }
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            list.add(new Label(item.getKey(), (double) item.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}