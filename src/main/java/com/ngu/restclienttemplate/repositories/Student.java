package com.ngu.restclienttemplate.repositories;

/**
 * Пока не используется. Будет нужен для маппинга таблицы user.
 */
public class Student {

    private String name;
    private Integer age;

    private String number;

    public Student(){}
    public Student(String name, Integer age, String number) {
        this.number = number;
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
