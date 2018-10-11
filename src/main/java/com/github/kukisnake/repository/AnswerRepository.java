package com.github.kukisnake.repository;

import com.github.kukisnake.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

}
