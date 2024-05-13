package com.statebirdandanimals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.statebirdandanimals.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityImageViewBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Glide.with(applicationContext).load(intent.getIntExtra("image",0))
            .into(binding.ivImage)

        // all listeners
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}