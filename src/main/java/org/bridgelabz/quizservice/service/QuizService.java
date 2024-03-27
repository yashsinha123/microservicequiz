package org.bridgelabz.quizservice.service;

import org.bridgelabz.quizservice.model.Quiz;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizService {


    Mono<Quiz> SaveQuiz(Quiz quiz);

    Flux<Quiz> GetQuiz();

    Mono<Quiz> GetQuizbyID(long quizId);
    Flux<Quiz> getQuizWithQuestions(Long quizId);
}
