package io.zipcoder;

import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void testGetAverageExamScore() {
        // Given
        Double [] s1Scores = {100.0, 150.0, 75.0};
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);

    }

    @Test
    public void testAddStudent() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);

        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        // Then
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);

    }

    @Test
    public void testRemoveStudent() {
        // Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores2 = { 100.0, 150.0, 250.0, 0.0 };
        Student student2 = new Student("Andrew", "Bates", examScores);

        Double[] examScores3 = { 100.0, 150.0, 250.0, 0.0 };
        Student student3 = new Student("Ryan", "Hunter", examScores);

        // When
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        classroom.removeStudent("Leon", "Hunter");

        Student[] postRemoval = classroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(postRemoval);

        // Then
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }
}
