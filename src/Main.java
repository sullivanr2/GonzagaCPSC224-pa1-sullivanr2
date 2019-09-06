/**
 * This program is a sad attempt at a game of hangman
 * CPSC 224, Fall 2019
 * Programming Assignment #1
 * Sources: https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/
 *          https://www.techiedelight.com/convert-string-list-characters-java/
 *
 * @author Ryan Sullivan
 * @version v1.0 9/05/19
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            int numGuesses = 7;
            final int SIZE = 10;
            final int NUM_WORDS = 10;
            String[] availableLetters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                    "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            String[] randWords = new String[NUM_WORDS];
            randWords[0] = "raccoon";
            randWords[1] = "hippopotamus";
            randWords[2] = "dolphin";
            randWords[3] = "snail";
            randWords[4] = "porcupine";
            randWords[5] = "shark";
            randWords[6] = "baboon";
            randWords[7] = "alligator";
            randWords[8] = "armadillo";
            randWords[9] = "human";


            Random random = new Random();
            String answer = randWords[random.nextInt(10)];
            //System.out.println(answer);
            String[] visibleLetters = {answer};


            int totalChars = answer.length();
            System.out.println("The answer contains " + totalChars + " letters");
            System.out.println(numGuesses + " attempts remaining.");
            System.out.println("Letters remaining: " + Arrays.toString(availableLetters));
            System.out.println(Arrays.toString(visibleLetters));

            List <Character> answerToChar = new ArrayList<>();
            for (char ch: answer.toCharArray()) {
                    answerToChar.add(ch);
            }
            System.out.println(answerToChar);

            while (numGuesses > 0) {
                    Scanner kb = new Scanner(System.in);
                    System.out.println("Please enter a letter: ");
                    char guess = kb.next().charAt(0);
                    kb.nextLine();
                    System.out.println("The letter you have chosen is: " + guess);
                    String stringGuess = String.valueOf(guess);


                    List<String> letterSearch = Arrays.asList(availableLetters);
                    if (letterSearch.contains(stringGuess)) {
                            availableLetters[letterSearch.indexOf(stringGuess)] = "_";
                            System.out.println("Letters remaining: " + Arrays.toString(availableLetters));
                    }
                    else {
                            System.out.println("That letter has already been chosen or is not a letter, please try again");
                    }

                    if (answerToChar.contains(guess)) {
                            System.out.println("Correct!");
                            visibleLetters[answerToChar.indexOf(guess)] = "_";
                            System.out.println(Arrays.toString(visibleLetters));
                    }
                    else {
                            System.out.println("Sorry! Guess again");
                            numGuesses = numGuesses - 1;
                            System.out.println(numGuesses + " attempts remaining");
                            System.out.println(Arrays.toString(visibleLetters));
                    }

            }
    }
}