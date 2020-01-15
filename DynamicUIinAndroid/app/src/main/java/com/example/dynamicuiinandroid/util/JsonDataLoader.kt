package com.example.dynamicuiinandroid.util

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import com.example.dynamicuiinandroid.customviews.model.LayoutItem
import java.io.IOException

object JsonDataLoader {

    fun loadJSONFromAssets(context: Context, fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json
    }

    val jsontocosntratinset = mapOf<String, Int>(
        "wrap_content" to ConstraintSet.WRAP_CONTENT,
        "match_constraint" to ConstraintSet.MATCH_CONSTRAINT,
        "parentid" to ConstraintSet.PARENT_ID, "left" to ConstraintSet.LEFT,
        "right" to ConstraintSet.RIGHT,
        "top" to ConstraintSet.TOP,
        "bottom" to ConstraintSet.BOTTOM,
        "visible" to View.VISIBLE,
        "invisible" to View.INVISIBLE,
        "gone" to View.GONE
    )

    fun setConnects(layoutItem: LayoutItem, set: ConstraintSet) {
        for (connectionItem in layoutItem.connects!!) {
            val endId =
                if (connectionItem!!.endId!!.equals("parentid")) jsontocosntratinset.getValue(
                    connectionItem.endId!!
                ) else connectionItem.endId!!.toInt()
            set.connect(
                connectionItem.startId!!.toInt(),
                jsontocosntratinset.getValue(connectionItem.startSide!!),
                endId,
                jsontocosntratinset.getValue(connectionItem.endSide!!),
                connectionItem.margin!!.toInt()
            )
        }
    }

}
