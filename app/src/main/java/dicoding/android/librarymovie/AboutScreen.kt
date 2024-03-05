package dicoding.android.librarymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_about_screen)
    }
}