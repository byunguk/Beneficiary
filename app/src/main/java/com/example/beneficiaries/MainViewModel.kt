package com.example.beneficiaries

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beneficiaries.data.Address
import com.example.beneficiaries.data.Beneficiary
import com.example.beneficiaries.util.optString
import com.example.beneficiaries.util.readJSONFromAsset
import org.json.JSONArray

const val MAIN_VIEW_MODEL_TAG = "MainViewModel"

class MainViewModel: ViewModel() {
    val beneficiariesLiveData = MutableLiveData<List<Beneficiary>>()

    fun loadBeneficiary(context: Context) {
        val beneficiaries = mutableListOf<Beneficiary>()
        val jsonString = readJSONFromAsset(context, "beneficiaries.json")
        try {
            val json = JSONArray(jsonString)
            for (i in 0 until json.length()) {
                val beneficiary = Beneficiary()
                val jsonObject = json.getJSONObject(i)
                beneficiary.firstName = optString(jsonObject,"firstName")
                beneficiary.lastName = optString(jsonObject,"lastName")
                beneficiary.designationCode = optString(jsonObject,"designationCode")
                beneficiary.beneType = optString(jsonObject,"beneType")
                beneficiary.socialSecurityNumber = optString(jsonObject,"socialSecurityNumber")
                beneficiary.dateOfBirth = optString(jsonObject,"dateOfBirth")
                beneficiary.phoneNumber = optString(jsonObject,"phoneNumber")
                beneficiary.middleName = optString(jsonObject,"middleName")
                val addressJSONObject = jsonObject.optJSONObject("beneficiaryAddress")
                addressJSONObject?.let {
                    val address = Address()
                    address.firstLineMailing = optString(it,"firstLineMailing")
                    address.scndLineMailing = optString(it,"scndLineMailing")
                    address.city = optString(it,"city")
                    address.zipCode = optString(it,"zipCode")
                    address.stateCode = optString(it,"stateCode")
                    address.country = optString(it,"country")
                    beneficiary.beneficiaryAddress = address
                }

                beneficiaries.add(beneficiary)
            }
        } catch (ex: Exception) {
            Log.v(MAIN_VIEW_MODEL_TAG, ex.message ?: "")
        }

        beneficiariesLiveData.postValue(beneficiaries)
    }
}