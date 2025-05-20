package vcmsa.ci.multiplechoiceapp2
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val scoreText: TextView = findViewById(R.id.scoreText)
        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val reviewButton: Button = findViewById(R.id.reviewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        scoreText.text = "Your Score: $score / 5"
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practising!"

        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("questions", questions)
            intent.putExtra("answers", answers)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()  // Terminates the app
        }
    }
}
//Author : OpenAI, Chat GPT
//URL : https://chatgpt.com/
