package com.example.beneficiaries.ui

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.beneficiaries.data.Beneficiary
import com.example.beneficiaries.util.formatDob
import com.example.beneficiaries.util.formatPhoneNumber
import com.example.beneficiaries.util.formatSsn

class BeneficiaryAdapter: RecyclerView.Adapter<BeneficiaryAdapter.BeneficiaryViewHolder>() {
    private var beneficiaries = mutableListOf<Beneficiary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryViewHolder {
        val beneficiaryView = BeneficiaryItem(parent.context)
        beneficiaryView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        return BeneficiaryViewHolder(beneficiaryView)
    }

    override fun getItemCount() = beneficiaries.size

    override fun onBindViewHolder(holder: BeneficiaryViewHolder, position: Int) {
        holder.bind(beneficiaries[position])
    }

    fun updateData(beneficiaries: List<Beneficiary>) {
        this.beneficiaries = beneficiaries.toMutableList()
        notifyDataSetChanged()
    }

    class BeneficiaryViewHolder(itemView: View): ViewHolder(itemView) {
        fun bind(beneficiary: Beneficiary) {
            val beneficiaryItem = itemView as? BeneficiaryItem
            beneficiaryItem?.apply {
                firstNameTextView.text = beneficiary.firstName
                lastNameTextView.text = beneficiary.lastName
                beneTypeTextView.text = beneficiary.beneType
                designationTextView.text = beneficiary.designationCode
                detailView.ssnTextView.text = beneficiary.socialSecurityNumber?.formatSsn()
                detailView.dobTextView.text = beneficiary.dateOfBirth?.formatDob()
                detailView.phoneNumberTextView.text = beneficiary.phoneNumber?.formatPhoneNumber()
                detailView.addressTextView.text = beneficiary.beneficiaryAddress?.format()
            }
        }
    }

}

