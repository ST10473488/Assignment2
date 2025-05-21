package vcmsa.ci.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "The Great Wall Of China is visible from space",
        "The capital of Australia is Sydney",
        "Lightning never strikes the same place twice",
        "Gold fish have a memory span of only three seconds",
        "The tallest mountain on Earth is Mount Everest"
    )

    private val answers = booleanArrayOf(
        false,
        false,
        false,
        false,
        true,
    )

    private var currentQuestionIndex = 0
    private var score = 0

    // View references
    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz) // Ensure this XML is in res/layout/

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)

        loadQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            feedbackTextView.text = ""
        } else {
            questionTextView.text = "Quiz Completed!"
            feedbackTextView.text = "Your score: $score / ${questions.size}"
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            score++
        } else {
            feedbackTextView.text = "Incorrect!"
        }
        currentQuestionIndex++
        trueButton.postDelayed({ loadQuestion() }, 1000)
    }
}