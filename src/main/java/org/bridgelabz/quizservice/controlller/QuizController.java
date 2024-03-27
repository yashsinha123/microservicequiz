package org.bridgelabz.quizservice.controlller;

import org.bridgelabz.quizservice.model.Quiz;
import org.bridgelabz.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/registerquiz")
    Mono<Quiz> RegisterQuiz(@RequestBody Quiz quiz){
        return quizService.SaveQuiz(quiz);
    }
    @GetMapping("/GetAllQuiz")
    Flux<Quiz> GetAll(){
        return  quizService.GetQuiz();
    }
    @GetMapping("/getById/{quizId}")
    Mono<Quiz> GetById(@PathVariable long quizId){
        return quizService.GetQuizbyID(quizId);
    }
    @GetMapping("/get/{quizId}")
    public Flux<Quiz> getqueswithquiz(@PathVariable String quizId){
        return  quizService.getQuizWithQuestions(Long.parseLong(quizId));
    }





}
