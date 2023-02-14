package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    private var guessedCorrectly = false
    var guessCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val input = findViewById<EditText>(R.id.userinput)
        val guess1Answer = findViewById<TextView>(R.id.Guess1answer)
        val guess2Answer = findViewById<TextView>(R.id.Guess2answer)
        val guess3Answer= findViewById<TextView>(R.id.Guess3answer)
        val guess1AnswerCheck=findViewById<TextView>(R.id.Guess1checkanswer)
        val guess2AnswerCheck=findViewById<TextView>(R.id.Guess2checkanswer)
        val guess3AnswerCheck=findViewById<TextView>(R.id.Guess3checkanswer)

        var Answer=findViewById<TextView>(R.id.Answer)

        button.setOnClickListener {
            guessCount++
            val userGuess = input.text.toString().toUpperCase()

            if (guessCount == 1) {
                guess1Answer.text = userGuess
                guess1AnswerCheck.text = checkGuess(userGuess)
            }
            else if (guessCount == 2) {
                guess2Answer.text = userGuess
                guess2AnswerCheck.text = checkGuess(userGuess)
            }
            else if (guessCount == 3) {
                guess3Answer.text = userGuess
                guess3AnswerCheck.text = checkGuess(userGuess)

                if (userGuess == wordToGuess) {
                    guessedCorrectly = true
                    Answer.text = "Congratulations, you guessed the word!"
                }
            }

            input.text.clear()

            if (guessCount == 3 && !guessedCorrectly) {
                Answer.text = "Sorry, you did not guess the word in three attempts. The word was $wordToGuess."
            }
        }
    }
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {

            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
    }
