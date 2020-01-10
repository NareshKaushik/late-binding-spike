package com.example.dynamicuiinandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        val emailLabel = TextView(context)
        val emailEditText = EditText(context)

        val passwordLabel = TextView(context)
        val passwordEditText = EditText(context)

        val loginButton = Button(context)
        val resetButton = Button(context)
        loginButton.setBackgroundColor(Color.GREEN)
        resetButton.setBackgroundColor(Color.YELLOW)
        loginButton.text = "Login"
        resetButton.text = "Reset"
        emailEditText.hint = "Enter Email"

        passwordEditText.hint = "Enter Password"

        emailEditText.id = 200
        emailLabel.id = 100
        passwordEditText.id = 300
        passwordLabel.id = 400
        loginButton.id = 500
        resetButton.id=600
        passwordLabel.text = "Password"
        emailLabel.text = "Email Id"
        val root = ConstraintLayout(context)
        root.addView(emailLabel)
        root.addView(emailEditText)
        root.addView(passwordEditText)
        root.addView(passwordLabel)
        root.addView(loginButton)
        root.addView(resetButton)
        setContentView(root)

        val set = ConstraintSet()
        //Set for Email Label
        set.constrainHeight(emailLabel.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(emailLabel.id, ConstraintSet.WRAP_CONTENT)
        set.connect(
            emailLabel.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            emailLabel.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,
            70
        )
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
        set.constrainWidth(loginButton.id, ConstraintSet.MATCH_CONSTRAINT)
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
        set.connect(
            loginButton.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT,
            50
        )

        //set For Clear Button

        set.constrainHeight(resetButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(resetButton.id, ConstraintSet.MATCH_CONSTRAINT)
        set.connect(
            resetButton.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT,
            50
        )

        set.connect(
            resetButton.id,
            ConstraintSet.TOP,
            loginButton.id,
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
