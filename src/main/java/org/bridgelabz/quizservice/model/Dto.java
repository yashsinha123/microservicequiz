package org.bridgelabz.quizservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bridgelabz.questionservice.model.Question;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    private Quiz quiz;
    private List<Question> questions;
}
