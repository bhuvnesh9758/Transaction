package com.springjpa.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<Topic,String> {

    @Query(value = "select * from topic where id={id}",nativeQuery = true)
     Topic findId(@Param(value = "id") String id);
}