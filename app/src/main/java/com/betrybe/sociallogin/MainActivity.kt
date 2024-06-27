package com.betrybe.sociallogin

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val email: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val pass: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginBtn: Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // email and password listener
        email.editText?.addTextChangedListener {
            loginBtnEnabler()
            errorCleaner(email)
        }
        pass.editText?.addTextChangedListener {
            loginBtnEnabler()
            errorCleaner(pass)
        }

        // login button logic
        loginBtn.setOnClickListener(this)

    }

    private fun errorCleaner(input: TextInputLayout) {
        // to clear input field error if there is one
        if (input.error != null) input.error = null
    }

    private fun loginBtnEnabler() {
        // if email and password fields are empty, button remains disabled
        loginBtn.isEnabled =
            !email.editText?.text.isNullOrEmpty() && !pass.editText?.text.isNullOrEmpty()
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.login_button -> {
                // email validation
                val emailText = email.editText?.text.toString()
                val isEmailValid: Boolean = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
                if (!isEmailValid) {
                    email.error = getString(R.string.email_warning)
                    return
                }

                // password validation
                val passText = pass.editText?.text.toString()
                if (passText.length < 4) {
                    pass.error = getString(R.string.password_warning)
                    return
                }

                Snackbar.make(loginBtn, R.string.login_succeeded, Snackbar.LENGTH_SHORT)
                    .setAnchorView(loginBtn)
                    .show()
            }
            //
        }
        //
    }
    //
}
