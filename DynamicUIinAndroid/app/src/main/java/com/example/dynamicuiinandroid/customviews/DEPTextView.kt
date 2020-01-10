package com.example.dynamicuiinandroid.customviews

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet


class DEPTextView(context:Context,id:Int,label:String="TextView",color:Int= Color.RED,var set: ConstraintSet?=null) : TextView(context)
{


    init {
        this.id=id
        this.setTextColor(color)
        this.text = label
        if(set!=null )
        {
            setConnection(set!!)
        }

    }
    fun setConnection(set: ConstraintSet)
    {
        set.constrainHeight(id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(id, ConstraintSet.WRAP_CONTENT)
        set.connect(
            id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,
            70
        )
    }

}