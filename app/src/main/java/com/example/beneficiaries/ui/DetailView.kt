package com.example.beneficiaries.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.example.beneficiaries.util.dpToPx


class DetailView: LinearLayout {
    constructor(context: Context): this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0, 0)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes) {
        val firstLinearLayout = LinearLayout(context)
        firstLinearLayout.orientation = HORIZONTAL
        val secondLinearLayout = LinearLayout(context)
        secondLinearLayout.orientation = HORIZONTAL
        val thirdLinearLayout = LinearLayout(context)
        thirdLinearLayout.orientation = HORIZONTAL
        val forthLinearLayout = LinearLayout(context)
        firstLinearLayout.orientation = HORIZONTAL

        ssnLabelTextView = TextView(context)
        ssnLabelTextView.text = "SSN: "
        ssnLabelTextView.setTypeface(ssnLabelTextView.typeface, Typeface.BOLD)
        ssnLabelTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))
        ssnLabelTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        ssnTextView = TextView(context)
        ssnTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        firstLinearLayout.addView(ssnLabelTextView)
        firstLinearLayout.addView(ssnTextView)
        firstLinearLayout.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        dobLabelTextView = TextView(context)
        dobLabelTextView.text = "Date of Birth: "
        dobLabelTextView.setTypeface(ssnLabelTextView.typeface, Typeface.BOLD)
        dobLabelTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))
        dobLabelTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        dobTextView = TextView(context)
        dobTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        secondLinearLayout.addView(dobLabelTextView)
        secondLinearLayout.addView(dobTextView)
        secondLinearLayout.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        phoneNumberLabelTextView = TextView(context)
        phoneNumberLabelTextView.text = "Phone Number: "
        phoneNumberLabelTextView.setTypeface(ssnLabelTextView.typeface, Typeface.BOLD)
        phoneNumberLabelTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))
        phoneNumberLabelTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        phoneNumberTextView = TextView(context)
        phoneNumberTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        thirdLinearLayout.addView(phoneNumberLabelTextView)
        thirdLinearLayout.addView(phoneNumberTextView)
        thirdLinearLayout.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        addressLabelTextView = TextView(context)
        addressLabelTextView.text = "Address: "
        addressLabelTextView.setTypeface(ssnLabelTextView.typeface, Typeface.BOLD)
        addressLabelTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))
        addressLabelTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        addressTextView = TextView(context)
        addressTextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        addressTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))
        forthLinearLayout.addView(addressLabelTextView)
        forthLinearLayout.addView(addressTextView)
        forthLinearLayout.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        addView(firstLinearLayout)
        addView(secondLinearLayout)
        addView(thirdLinearLayout)
        addView(forthLinearLayout)
        orientation = VERTICAL
    }

    var ssnLabelTextView: TextView
    var ssnTextView: TextView
    var dobLabelTextView: TextView
    var dobTextView: TextView
    var phoneNumberLabelTextView: TextView
    var phoneNumberTextView: TextView
    var addressLabelTextView: TextView
    var addressTextView: TextView


}