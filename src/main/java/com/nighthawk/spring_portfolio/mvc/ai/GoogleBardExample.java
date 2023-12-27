package com.nighthawk.spring_portfolio.mvc.ai;

import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;
import com.pkslow.ai.domain.AnswerStatus;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class GoogleBardExample {
    public static void main(String[] args) {
        String token = "eAhIiu0w8muSSVRFVqMHMywUgUrdWz0RjLohT4sptxpNCIe-QQj_GAgO45A0LLfCnIOBJw.;sidts-CjIBPVxjSsvdCRnxtXTZBM-GVuqXgiJfJ5fLgLw582nOp6yw00PEmnZOFgYUSzD4J9nmgxAA";
        AIClient client = new GoogleBardClient(token, Duration.ofMinutes(10));

        printChosenAnswer(client.ask("What do you get when you mix blue and red?"));
    }

    private static void printChosenAnswer(Answer answer) {
        if (answer.getStatus() == AnswerStatus.OK) {
            log.info("Markdown Output: \n {}", answer.markdown());
        } else {
            log.info("No Answer: {}", answer);
        }
    }
}
