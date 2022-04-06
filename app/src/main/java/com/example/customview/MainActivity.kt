package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isActive: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
        onButtonClickEvent()
        binding.btnChange.setOnClickListener {
            isActive = !isActive
            onChangeButtonColor()
        }
    }

    private fun setView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun onChangeButtonColor() {
        runOnUiThread {
            with(binding) {
                btnFirst.setActive(isActive)
                btnSecond.setActive(isActive)
                btnThird.setActive(isActive)
                btnFourth.setActive(isActive)
                btnFifth.setActive(isActive)
            }
        }
    }

    private fun onButtonClickEvent() {
        with(binding) {
            btnFirst.setOnClickListener(object : MainCustomButton.OnClickListener {
                override fun onClick() {
                    mSnackBar(R.string.btn_first)
                }
            })
            btnSecond.setOnClickListener(object : MainCustomButton.OnClickListener {
                override fun onClick() {
                    mSnackBar(R.string.btn_second)
                }
            })
            btnThird.setOnClickListener(object : MainCustomButton.OnClickListener {
                override fun onClick() {
                    mSnackBar(R.string.btn_third)
                }
            })
            btnFourth.setOnClickListener(object : MainCustomButton.OnClickListener {
                override fun onClick() {
                    mSnackBar(R.string.btn_fourth)
                }
            })
            btnFifth.setOnClickListener(object : MainCustomButton.OnClickListener {
                override fun onClick() {
                    mSnackBar(R.string.btn_fifth)
                }
            })
        }
    }

    private fun mSnackBar(strId: Int) {
        Snackbar.make(
            binding.root,
            getString(strId),
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
