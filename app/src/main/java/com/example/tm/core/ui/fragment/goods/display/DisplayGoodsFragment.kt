package com.example.tm.core.ui.fragment.goods.display

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tm.R

class DispalyGoodsFragment : Fragment() {

    companion object {
        fun newInstance() = DispalyGoodsFragment()
    }

    private lateinit var viewModel: DispalyGoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dispaly_goods, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DispalyGoodsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}