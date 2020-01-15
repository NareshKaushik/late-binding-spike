package com.example.dynamicuiinandroid.customviews.viewwithconstaints

import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.widget.EditText
import com.example.dynamicuiinandroid.customviews.model.LayoutItem

class DEPEditText(context: Context, layoutItem: LayoutItem) : EditText(context) {


    init {
        this.id = layoutItem.id!!.toInt()
        this.setTextColor(Color.parseColor(layoutItem.textColor))
        this.hint = layoutItem.label


        if (layoutItem.inputType != null) {
            when (layoutItem.inputType) {
                "text" -> this.inputType = InputType.TYPE_CLASS_TEXT
                "password" -> this.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                "number" -> this.inputType = InputType.TYPE_CLASS_NUMBER
                "phone" -> this.inputType = InputType.TYPE_CLASS_PHONE
            }

        }
    }

}
