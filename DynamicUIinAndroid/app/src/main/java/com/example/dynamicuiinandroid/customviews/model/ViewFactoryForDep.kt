package com.example.dynamicuiinandroid.customviews.model

import android.content.Context
import android.view.View
import com.example.dynamicuiinandroid.customviews.DEPButton
import com.example.dynamicuiinandroid.customviews.DEPEditText
import com.example.dynamicuiinandroid.customviews.DEPImageView
import com.example.dynamicuiinandroid.customviews.DEPTextView


object ViewFactoryForDep {
    fun getViewFrom(context: Context,layoutItem: LayoutItem): View {
        when (layoutItem.type) {
            "edittext" -> {
                val field = DEPEditText(context,layoutItem.id!!.toInt(),layoutItem!!.label!!)
                return field
            };
            "textview"->
            {
                val textField = DEPTextView(context,layoutItem.id!!.toInt(),layoutItem!!.label!!)
                return textField
            }
            "imageview"->{
                val imageView = DEPImageView(context,layoutItem.id!!.toInt())
                return imageView
            }
            else->{
                val button = DEPButton(context,layoutItem.id!!.toInt(),layoutItem!!.label!!)
                return button
            }
        }
    }
}
