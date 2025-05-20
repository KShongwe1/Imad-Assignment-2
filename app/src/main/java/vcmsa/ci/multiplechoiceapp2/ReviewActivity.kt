package vcmsa.ci.multiplechoiceapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val questions = intent.getStringArrayExtra("questions") ?: return
        val answers = intent.getBooleanArrayExtra("answers") ?: return
        val reviewLayout: LinearLayout = findViewById(R.id.reviewLayout)

        for (i in questions.indices) {
            val textView = TextView(this)
            textView.text = "${questions[i]}\nAnswer: ${if (answers[i]) "True" else "False"}"
            reviewLayout.addView(textView)
        }
    }
}

//Author : OpenAI, Chat GPT
//URL : https://chatgpt.com/