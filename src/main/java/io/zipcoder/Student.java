package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return this.examScores;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScoresString() {
        StringBuilder examsOut = new StringBuilder();
        examsOut.append("Exam Scores: \n");

        double currScore = 0;
        for (int i = 0; i < examScores.size(); i++) {
            currScore = examScores.get(i);
            examsOut.append(String.format("%5s Exam %d -> %-3.0f \n",
                    " ", i, currScore));
        }

        return String.valueOf(examsOut);
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        this.examScores.set(examNumber - 1, newScore);
    }

    public Double getAverageExamScore() {

        Iterator<Double> itr = this.examScores.iterator();
        double sum = 0;
        while(itr.hasNext()) {
            sum += itr.next();
        }

        return sum / this.examScores.size();
    }

    @Override
    public String toString() {
        return String.format(
                "Student Name: %s %s \n" +
                "> Average Score: %3.0f \n" +
                "> %s \n",
                firstName, lastName,
                getAverageExamScore(),
                getExamScoresString());
    }

}
