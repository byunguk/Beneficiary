package com.example.beneficiaries.data

data class Address(
    var firstLineMailing: String? = null,
    var scndLineMailing: String? = null,
    var city: String? = null,
    var zipCode: String? = null,
    var stateCode: String? = null,
    var country: String? = null
) {
    fun format(): String {
        val sb = StringBuffer()
        if (firstLineMailing?.isNotEmpty() == true) {
            sb.append(firstLineMailing)
        }
        if (scndLineMailing?.isNotEmpty() == true) {
            if (sb.toString().isNotEmpty()) {
                sb.append("\n")
            }
            sb.append(scndLineMailing)
        }
        if (city?.isNotEmpty() == true) {
            if (sb.toString().isNotEmpty()) {
                sb.append("\n")
            }
            sb.append(city)
        }
        if (stateCode?.isNotEmpty() == true) {
            if (city?.isNotEmpty() == true) {
                sb.append(", ")
            }
            sb.append(stateCode)
        }
        if (zipCode?.isNotEmpty() == true) {
            if (stateCode?.isNotEmpty() == true) {
                sb.append(" ")
            }
            sb.append(zipCode)
        }
        if (country?.isNotEmpty() == true) {
            if (city?.isNotEmpty() == true ||
                stateCode?.isNotEmpty() == true ||
                zipCode?.isNotEmpty() == true) {
                sb.append(", ")
            }
            sb.append(country)
        }

        return sb.toString()
    }
}
