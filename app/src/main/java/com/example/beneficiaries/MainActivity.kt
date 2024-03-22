package com.example.beneficiaries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiaries.ui.BeneficiaryAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var root: ConstraintLayout
    private lateinit var viewModel: MainViewModel
    private lateinit var beneficiaryAdapter: BeneficiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViews()
        setViewModel()
    }

    private fun setViews() {
        beneficiaryAdapter = BeneficiaryAdapter()
        recyclerView = RecyclerView(this)
        recyclerView.adapter = beneficiaryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
        root = ConstraintLayout(this)
        root.addView(recyclerView)
        setContentView(root)
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.beneficiariesLiveData.observe(this) {
            beneficiaryAdapter.updateData(it)
        }

        viewModel.loadBeneficiary(this)
    }
}