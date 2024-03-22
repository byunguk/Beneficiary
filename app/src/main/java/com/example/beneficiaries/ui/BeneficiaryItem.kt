package com.example.beneficiaries.ui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.util.TypedValueCompat.spToPx
import androidx.recyclerview.widget.RecyclerView
import com.example.beneficiaries.util.addRipple
import com.example.beneficiaries.util.dpToPx
import com.example.beneficiaries.util.toggleVisibility

private const val BENEFICIARY_CONSTRAINT_LAYOUT_ID = 1000
private const val FIRST_NAME_TEXT_VIEW_ID = 1001
private const val LAST_NAME_TEXT_VIEW_ID = 1002
private const val BENE_TYPE_TEXT_VIEW_ID = 1003
private const val DESIGNATION_TEXT_VIEW_ID = 1004
private const val DETAIL_VIEW_ID = 1005

class BeneficiaryItem: ConstraintLayout {
    constructor(context: Context): this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0, 0)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes) {
        this.id = BENEFICIARY_CONSTRAINT_LAYOUT_ID
        val layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
        this.layoutParams = layoutParams
        isClickable = true
        addRipple()
        firstNameTextView = TextView(context)
        firstNameTextView.id = FIRST_NAME_TEXT_VIEW_ID
        firstNameTextView.textSize = spToPx(10.0F, context.resources.displayMetrics)
        firstNameTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))

        lastNameTextView = TextView(context)
        lastNameTextView.id = LAST_NAME_TEXT_VIEW_ID
        lastNameTextView.textSize = spToPx(10.0F, context.resources.displayMetrics)
        lastNameTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))

        beneTypeTextView = TextView(context)
        beneTypeTextView.id = BENE_TYPE_TEXT_VIEW_ID
        beneTypeTextView.setTypeface(beneTypeTextView.typeface, Typeface.BOLD_ITALIC)
        beneTypeTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))

        designationTextView = TextView(context)
        designationTextView.id = DESIGNATION_TEXT_VIEW_ID
        designationTextView.textSize = spToPx(8.0F, context.resources.displayMetrics)
        designationTextView.setPadding(dpToPx(context, 8), dpToPx(context, 4), dpToPx(context, 8), dpToPx(context, 4))

        detailView = DetailView(context)
        detailView.id = DETAIL_VIEW_ID
        detailView.visibility = View.GONE
        addView(firstNameTextView)
        addView(lastNameTextView)
        addView(beneTypeTextView)
        addView(designationTextView)
        addView(detailView)
        setConstraints()
        setOnClickListener {
            detailView.toggleVisibility()
        }
    }

    var firstNameTextView: TextView
    var lastNameTextView: TextView
    var beneTypeTextView: TextView
    var designationTextView: TextView
    var detailView: DetailView

    private fun setConstraints() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)

        constraintSet.connect(
            FIRST_NAME_TEXT_VIEW_ID,
            ConstraintSet.LEFT,
            this.id,
            ConstraintSet.LEFT,
            0
        )
        constraintSet.connect(
            FIRST_NAME_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            this.id,
            ConstraintSet.TOP,
            0
        )
        constraintSet.connect(
            FIRST_NAME_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            0
        )

        constraintSet.connect(
            LAST_NAME_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            this.id,
            ConstraintSet.TOP,
            0
        )
        constraintSet.connect(
            LAST_NAME_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            0
        )
        constraintSet.connect(
            LAST_NAME_TEXT_VIEW_ID,
            ConstraintSet.LEFT,
            FIRST_NAME_TEXT_VIEW_ID,
            ConstraintSet.RIGHT,
            0
        )

        constraintSet.connect(
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            FIRST_NAME_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            0
        )
        constraintSet.connect(
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.LEFT,
            this.id,
            ConstraintSet.LEFT,
            0
        )
        constraintSet.connect(
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            DETAIL_VIEW_ID,
            ConstraintSet.TOP,
            0
        )

        constraintSet.connect(
            DESIGNATION_TEXT_VIEW_ID,
            ConstraintSet.RIGHT,
            this.id,
            ConstraintSet.RIGHT,
            0
        )
        constraintSet.connect(
            DESIGNATION_TEXT_VIEW_ID,
            ConstraintSet.TOP,
            this.id,
            ConstraintSet.TOP,
            0
        )
        constraintSet.connect(
            DESIGNATION_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            this.id,
            ConstraintSet.BOTTOM,
            0
        )

        constraintSet.connect(
            DETAIL_VIEW_ID,
            ConstraintSet.TOP,
            BENE_TYPE_TEXT_VIEW_ID,
            ConstraintSet.BOTTOM,
            0
        )
        constraintSet.connect(
            DETAIL_VIEW_ID,
            ConstraintSet.LEFT,
            this.id,
            ConstraintSet.LEFT,
            0
        )
        constraintSet.connect(
            DETAIL_VIEW_ID,
            ConstraintSet.BOTTOM,
            this.id,
            ConstraintSet.BOTTOM,
            0
        )
        constraintSet.applyTo(this)
    }
}