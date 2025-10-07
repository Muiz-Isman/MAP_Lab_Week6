package com.example.map_lab_week6

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.map_lab_week6.model.CatBreed
import com.example.map_lab_week6.model.CatModel
import com.example.map_lab_week6.model.Gender
import com.example.map_lab_week6.ImageLoader

private const val FEMALE_SYMBOL = "♀"
private const val MALE_SYMBOL = "♂"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView = containerView.findViewById(R.id.cat_photo)
    private val catNameView: TextView = containerView.findViewById(R.id.cat_name)
    private val catBreedView: TextView = containerView.findViewById(R.id.cat_breed)
    private val catBiographyView: TextView = containerView.findViewById(R.id.cat_biography)
    private val catGenderView: TextView = containerView.findViewById(R.id.cat_gender)

    fun bindData(cat: CatModel) {
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBiographyView.text = cat.biography

        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }

        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            Gender.Unknown -> UNKNOWN_SYMBOL
        }
    }
}