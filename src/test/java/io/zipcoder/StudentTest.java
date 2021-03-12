package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetNumberOfExamsTaken() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        int actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testGetExamScoresString() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScoresString();

        // Then
        System.out.println(output);
    }

    @Test
    public void testAddExamScore() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100);
        String output = student.getExamScoresString();

        // Then
        System.out.println(output);

    }

    @Test
    public void testSetExamScore() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScoresString();

        // Then
        System.out.println(output);
    }

    @Test
    public void testGetAverageExamScore() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void testToStringOverride() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }

}