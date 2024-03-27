package org.bridgelabz.quizservice.service;

import org.bridgelabz.questionservice.model.Question;
import org.bridgelabz.quizservice.model.Quiz;
import org.bridgelabz.quizservice.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private WebClient.Builder webClientBuilder;
   // private final WebClient quizWebClient;
   //private final WebClient questionWebClient;
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    public QuizServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Flux<Quiz> getQuizWithQuestions(Long quizId) {
        // Assuming the questions microservice endpoint is "/questions/getbyquizid/{quizId}"
        Flux<Question> questionFlux = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/questions/getbyquizid/{quizId}", quizId)
                .retrieve()
                .bodyToFlux(Question.class);

        return questionFlux.collectList().flatMapMany(questions ->
                getQuizData(quizId).map(quiz -> {
                    quiz.setQuestions(questions);
                    return quiz;
                })
        );
    }

    private Mono<Quiz> getQuizData(Long quizId) {
        // Assuming the quiz microservice endpoint is "/quiz/getById/{quizId}"
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/Quiz/getById/{quizId}", quizId)
                .retrieve()
                .bodyToMono(Quiz.class);
    }


    @Override
    public Mono<Quiz> SaveQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Flux<Quiz> GetQuiz() {
        return quizRepo.findAll();
    }

    @Override
    public Mono<Quiz> GetQuizbyID(long quizId) {
        return quizRepo.findById((int) quizId);
    }


}
