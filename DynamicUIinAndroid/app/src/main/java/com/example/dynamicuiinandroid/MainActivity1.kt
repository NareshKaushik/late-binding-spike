package com.example.dynamicuiinandroid

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.dynamicuiinandroid.customviews.DEPButton
import com.example.dynamicuiinandroid.customviews.DEPEditText
import com.example.dynamicuiinandroid.customviews.DEPTextView


class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        val set = ConstraintSet()

        val emailLabel = DEPTextView(context, 100, "Enter Eamil", Color.BLACK)
        val emailEditText = DEPEditText(context, 200, "Email", Color.BLACK)

        val passwordLabel = DEPTextView(context, 400, "Enter Password", Color.BLACK)
        val passwordEditText = DEPEditText(context, 300, "Password", Color.BLACK)

        val loginButton = DEPButton(context, 500, "Login", Color.BLACK, Color.GREEN)
        val resetButton = DEPButton(context, 600, "Reset", Color.BLACK, Color.RED)

        val root = ConstraintLayout(context)
        root.addView(emailLabel)
        root.addView(emailEditText)
        root.addView(passwordEditText)
        root.addView(passwordLabel)
        root.addView(loginButton)
        root.addView(resetButton)
        setContentView(root)


        //Set for Email Label

        //Set for Password  Label
        set.constrainHeight(passwordLabel.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(passwordLabel.id, ConstraintSet.WRAP_CONTENT)
        set.connect(
            passwordLabel.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            passwordLabel.id,
            ConstraintSet.TOP,
            emailEditText.id,
            ConstraintSet.BOTTOM,
            70
        )
        //Set for Email EditText
        set.constrainHeight(emailEditText.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(emailEditText.id, ConstraintSet.MATCH_CONSTRAINT)
        set.connect(
            emailEditText.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            emailEditText.id,
            ConstraintSet.TOP,
            emailLabel.id,
            ConstraintSet.BOTTOM,
            70
        )
        set.connect(
            emailEditText.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            50
        )
//Set for Password EditText
        set.constrainHeight(passwordEditText.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(passwordEditText.id, ConstraintSet.MATCH_CONSTRAINT)
        set.connect(
            passwordEditText.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            passwordEditText.id,
            ConstraintSet.TOP,
            passwordLabel.id,
            ConstraintSet.BOTTOM,
            70
        )
        set.connect(
            passwordEditText.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            50
        )
//Set for Login Button
        set.constrainHeight(loginButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(loginButton.id, ConstraintSet.WRAP_CONTENT)
        set.connect(
            loginButton.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            loginButton.id,
            ConstraintSet.TOP,
            passwordEditText.id,
            ConstraintSet.BOTTOM,
            70
        )
        //set For Clear Button
        set.constrainHeight(resetButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(resetButton.id, ConstraintSet.MATCH_CONSTRAINT)
        set.connect(
            resetButton.id,
            ConstraintSet.TOP,
            passwordEditText.id,
            ConstraintSet.BOTTOM,
            70
        )
        set.connect(
            resetButton.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            50
        )
        set.applyTo(root)
    }
}
