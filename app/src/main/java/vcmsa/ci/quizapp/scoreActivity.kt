package vcmsa.ci.quizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)
        val questions = intent.getStringArrayExtra("QUESTIONS")
        val answers = intent.getBooleanArrayExtra("ANSWERS")

        val txtFinalScore = findViewById<TextView>(R.id.txtFinalScore)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)

        txtFinalScore.text = "Your score: $score / $total"
        txtFeedback.text = if (score >= 3) "Great job!" else "Keep practising!"

        btnReview.setOnClickListener {
            val reviewBuilder = StringBuilder()
            questions?.forEachIndexed { index, question ->
                reviewBuilder.append("${index + 1}. $question\nAnswer: ${if (answers?.get(index) == true) "True" else "False"}\n\n")
            }

            val reviewTextView = findViewById<TextView>(R.id.txtReview)
            reviewTextView.text = reviewBuilder.toString()
        }
    }
}