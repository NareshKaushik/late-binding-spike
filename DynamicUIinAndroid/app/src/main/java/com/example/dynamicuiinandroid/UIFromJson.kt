package com.example.dynamicuiinandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.dynamicuiinandroid.customviews.model.Response
import com.example.dynamicuiinandroid.customviews.model.ViewFactoryForDep
import com.example.dynamicuiinandroid.util.JsonDataLoader.loadJSONFromAssets
import com.google.gson.Gson


class UIFromJson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        val set = ConstraintSet()
        val gson = Gson()
        val model = gson.fromJson(loadJSONFromAssets(context, "data.json"), Response::class.java)
        val root = ConstraintLayout(context)
        val views = mutableListOf<View>()
        for ((inex, layoutItem) in model!!.layout!!.withIndex()) {
            val view = layoutItem?.let { ViewFactoryForDep.getViewFrom(context, it) }
            views.add(inex, view!!)


            when (inex) {
                0 -> {
                    set.constrainWidth(view!!.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainHeight(view!!.id, ConstraintSet.WRAP_CONTENT)
                    set.connect(
                        view.id,
                        ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.LEFT,
                        50
                    )
                    set.connect(
                        view.id,
                        ConstraintSet.TOP,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.TOP,
                        70
                    )

                }
                1 -> {
                    set.constrainHeight(view!!.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainWidth(view!!.id, ConstraintSet.MATCH_CONSTRAINT)
                    set.connect(
                        view!!.id,
                        ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.LEFT,
                        50
                    )

                    set.connect(
                        view!!.id,
                        ConstraintSet.TOP,
                        views[0].id,
                        ConstraintSet.BOTTOM,
                        70
                    )
                    set.connect(
                        view!!.id,
                        ConstraintSet.RIGHT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.RIGHT,
                        50
                    )


                }
                2 -> {
                    set.constrainHeight(view.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainWidth(view.id, ConstraintSet.WRAP_CONTENT)
                    set.connect(
                        view.id,
                        ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.LEFT,
                        50
                    )

                    set.connect(
                        view.id,
                        ConstraintSet.TOP,
                        views[inex - 1].id,
                        ConstraintSet.BOTTOM,
                        70
                    )
                }
                3 -> {
                    set.constrainHeight(view.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainWidth(view.id, ConstraintSet.MATCH_CONSTRAINT)
                    set.connect(
                        view.id,
                        ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.LEFT,
                        50
                    )

                    set.connect(
                        view.id,
                        ConstraintSet.TOP,
                        views[inex - 1].id,
                        ConstraintSet.BOTTOM,
                        70
                    )
                    set.connect(
                        view.id,
                        ConstraintSet.RIGHT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.RIGHT,
                        50
                    )
                }
                4 -> {
                    set.constrainHeight(view.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainWidth(view.id, ConstraintSet.WRAP_CONTENT)
                    set.connect(
                        view.id,
                        ConstraintSet.LEFT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.LEFT,
                        50
                    )

                    set.connect(
                        view.id,
                        ConstraintSet.TOP,
                        views[inex - 1].id,
                        ConstraintSet.BOTTOM,
                        70
                    )
                }
                5 -> {
                    set.constrainHeight(view.id, ConstraintSet.WRAP_CONTENT)
                    set.constrainWidth(view.id, ConstraintSet.MATCH_CONSTRAINT)
                    set.connect(
                        view.id,
                        ConstraintSet.TOP,
                        views[inex - 2].id,
                        ConstraintSet.BOTTOM,
                        70
                    )
                    set.connect(
                        view.id,
                        ConstraintSet.RIGHT,
                        ConstraintSet.PARENT_ID,
                        ConstraintSet.RIGHT,
                        50
                    )
                }

            }
            root.addView(view)
        }
        setContentView(root)
        set.applyTo(root)
    }
}
