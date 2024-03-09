package com.example.tm.core.ui.fragment.goods.inputs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tm.R

class GoodsFragment : Fragment() {

    companion object {
        fun newInstance() = GoodsFragment()
    }

    private lateinit var viewModel: GoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_goods, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GoodsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}