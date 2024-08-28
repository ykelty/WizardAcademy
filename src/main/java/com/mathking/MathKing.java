package com.mathking;

import java.util.Random;
import java.util.Scanner;

public class MathKing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfQuestions = 5;
        int correctAnswers = 0;
        long startTime = System.currentTimeMillis();

        System.out.println("Welcome to MathKing! Solve the following 5 questions as quickly and accurately as you can.");

        for (int i = 0; i < numberOfQuestions; i++) {
            int a = random.nextInt(10) + 1; // Numbers range between 1 and 10
            int b = random.nextInt(10) + 1;
            int correctAnswer = a + b;

            System.out.printf("Question %d: What is %d + %d? ", (i+1), a, b);
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The correct answer was " + correctAnswer);
            }
        }

        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000.0; // Convert to seconds

        System.out.println("MathKing Quiz Complete!");
        System.out.printf("Accuracy: %d/%d\n", correctAnswers, numberOfQuestions);
        System.out.printf("Speed: %.2f seconds\n", timeTaken);
    }
}