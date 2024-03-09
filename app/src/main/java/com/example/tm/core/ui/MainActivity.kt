package com.example.tm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.tm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
//        lifecycleScope.launch {
//            viewModel.calculateMetersState.collect { meters ->
//                activityMainBinding.tvResultMeter.setText(meters.toString())
//            }
//        }
//        lifecycleScope.launch {
//            viewModel.calculatePriceState.collect { price ->
//                activityMainBinding.tvResultMoney.text = "$price eg"
//            }
//        }
//        activityMainBinding.apply {
//            edWeightOfPart.doOnTextChanged { text, start, before, count ->
//                viewModel.calculateNumberOfMeters(
//                    text.toString(),
//                    edLengthOfPart.text.toString(),
//                    edTotalWeight.text.toString()
//                )
//            }
//            edLengthOfPart.doOnTextChanged { text, start, before, count ->
//                viewModel.calculateNumberOfMeters(
//                    edWeightOfPart.text.toString(),
//                    text.toString(),
//                    edTotalWeight.text.toString()
//                )
//            }
//
//            edTotalWeight.doOnTextChanged { text, start, before, count ->
//                viewModel.calculateNumberOfMeters(
//                    edWeightOfPart.text.toString(),
//                    edLengthOfPart.text.toString(),
//                    text.toString()
//                )
//            }
//            edPrice.doOnTextChanged { text, start, before, count ->
//                viewModel.calculatePrice(tvResultMeter.text.toString(), text.toString())
//
//            }
//            tvResultMeter.doOnTextChanged { text, start, before, count ->
//                viewModel.calculatePrice(text.toString(), edPrice.text.toString())
//
//            }

    }
}