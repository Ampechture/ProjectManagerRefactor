package com.ngu.restclienttemplate.service;

import com.ngu.restclienttemplate.repositories.Group;
import com.ngu.restclienttemplate.repositories.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    public List<Group> getGroups() {
        // TODO получать данные из БД
        return mock();
    }


    private List<Group> mock() {
        List<Group> groups = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Group group = new Group();
            group.setNumber(String.valueOf((int) (i * Math.random())));
            group.setCourse("Course - " + i);
            group.setStudents(generateMockStudents(group));
            groups.add(group);
        }
        return groups;
    }

    public List<Student> generateMockStudents(Group group) {
        List<Student> students = new ArrayList<>();
        for(String name : names) {
            Student student = new Student(name, ageGenerator(), group != null ? group.getNumber() : "2222222");
            students.add(student);
        }

        return students;
    }

    private int ageGenerator() {
        int min = 18;
        int max = 25;

        return  (int) (Math.random() * (max - min + 1)) + min;
    }

    private static List<String> names = List.of("Иван", "Кирилл", "Оля", "Ксюша", "Матвей");
}
