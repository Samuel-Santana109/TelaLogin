package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        // Obtém a referência para o botão saveButton e para o EditText nameEditText no layout
        val saveButton: Button = findViewById(R.id.saveButton)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)

        // Configura o listener para o botão saveButton
        saveButton.setOnClickListener {
            // Obtém o nome digitado no EditText
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            //verifica se o usuário inseriu no campo nome
            if (name.isNullOrEmpty() == false && email.isNullOrEmpty() == false){
                // Cria um Intent para enviar o nome de volta para a MainActivity
                val intent = Intent()
                intent.putExtra("name", name)
                intent.putExtra("email", email)

                // Define o resultado como RESULT_OK e envia o Intent de volta
                setResult(RESULT_OK, intent)

                // Finaliza a AddDataActivity
                finish()
            }
            else {
                //caso não tenha inserido então é diparado uma menságem para o usuário
                Toast.makeText(this, "preencher o formulário", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
