package dicoding.android.librarymovie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val genre: String,
    val description: String,
    val photo: String
) : Parcelable
