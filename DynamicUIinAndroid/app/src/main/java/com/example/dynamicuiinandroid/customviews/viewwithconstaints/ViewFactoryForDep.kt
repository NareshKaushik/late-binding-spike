package com.example.dynamicuiinandroid.customviews.viewwithconstaints

import android.content.Context
import android.view.View
import com.example.dynamicuiinandroid.customviews.model.LayoutItem


object ViewFactoryForDep {
    fun getViewFrom(context: Context, layoutItem: LayoutItem): View {
        when (layoutItem.type) {
            "edittext" -> {
                val field = DEPEditText(context, layoutItem)
                return field
            };
            "textview" -> {
                val textField = DEPTextView(context, layoutItem)
                return textField
            }
            "imageview" -> {
                val imageView = DEPImageView(context, layoutItem)
                return imageView
            }
            else -> {
                val button = DEPButton(context, layoutItem)
                return button
            }
        }
    }
}
