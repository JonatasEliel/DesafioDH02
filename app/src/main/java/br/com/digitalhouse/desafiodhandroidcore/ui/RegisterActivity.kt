package br.com.digitalhouse.desafiodhandroidcore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.domain.Usuario
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpOnClickListeners()
    }

    private fun getUserInfo() = Usuario(
        1,
        regActTietName.text.toString(),
        regActTietEmail.text.toString(),
        regActTietPassword.text.toString().toInt()
    )

    private fun setUpOnClickListeners() {
        regActBtnRegister.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("key", getUserInfo())
            startActivity(intent)
        }
    }
}