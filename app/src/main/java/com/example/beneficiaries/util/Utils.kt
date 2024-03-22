package com.example.beneficiaries.util

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.ParseException
import java.text.SimpleDateFormat


const val UTIL_TAG = "UTIL"

/**
 * read JSON file from asset
 * @param context Android context
 * @param filename name of the json file
 * @return json string
 */
fun readJSONFromAsset(context: Context, filename: String): String {
    val sb = StringBuilder()
    try {
        val iStream = context.assets.open(filename)
        val bufferedReader = BufferedReader(InputStreamReader(iStream))
        bufferedReader.useLines { line ->
            line.forEach {
                sb.append(it)
            }
        }
    } catch (ex: Exception) {
        Log.v(UTIL_TAG, ex.message ?: "")
    }

    return sb.toString()
}

/**
 * JSONObject.optString returns 'null' string when value is null
 * This function returns null when it is null
 * @param json JSONObject
 * @param key: String? key of the json object
 * @return null if the value is null, otherwise string value of the key
 */
fun optString(json: JSONObject, key: String?): String? {
    return if (json.isNull(key)) null else json.optString(key, null)
}

/**
 * convert dp to pixel
 * @param context Android context
 * @param dp dp value
 * @return pixel value
 */
fun dpToPx(context: Context, dp: Int): Int {
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}

/**
 * add ripple effect to the view
 */
fun View.addRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

/**
 * toggle the visibility of the view
 */
fun View.toggleVisibility() {
    visibility = if (visibility == GONE) {
        VISIBLE
    } else {
        GONE
    }
}

/**
 * format SSN
 * original format: XXXXXXXXX
 * converted format: XXX-XX-XXXX
 */
fun String.formatSsn(): String {
    return if (length != 9) {
        this
    } else {
        substring(0, 3) + "-" + substring(3, 5) + "-" + substring(5)
    }
}

/**
 * format date
 * original format: MMddyyyy
 * converted format: MM/dd/yyyy
 */
fun String.formatDob(): String {
    val inFormat = SimpleDateFormat("MMddyyyy")
    val outFormat = SimpleDateFormat("MM/dd/yyyy")
    try {
        val date = inFormat.parse(this)
        return outFormat.format(date)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return this
}

/**
 * format phone number
 * original format: 1234567890
 * converted format: 123-456-7890
 */
fun String.formatPhoneNumber(): String {
    return if (length != 10) {
        this
    } else {
        return substring(0, 3) + "-" + substring(3, 6) + "-" + substring(6)
    }
}