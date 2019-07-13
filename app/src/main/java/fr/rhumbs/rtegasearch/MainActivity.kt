package fr.rhumbs.rtegasearch

import android.content.Intent
import android.net.Uri
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
        if (intent?.action == Intent.ACTION_SEND ) {
            handleSendText(intent) // Handle text being sent
        }
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
        val url = "http://rtega.be/chmn/index.php?c=" + hanzi
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

        /*val intent = Intent(this, HanziPageActivity::class.java).apply {
            putExtra(HANZI, hanzi)
        }
        startActivity(intent)
        */
    }
}
