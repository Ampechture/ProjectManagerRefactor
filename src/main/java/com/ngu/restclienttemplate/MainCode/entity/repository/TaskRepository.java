package com.ngu.restclienttemplate.MainCode.entity.repository;

import com.ngu.restclienttemplate.MainCode.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsByprojectName(String projectName);


    List<Task> findAllByuserId(Long userId);
}
