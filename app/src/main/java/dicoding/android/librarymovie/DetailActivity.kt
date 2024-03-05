package dicoding.android.librarymovie

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail)


        val tvName: TextView = findViewById(R.id.tv_item_title_detail)
        val tvGenre: TextView = findViewById(R.id.tv_item_genre_detail)
        val tvDescription: TextView = findViewById(R.id.tv_item_description_detail)
        val tvPhoto: ImageView = findViewById(R.id.tv_item_photo_detail)
        val buttonShare: Button = findViewById(R.id.action_share)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("key_detail", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("key_detail")
        }

        tvName.text = hero?.name
        tvGenre.text = hero?.genre
        tvDescription.text = hero?.description
        // Load photo using Glide/Picasso or other image loading library
        Glide.with(this).load(hero?.photo).into(tvPhoto)

        buttonShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Ayo lihat film : ${hero?.name}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share with"))
        }
    }

}
