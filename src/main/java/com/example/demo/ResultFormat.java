package com.example.demo;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultFormat {
		private String type ;
		private String difficulty;
		private String question;
		@JsonProperty("all_answers")
		private ArrayList<String> allAnswers;
		@JsonProperty("correct_answer")
		private String correctAnswer;
		
		public String getType() {
			return this.type;
		
		}
		
		public String getDifficulty() {
			return this.difficulty;
		}
		
		public String getQuestion() {
			return this.question;
		}
		
		public ArrayList<String> getAllAnswers() {
			return this.allAnswers;
		}
		
		public String getCorrectAnswer() {
			return this.correctAnswer;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public void setDifficulty(String difficulty) {
			this.difficulty = difficulty;
		}
		
		public void setQuestion(String question) {
			this.question = question;
		}
		
		public void setAllAnswers(ArrayList<String> allAnswers) {
			this.allAnswers = allAnswers;
		}
		
		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}
		
		
}
