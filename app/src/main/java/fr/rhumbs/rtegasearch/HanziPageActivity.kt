package fr.rhumbs.rtegasearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HanziPageActivity : AppCompatActivity() {
    lateinit var sharedText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanzi_page)
        sharedText = findViewById(R.id.sharedText)


        // Get the Intent that started this activity and extract the string
        val hanzi = intent.getStringExtra(HANZI)

        sharedText.setText(hanzi)
    }


}
