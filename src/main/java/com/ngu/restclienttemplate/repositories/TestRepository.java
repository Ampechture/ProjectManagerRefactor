package com.ngu.restclienttemplate.repositories;

import com.ngu.restclienttemplate.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}
