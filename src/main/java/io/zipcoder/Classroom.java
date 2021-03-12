package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Classroom {
    private Student[] students;

    public Classroom (Student[] students) {
        this.students = students;
    }

    public Classroom (int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {

        double sum = 0.0;
        for (Student student : students) {
            sum += student.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student newStudent) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = newStudent;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getFirstName() == firstName && this.students[i].getLastName() == lastName) {
                for (int j = i; j < this.students.length - 1; j++) {
                    this.students[j] = this.students[j+1];
                }

                this.students[this.students.length - 1] = null;
                break;
            }
        }
    }

    public Student[] getStudentByScore() {
        ArrayList<Student> lst = new ArrayList<Student>(Arrays.asList(this.students));
        Comparator<Student> compScore = new Comparator<Student>;

    }
}
