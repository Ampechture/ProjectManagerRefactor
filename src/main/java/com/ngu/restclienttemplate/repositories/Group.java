package com.ngu.restclienttemplate.repositories;

import java.util.List;

/**
 * Пока не используется. Будет нужен для маппинга таблицы group.
 */

public class Group {
    private String number;

    private String course;
    private List<Student> students;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
