package fr.rhumbs.rtegasearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val HANZI = "fr.rhumbs.rtegasearch.HANZI"

class MainActivity : AppCompatActivity() {
    lateinit var inputText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText = findViewById(R.id.inputText)
        /*when {
            intent?.action == Intent.ACTION_SEND -> {
                handleSendText(intent) // Handle text being sent
            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }*/
    }

    private fun handleSendText(intent: Intent?) {
        intent?.getStringExtra(Intent.EXTRA_TEXT)?.let {
            getHanziPage(it)
        }
    }

    fun handleInputText(view: View){
        val message = inputText.text.toString()
        getHanziPage(message)
    }

    private fun getHanziPage(hanzi: String){
        val intent = Intent(this, HanziPageActivity::class.java).apply {
            putExtra(HANZI, hanzi)
        }
        startActivity(intent)
    }
}
