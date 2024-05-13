package com.statebirdandanimals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.statebirdandanimals.databinding.ActivityStateBirdAnimalDetailsBinding

class StateBirdAnimalDetailsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStateBirdAnimalDetailsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.title = intent.getStringExtra("STATE_NAME")

        Glide.with(this@StateBirdAnimalDetailsActivity).load(intent.getIntExtra("STATE_IMAGE",0))
            .into(binding.imgStateMap)

        Glide.with(this@StateBirdAnimalDetailsActivity).load(intent.getIntExtra("BIRD_IMG",0))
            .into(binding.imgBird)

        Glide.with(this@StateBirdAnimalDetailsActivity).load(intent.getIntExtra("ANIMAL_IMAGE",0))
            .into(binding.imgAnimal)

        binding.imgBird.setOnClickListener {
            Intent(this@StateBirdAnimalDetailsActivity, ImageViewActivity::class.java).also {
                it.putExtra("image", intent.getIntExtra("BIRD_IMG",0))
                startActivity(it)
            }
        }

        binding.imgAnimal.setOnClickListener {
            Intent(this@StateBirdAnimalDetailsActivity, ImageViewActivity::class.java).also {
                it.putExtra("image", intent.getIntExtra("ANIMAL_IMAGE",0))
                startActivity(it)
            }
        }

        val textBirdName = "Common Name: ${intent.getStringExtra("BIRD_NAME")}"
        val textBirdInfo = "Scientific Name: ${intent.getStringExtra("BIRD_INFO")}"
        val textAnimalName = "Common Name: ${intent.getStringExtra("ANIMAL_NAME")}"
        val textAnimalInfo = "Scientific Name: ${intent.getStringExtra("ANIMAL_INFO")}"

        binding.txtBirdName.text = textBirdName
        binding.txtBirdInfo.text = textBirdInfo
        binding.txtAnimalName.text = textAnimalName
        binding.txtAnimalInfo.text = textAnimalInfo

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}