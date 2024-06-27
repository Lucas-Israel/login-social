package com.betrybe.sociallogin

import android.os.Bundle
import android.view.View
import android.widget.Button
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
        email.editText?.addTextChangedListener { loginBtnEnabler() }
        pass.editText?.addTextChangedListener { loginBtnEnabler() }
        loginBtn.setOnClickListener(this)

    }

    private fun loginBtnEnabler() {
        loginBtn.isEnabled = !email.editText?.text.isNullOrEmpty() && !pass.editText?.text.isNullOrEmpty()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}
