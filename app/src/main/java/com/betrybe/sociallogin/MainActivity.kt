package com.betrybe.sociallogin

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val email: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val pass: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginBtn: Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // email and password listener
        email.editText?.addTextChangedListener { loginBtnEnabler() }
        pass.editText?.addTextChangedListener { loginBtnEnabler() }

        // login button logic
        loginBtn.setOnClickListener(this)

    }

    // function for enabling login button
    private fun loginBtnEnabler() {
        // to clear email error if there is one.
        if (email.error != null) email.error = null
        // if email and password field are empty, button remains disabled
        loginBtn.isEnabled = !email.editText?.text.isNullOrEmpty() && !pass.editText?.text.isNullOrEmpty()
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            // Email validation
            R.id.login_button -> {
                val emailText = email.editText?.text.toString()
                val isEmailValid: Boolean = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
                if (!isEmailValid) {
                    email.error = getString(R.string.email_warning)
                }
            }
        }
    }

}
