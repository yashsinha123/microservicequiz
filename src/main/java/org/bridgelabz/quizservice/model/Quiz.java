package org.bridgelabz.quizservice.model;

import lombok.*;
import org.bridgelabz.questionservice.model.Question;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.util.List;
@Table(name= "quiz")
@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    @Column("quiz_id")
    private Long quizId;
    private String title;
    @Column("description")
    private  String desc;
    private List<Question> questions;


    public Quiz(Long quizId, String title, String desc, List<Question> questions) {
        this.quizId = quizId;
        this.title = title;
        this.desc = desc;
        this.questions = questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;

    }
    //

//    public Quiz(Quiz quiz, List<Question> questions) {
//    }
}
