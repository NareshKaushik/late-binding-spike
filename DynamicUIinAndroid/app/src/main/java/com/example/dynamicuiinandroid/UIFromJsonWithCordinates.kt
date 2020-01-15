package com.example.dynamicuiinandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dynamicuiinandroid.customviews.model.Response
import com.example.dynamicuiinandroid.customviews.viewwithconstaints.ViewFactoryForDep
import com.example.dynamicuiinandroid.util.JsonDataLoader
import com.example.dynamicuiinandroid.util.JsonDataLoader.jsontocosntratinset
import com.example.latebindingspike.MainViewModel


class UIFromJsonWithCordinates : AppCompatActivity() {

    lateinit var progressBar: View
    lateinit var set: ConstraintSet
    lateinit var root: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        root = ConstraintLayout(this)
        set = ConstraintSet()
        addProgressBar()
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.dashboardLiveData.observe(this, Observer {
            Log.v("MainActivity", it.toString())
            addViews(it)
            progressBar.visibility = View.GONE
        })
        setContentView(root)
    }

    private fun addProgressBar() {
        progressBar = layoutInflater.inflate(R.layout.view_loading,root,false)
        root.addView(progressBar)
    }

    private fun addViews(model: Response) {
        for (layoutItem in model.layout!!.iterator()) {
            val view = layoutItem?.let { ViewFactoryForDep.getViewFrom(this, it) }

            JsonDataLoader.setConnects(layoutItem!!, set)
            set.constrainWidth(
                layoutItem.id!!.toInt(),
                jsontocosntratinset.getValue(layoutItem.width!!)
            )
            set.constrainHeight(
                layoutItem.id!!.toInt(),
                jsontocosntratinset.getValue(layoutItem.height!!)
            )

            root.addView(view)
        }
        set.applyTo(root)

        for (layoutItem in model.layout!!.iterator()) {
            if (layoutItem?.isEnabled != null) {
                findViewById<View>(layoutItem.id!!.toInt()).isEnabled =
                    layoutItem.isEnabled.equals("true")
            }
            if (layoutItem?.visiblity != null) {
                findViewById<View>(layoutItem.id!!.toInt()).visibility =
                    jsontocosntratinset.getValue(layoutItem.visiblity)
            }
        }
    }
}
