package com.example.dynamicuiinandroid.customviews

import android.content.Context
import android.widget.ImageView
import com.example.dynamicuiinandroid.R


class DEPImageView(context: Context, id: Int, resouceId: Int = R.drawable.ic_launcher_background) :
    ImageView(context) {


    init {
        this.id = id
        this.setBackgroundResource(resouceId)

    }


}