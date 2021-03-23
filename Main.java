/*1) Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля :
- название курса
- дата старта занятий
- суммарное количество занятий
- количество занятий в неделю
- список учащихся типа Student у которого есть фамилия, имя, дата рождения и контакты.
Написать методы:
- метод который выдает название группы на основе даты старта и названия курса
- метод который выдает дату последнего занятия
- печатает список студентов по порядку в формате:
И. Иванов
П. Петров
С. Сидоров
- добавить студента
- узнать если ли студент с такой фамилией в группе
- удалить студента по фамилии или по номеру */

package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Students> students = new ArrayList();

        Students ivan = new Students("Иван", "Иванович", "Иванов",
                LocalDate.of(1972, 12, 17), "0630000000",
                Group.CourcesName.JAVA);
        students.add(ivan);

        students.add(new Students("Борис", "Борисович", "Борисов",
                LocalDate.of(1982, 12, 17), "0830000000",
                Group.CourcesName.JAVA));
        students.add(new Students("Петр", "Петрович", "Васюков",
                LocalDate.of(1962, 12, 17), "0670000000",
                Group.CourcesName.JAVA));
        students.add(new Students("Иван", "Петрович", "Васюков",
                LocalDate.of(1960, 01, 17), "0670000000",
                Group.CourcesName.JAVA));
        students.add(new Students("Иван", "Петрович", "Быков",
                LocalDate.of(1960, 01, 17), "0670000000",
                Group.CourcesName.JAVA));

        Group group1 = new Group(Group.CourcesName.JAVA, LocalDate.of(2021, 01, 01),
                14, 2, students);

        Group group2 = new Group(Group.CourcesName.SQL, LocalDate.of(2022, 01, 01),
                28, 2, students);

        System.out.println(group1.nameGroup() + ", " + group2.nameGroup());

        try {
            System.out.println(group1.dateLastLessons());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        group1.printStudents();

        System.out.println(group1.existInTheGroup(ivan));
        students.remove(ivan);
        System.out.println(group1.existInTheGroup(ivan));
        students.add(ivan);
        System.out.println(group1.existInTheGroup(ivan));
    }
}