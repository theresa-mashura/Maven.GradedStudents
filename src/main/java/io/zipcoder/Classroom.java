package io.zipcoder;

import java.util.*;

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
        Comparator<Student> sortByGrade = Comparator.comparing(Student::getAverageExamScore).thenComparing(Student::getFirstName);
        List<Student> studentsSorted = new ArrayList<>(Arrays.asList(this.students));
        Collections.sort(studentsSorted, sortByGrade);

        Student[] studentsByScore = new Student[studentsSorted.size()];
        studentsByScore = studentsSorted.toArray(studentsByScore);

        return studentsByScore;
    }

    public HashMap getGradeBook() {
        Student[] studentsByScore = this.getStudentByScore();
        HashMap<Student, String> gradeBook = new HashMap<Student, String>();

        double percentile = 0;
        for (int i = 0; i < studentsByScore.length; i++) {
                percentile = (double) (1 - ( (i + 1) / studentsByScore.length )) * 100;
                if (percentile < 10) {
                    gradeBook.put(studentsByScore[i], "A");
                } else if (percentile < 29) {
                    gradeBook.put(studentsByScore[i], "B");
                } else if (percentile < 50) {
                    gradeBook.put(studentsByScore[i], "C");
                } else if (percentile < 89) {
                    gradeBook.put(studentsByScore[i], "D");
                } else {
                    gradeBook.put(studentsByScore[i], "F");
                }
        }

        return gradeBook;

    }

}
