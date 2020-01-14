package com.example.dynamicuiinandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dynamicuiinandroid.customviews.model.LayoutItem
import com.example.dynamicuiinandroid.customviews.model.Response
import com.example.dynamicuiinandroid.customviews.model.ViewFactoryForDep
import com.example.dynamicuiinandroid.util.JsonDataLoader.loadJSONFromAssets
import com.example.latebindingspike.MainViewModel
import com.google.gson.Gson


class UIFromJson : AppCompatActivity() {

    lateinit var root: ConstraintLayout
    lateinit var progressBar: ProgressBar
    lateinit var set: ConstraintSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.dashboardLiveData.observe(this, Observer {
            Log.v("MainActivity", it.toString())
            addViews(it)
            progressBar.visibility = View.GONE
        })


        root = ConstraintLayout(this)
        set = ConstraintSet()
        setContentView(root)

        addProgressBar()
    }

    private fun addProgressBar() {
        progressBar = ProgressBar(this)
        progressBar.id = View.generateViewId()
        set.connect(progressBar.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)
        set.connect(progressBar.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
        set.connect(progressBar.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
        set.connect(progressBar.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
        root.addView(progressBar)
        set.applyTo(root)
    }

    private fun addViews(model: Response) {

        val views = mutableListOf<View>()

        for ((index, layoutItem) in model!!.layout!!.withIndex()) {
            val view = layoutItem?.let { ViewFactoryForDep.getViewFrom(this, it) }
            views.add(index, view!!)


            when (index) {
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
                        views[index - 1].id,
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
                        views[index - 1].id,
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
                        views[index - 1].id,
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
                        views[index - 2].id,
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
        set.applyTo(root)

    }
}
