package com.nighthawk.spring_portfolio.mvc.ai;

import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;
import com.pkslow.ai.domain.AnswerStatus;

import java.time.Duration;

public class GoogleBardExample {

    private AIClient client;

    public GoogleBardExample(String token) {
        this.client = new GoogleBardClient(token, Duration.ofMinutes(10));
    }

    public String askQuestion(String question) {
        Answer answer = client.ask(question);
        return getAnswerText(answer);
    }

    private static String getAnswerText(Answer answer) {
        if (answer.getStatus() == AnswerStatus.OK) {
            return answer.markdown();
        } else {
            return "No Answer";
        }
    }
}
