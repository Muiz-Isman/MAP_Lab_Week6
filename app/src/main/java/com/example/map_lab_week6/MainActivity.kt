package com.example.map_lab_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.map_lab_week6.model.CatBreed
import com.example.map_lab_week6.model.CatModel
import com.example.map_lab_week6.model.Gender
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Implementasi OnClickListener langsung di sini
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                // Saat item di-klik, panggil fungsi untuk menampilkan dialog
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Fred",
                    biography = "Silent and deadly",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Wilma",
                    biography = "Cuddly assassin",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.AmericanCurl,
                    name = "Curious George",
                    biography = "Award winning investigator",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                )
            )
        )
    }

    // Fungsi untuk menampilkan pop-up dialog
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected") // <-- Hapus [cite]
            .setMessage("You have selected cat ${cat.name}") // <-- Hapus [cite]
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}