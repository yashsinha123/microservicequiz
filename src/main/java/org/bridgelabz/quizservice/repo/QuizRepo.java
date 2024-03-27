package org.bridgelabz.quizservice.repo;

import org.bridgelabz.quizservice.model.Quiz;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface QuizRepo extends R2dbcRepository<Quiz,Integer> {

    //Mono<Quiz> findByQuizId(long id);
}
