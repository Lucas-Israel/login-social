package com.betrybe.sociallogin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val email: TextInputLayout by lazy { findViewById(R.id.email_text_input_layout) }
    private val pass: TextInputLayout by lazy { findViewById(R.id.password_text_input_layout) }
    private val loginBtn: Button by lazy { findViewById(R.id.login_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginBtnEnabler()

    }

    private fun loginBtnEnabler() {
        email.editText?.addTextChangedListener {
            loginBtn.isEnabled = !email.editText?.text.isNullOrEmpty() && !pass.editText?.text.isNullOrEmpty()
        }
        pass.editText?.addTextChangedListener {
            loginBtn.isEnabled = !email.editText?.text.isNullOrEmpty() && !pass.editText?.text.isNullOrEmpty()
        }
    }

}
