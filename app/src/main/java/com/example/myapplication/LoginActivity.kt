package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    //inicia as variáveis que irá buscar os dados na tela
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //obtem a referência do usernameEditText, passwordEditText, loginButton
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        //Configura o listener para o botão loginButton
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Verifique as credenciais do usuário aqui
            if (username == "admin" && password == "12345") {
                // Credenciais corretas, vá para a próxima atividade que é a tela incial do app
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Credenciais incorretas, exiba uma mensagem de erro
                Toast.makeText(this, "Usuário e senha errado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
