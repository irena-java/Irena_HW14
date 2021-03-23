package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    public enum CourcesName {
        JAVA, SQL, PYTHON
    }

    private CourcesName courcesName;
    private LocalDate dateOfBeginingOfCourse;
    private int lessonsPerCource;
    private int lessonsPerWeek;
    private ArrayList<Students> students;


    public Group(CourcesName courcesName, LocalDate dateOfBeginingOfCourse,
                 int lessonsPerCource, int lessonsPerWeek, ArrayList<Students> students) {
        this.courcesName = courcesName;
        this.dateOfBeginingOfCourse = dateOfBeginingOfCourse;
        this.setLessonsPerCource(lessonsPerCource);
        this.setLessonsPerWeek(lessonsPerWeek);
        this.students = students;
    }

    public void setLessonsPerWeek(int lessonsPerWeek) {
        if ((lessonsPerWeek > 7 || lessonsPerWeek < 0)) {
            throw new IllegalArgumentException("Кол-во дней в неделю некорректное");
        } else {
            this.lessonsPerWeek = lessonsPerWeek;
        }
    }

    public void setLessonsPerCource(int lessonsPerCource) {
        if (lessonsPerCource < 1) {
            throw new IllegalArgumentException("Кол-во уроков некорректное");
        } else {
            this.lessonsPerCource = lessonsPerCource;
        }
    }

    public CourcesName getCourcesName() {
        return courcesName;
    }

    public LocalDate getDateOfBeginingOfCourse() {
        return dateOfBeginingOfCourse;
    }

    public int getLessonsPerCource() {
        return lessonsPerCource;
    }

    public int getLessonsPerWeek() {
        return lessonsPerWeek;
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "courcesName=" + courcesName +
                ", dateOfBeginingOfCourse=" + dateOfBeginingOfCourse +
                ", lessonsPerCource=" + lessonsPerCource +
                ", lessonsPerWeek=" + lessonsPerWeek +
                ", students=" + students +
                '}';
    }

    public String nameGroup() {
        return "Группа: " +
                String.valueOf(courcesName) +
                " (старт " +
                dateOfBeginingOfCourse.toString() +
                ")";
    }

    public LocalDate dateLastLessons() throws IllegalArgumentException {
        if (lessonsPerCource % lessonsPerWeek == 0) {
            return dateOfBeginingOfCourse.plusWeeks(lessonsPerCource / lessonsPerWeek);
        } else
            throw new IllegalArgumentException("Конкр.дата окончания курса не определена, " +
                    "т.к. количество недель занятий не целое, а нет конкретного графика занятий");
    }

    public void printStudents() {
        String[] sortedStudents = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            sortedStudents[i] = students.get(i).getName().substring(0, 1).concat(".")
                    .concat(students.get(i).getSurName());
        }
        Arrays.sort(sortedStudents);
        System.out.println(Arrays.toString(sortedStudents));
    }

    public void addStudent(Students students) {
        this.students.add(students);
    }

    public void deleteStudent(Students students) {
        this.students.remove(students);
    }

    public boolean existInTheGroup(Students student) {
        if (this.students.contains(student)) {
            return true;
        } else {
            return false;
        }
    }
}

