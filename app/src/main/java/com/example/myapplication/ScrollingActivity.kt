package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityScrollingBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding


    private fun image(
        url: String="",
        imgView: ImageView){
       Glide.with(this)
           .load(url)
           .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
           .centerCrop()
           .into(imgView)
    }
    val ibai = "https://es.wikipedia.org/wiki/Ibai_Llanos"
    val rafa = "https://es.wikipedia.org/wiki/Rafael_Nadal"
    val ronaldo = "https://es.wikipedia.org/wiki/Cristiano_Ronaldo"
    val pique = "https://es.wikipedia.org/wiki/Gerard_Piqu%C3%A9"

    val openURL = Intent(Intent.ACTION_VIEW)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.ibai.setOnClickListener{
           openURL.data = Uri.parse(ibai)
           startActivity(openURL)
       }

        binding.content.rafa.setOnClickListener{
            openURL.data = Uri.parse(rafa)
            startActivity(openURL)
        }

        binding.content.ronaldo.setOnClickListener{
            openURL.data = Uri.parse(ronaldo)
            startActivity(openURL)
        }

        binding.content.pique.setOnClickListener{
            openURL.data = Uri.parse(pique)
            startActivity(openURL)
        }


        image("https://esports.as.com/2022/10/05/league-of-legends/Ibai-anuncio-directo-miercoles-viajando_1617148274_1057116_1440x600.png", binding.content.img)
        image("https://www.elcomercio.com/wp-content/uploads/2022/10/pique-ec-700x391.jpg", binding.content.img2)
        image("https://los40es00.epimg.net/los40/imagenes/2022/09/28/love40/1664353166_313410_1664353306_gigante_normal.jpg", binding.content.img3)
        image("https://phantom-marca.unidadeditorial.es/e48ab40c7be6330d1c14e4f05a7e757f/resize/660/f/webp/assets/multimedia/imagenes/2022/09/30/16644896975046.jpg", binding.content.img4)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}