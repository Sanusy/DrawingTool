package com.gmail.ivan.morozyk.drawingtool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.ivan.morozyk.drawingtool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var color = ArcColor.RED

    private var sweepAngle = 5f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            drawView.setOnClickListener { drawView.drawArc(sweepAngle, color) }

            sweepSlider.addOnChangeListener { _, value, _ -> sweepAngle = value }

            redChip.isChecked = true

            redChip.setOnClickListener { color = ArcColor.RED }
            greenChip.setOnClickListener { color = ArcColor.GREEN }
            blueChip.setOnClickListener { color = ArcColor.BLUE }
        }
    }
}