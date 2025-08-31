package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double averageScore = 0.0;
        int subjectsAmount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averageScore += subject.score();
                subjectsAmount++;
            }
        }
        return averageScore / subjectsAmount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double averageScore = 0.0;
        int subjectAmount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averageScore += subject.score();
                subjectAmount++;
            }
            list.add(new Label(pupil.name(), averageScore / subjectAmount));
            averageScore = 0.0;
            subjectAmount = 0;
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        int pupilsSize = pupils.size();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.put(subject.name(), subject.score() + subjectScore.getOrDefault(subject.name(), 0));
            }
        }
        for (String subject : subjectScore.keySet()) {
            labels.add(new Label(subject,  (double) subjectScore.get(subject) / pupilsSize));
        }

        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        double scoreAmount = 0.0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreAmount += subject.score();
            }
            list.add(new Label(pupil.name(), scoreAmount));
            scoreAmount = 0.0;
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.put(subject.name(), subject.score() + subjectScore.getOrDefault(subject.name(), 0));
            }
        }
        for (String subject : subjectScore.keySet()) {
            labels.add(new Label(subject,  subjectScore.get(subject)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}