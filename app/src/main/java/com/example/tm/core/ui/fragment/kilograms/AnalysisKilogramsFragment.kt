package com.example.tm.ui.fragment.kilograms

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tm.databinding.FragmentAnalysisKilogramsBinding
import com.example.tm.ui.AnalysisFragmentUiState
import com.example.tm.ui.fragment.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnalysisKilogramsFragment :
    BindingFragment<FragmentAnalysisKilogramsBinding>(FragmentAnalysisKilogramsBinding::inflate) {

    private val viewModel: AnalysisKilogramsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        useBinding {
            it.apply {
                lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel._analysisFragmentUiState.collect { fragmentUIState ->
                            when (fragmentUIState) {
                                is AnalysisFragmentUiState.Default -> {

                                }

                                is AnalysisFragmentUiState.NormalWeightState -> {
                                    tvNormalWeight.text = fragmentUIState.normalWeight
                                }

                                is AnalysisFragmentUiState.WeightOfPipesState -> {
                                    // weight of pipes =  weight of one pipe * number
                                    tvWeightOfPipes.text = fragmentUIState.weightOfPipes
                                }

                                is AnalysisFragmentUiState.NetWeightState -> {
                                    // weight of pipes =  weight of one pipe * number
                                    tvNetWeight.text = fragmentUIState.netWeight
                                }

                                is AnalysisFragmentUiState.NormalWeightPriceState -> {
                                    // weight of pipes =  weight of one pipe * number
                                    tvPriceOfKilograms.text = fragmentUIState.normalWeightPrice
                                }

                                is AnalysisFragmentUiState.NetWeightPriceState -> {
                                    // weight of pipes =  weight of one pipe * number
                                    tvPriceOFNetWeight.text = fragmentUIState.netWeightPrice
                                }

                                is AnalysisFragmentUiState.DifferenceNetAndNormalState -> {
                                    tvDifferencePrice.text =
                                        fragmentUIState.differencePriceBetweenNetAndNormal
                                }

                                is AnalysisFragmentUiState.WeightOfMeterState -> {
                                    tvMeterInGrams.text = fragmentUIState.weightOfMeter
                                }

                                is AnalysisFragmentUiState.MetersInKiloState -> {
                                    tvMeterInKilo.text = fragmentUIState.metersInKilo
                                }

                                is AnalysisFragmentUiState.MetersInTotalKiloState -> {
                                    tvTotalMeters.text = fragmentUIState.totalMeters
                                }

                                is AnalysisFragmentUiState.MetersPriceState -> {
                                    tvPriceOfMeters.text = fragmentUIState.metersPrice
                                }

                                is AnalysisFragmentUiState.DifferenceMetersAndKilogramsState -> {
                                    tvMetersVsKilo.text =
                                        fragmentUIState.differencePriceBetweenMetersAndKilograms
                                }
                            }
                        }
                    }
                }

                edTotalWeight.doOnTextChanged { text, start, before, count ->
                    viewModel.setSetNormalWeight(text.toString())
                    viewModel.setNetWeight(text.toString(), tvWeightOfPipes.text.toString())


                }
                edWeightOfPipe.doOnTextChanged { text, start, before, count ->
                    viewModel.setWeightOfPipes(text.toString(), edNumberOfPipe.text.toString())
                    viewModel.setNetWeight(
                        edTotalWeight.text.toString(),
                        tvWeightOfPipes.text.toString()
                    )

                }
                edNumberOfPipe.doOnTextChanged { text, start, before, count ->
                    viewModel.setWeightOfPipes(edWeightOfPipe.text.toString(), text.toString())
                    viewModel.setNetWeight(
                        edTotalWeight.text.toString(),
                        tvWeightOfPipes.text.toString()
                    )

                }

                edPriceOfKilo.doOnTextChanged { text, start, before, count ->
                    viewModel.setNormalWeightPrice(text.toString(), tvNormalWeight.text.toString())
                    viewModel.setNetWeightPrice(text.toString(), tvNetWeight.text.toString())
                }
                edPriceOfKilo.doOnTextChanged { text, start, before, count ->
                    viewModel.setDifferencePriceBetweenNetAndNormal(
                        tvPriceOfKilograms.text.toString(),
                        tvPriceOFNetWeight.text.toString()
                    )
                }
                edWeightOfPart.doOnTextChanged { text, start, before, count ->
                    viewModel.setWeightOfMeter(text.toString(), edLengthOfPart.text.toString())
                    viewModel.setMetersInKilo(text.toString(), edLengthOfPart.text.toString())


                }


                edPriceOfMeter.doOnTextChanged { text, start, before, count ->
                    viewModel.setMetersPrice(
                        tvTotalMeters.text.toString(),
                        text.toString()
                    )

                }
                edPriceOfMeter.doAfterTextChanged {
                    viewModel.setDifferencePriceBetweenMetersAndKilograms(
                        tvPriceOfMeters.text.toString(),
                        tvPriceOfKilograms.text.toString()
                    )
                }
                edNumberOfPipe.doOnTextChanged { text, start, before, count ->
                    viewModel.setMetersInTotalKilo(
                        edWeightOfPart.text.toString(),
                        edLengthOfPart.text.toString(),
                        tvNetWeight.text.toString()
                    )
                }
                edLengthOfPart.doOnTextChanged { text, start, before, count ->
                    viewModel.setWeightOfMeter(edWeightOfPart.text.toString(), text.toString())
                    viewModel.setMetersInKilo(edWeightOfPart.text.toString(), text.toString())

                }


            }
        }
    }
}