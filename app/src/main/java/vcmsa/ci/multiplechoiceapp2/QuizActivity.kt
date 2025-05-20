package vcmsa.ci.multiplechoiceapp2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "World War I ended in 1918.",
        "The Berlin Wall fell in 1999.",
        "The Roman Empire collapsed in 476 AD.",
        "The Cold War was a physical war fought directly."
    )

    private val answers = booleanArrayOf(true, true, false, true, false)

    private var currentIndex = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        questionText.text = questions[currentIndex]

        fun checkAnswer(userAnswer: Boolean) {
            val correct = answers[currentIndex]
            if (userAnswer == correct) {
                feedbackText.text = "Correct!"
                score++
            } else {
                feedbackText.text = "Incorrect"
            }
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                questionText.text = questions[currentIndex]
                feedbackText.text = ""
                trueButton.isEnabled = true
                falseButton.isEnabled = true
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }
}
//Author : OpenAI, Chat GPT
//URL : https://chatgpt.com/