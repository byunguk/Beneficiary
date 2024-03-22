package com.example.beneficiaries.data

data class Beneficiary(
    var lastName: String? = null,
    var firstName: String? = null,
    var designationCode: String? = null,
    var beneType: String? = null,
    var socialSecurityNumber: String? = null,
    var dateOfBirth: String? = null,
    var middleName: String? = null,
    var phoneNumber: String? = null,
    var beneficiaryAddress: Address? = null
)