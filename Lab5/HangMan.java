/**********************************************
 *  Workshop 5
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-13>
 * **********************************************/
package LAB5;

import java.util.ArrayList;
import java.util.Random;

public class HangMan {

    public String getWord() {
        HandleFile hf = new HandleFile();
        String[] words = hf.readFile();
        int random = new Random().nextInt(words.length);
        String word =  words[random];
        while(!word.matches("[a-zA-Z]+")){
            random = new Random().nextInt(words.length);
            word = words[random];
        }
        return word.toLowerCase();
    }

    public Boolean checkRepeat(char letter, char[] wordLetters) {
        boolean isRepeat = false;
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == letter) {
                isRepeat = true;
            }
        }
        return isRepeat;
    }

    public Boolean checkInTheWord(char letter, String word) {
        boolean isInTheWord = false;
        char[] wordLetters = word.toCharArray();
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == letter) {
                isInTheWord = true;
            }
        }
        return isInTheWord;
    }

    public Boolean checkIfTryAgain(char letter, ArrayList<Character> playerLetter) {
        boolean ifTryAgain = false;
        if (playerLetter.size() > 1) {
            for (int i = 0; i < playerLetter.size() - 1; i++) {
                if (playerLetter.get(i) == letter) {
                    ifTryAgain = true;
                }
            }
        }
        return ifTryAgain;
    }

    public void tryWord() {
        ForPlayer player = new ForPlayer();

        do {
            ArrayList<String> wordList = new ArrayList<>();
            String word;

            for (int i = 0; i < 10; i++) {
                word = getWord();
                wordList.add(word);
            }
            int random;

            ArrayList<Character> playerLetter = new ArrayList<>(); //Store the letter user input

            int count, missTime = 0;
            char letter;
            String msg;

            random = new Random().nextInt(wordList.size());
            word = wordList.get(random);
          //  System.out.println("The word is " + word);
            char[] charWord = word.toCharArray();
            char[] letters = new char[word.length()]; // word as *
            for (count = 0; count < letters.length; count++) {
                letters[count] = '*';
            }   //Initialize the guess word as *****
            while (count != 0) {
                count = 0;
                msg = "";
                letter = player.getUserLetter(String.valueOf(letters));
                playerLetter.add(letter);

                if (!checkRepeat(letter, letters)) {
                    for (int i = 0; i < charWord.length; i++) {
                        if (charWord[i] == letter) {
                            letters[i] = letter;
                        }
                    }
                } else {
                    msg = letter + " is already in the word\n";
                }

                if (!checkInTheWord(letter, word)) {
                    msg = letter + " is not in the word\n";
                    missTime++;
                    if (checkIfTryAgain(letter, playerLetter)) {
                        msg = "You have already tried " + letter + ", try a new letter\n";
                    }
                }
                System.out.print(msg);
                for (int j = 0; j < letters.length; j++) {
                    if (letters[j] == '*') {
                        count++;
                    }
                }
            }

            System.out.println("Congratulations!");
            System.out.println("The word is " + word + ". You missed " + missTime + " time.");
            player.askNewWord();
            player.askChangeFile();
        } while (player.askContinue());
    }
}
