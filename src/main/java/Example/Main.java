package Example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Quiz quiz = main.new Quiz();
        quiz.startQuiz();

    }

    class Quiz {
        void startQuiz() {
            Question[] questions = {
                    new Question(
                            "What is the capital of Nigeria?",  "Lagos","London", "Lagos", "Madrid", "Paris"),
                    new Question(
                            "What is the capital of Kwara?",  "Ilorin","London", "Ilorin", "Madrid", "Berlin"),
                    new Question(
                            "What is the capital of Spain?", "Madrid","London", "Paris", "Madrid", "Berlin"),
                    new Question(
                            "What is the capital of England?", "London","London", "Madrid", "Paris", "Berlin"),
            };

            int correctAnswers = 0;
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i].question);
                System.out.println("A. " + questions[i].option1);
                System.out.println("B. " + questions[i].option2);
                System.out.println("C. " + questions[i].option3);
                System.out.println("D. " + questions[i].option4);

                System.out.println("Enter your answer:");
                String answer = "";
                char userAnswer;
                Scanner scanner = new Scanner(System.in);
                userAnswer = scanner.next().charAt(0);

                answer = userAnswer == 'A'? questions[i].option1:
                        userAnswer == 'B'? questions[i].option2: userAnswer == 'C'? questions[i].option3 : questions[i].option4;


                if(answer.equals(questions[i].answer)) {
                    correctAnswers++;
                }
            }

            ResultService resultService = new ResultServiceImpl();
            resultService.showResult(correctAnswers, questions.length);
        }

        class Question {
            private String question;
            private String answer;
            private String option1;
            private String option2;
            private String option3;
            private String option4;

            public Question(
                    String question,
                    String answer,
                    String option1,
                    String option2,
                    String option3,
                    String option4) {
                this.question = question;
                this.answer = answer;
                this.option1 = option1;
                this.option2 = option2;
                this.option3 = option3;
                this.option4 = option4;
            }
        }

    }

    interface ResultService {
        void showResult(int correctAnswers, int totalQuestions);
    }

    class ResultServiceImpl implements ResultService {
        @Override
        public void showResult(int correctAnswers, int totalQuestions) {
            System.out.println("You got " + correctAnswers + " out of " + totalQuestions + " correct!");
        }
    }
}
