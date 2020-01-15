package com.example.dynamicuiinandroid.customviews.viewwithconstaints

import android.content.Context
import android.widget.ImageView
import com.example.dynamicuiinandroid.customviews.model.LayoutItem
import com.squareup.picasso.Picasso


class DEPImageView(context: Context, layoutItem: LayoutItem) : ImageView(context) {


    init {
        this.id = layoutItem.id!!.toInt()
        val picasso = Picasso.get()
        picasso.load(layoutItem.src).into(this)

    }


}