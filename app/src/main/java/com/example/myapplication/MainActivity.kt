package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


 /*   val imagemFooter = findViewById<ImageView>(R.id.imagem)
    imagemFooter.load(("https://w1.pngwing.com/pngs/808/946/png-transparent-email-symbol-password-installation-login-user-account-computer-software-data-padlock.png"))
*/

    private lateinit var addButton: Button
    private lateinit var dataTextView: TextView

    private val dataList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //Faz a ligaçao entre a actviety e a view
        setContentView(R.layout.activity_main)

        // Inicialização dos componentes de interface
        addButton = findViewById(R.id.addButton)
        dataTextView = findViewById(R.id.dataTextView)

        // Configuração do listener para o botão "Adicionar"
        addButton.setOnClickListener {
            // Cria um Intent para abrir a AddDataActivity
            val intent = Intent(this, AddDataActivity::class.java)
            // Inicia a activity esperando um resultado
            startActivityForResult(intent, ADD_DATA_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Verifica se o resultado é da activity AddDataActivity
        if (requestCode == ADD_DATA_REQUEST_CODE && resultCode == RESULT_OK) {
            // Obtém o nome adicionado da Intent
            val name = data?.getStringExtra("name")
            val email = data?.getStringExtra("email")
            name?.let {
                // Adiciona o nome à lista de dados
                dataList.add(it)
                // Atualiza o TextView com os dados atualizados
                updateDataTextView()
            }
            email?.let {
                // Adiciona o email à lista de dados
                dataList.add(it)
                // Atualiza o TextView com os dados atualizados
                updateDataTextView()
            }
        }
    }

    private fun updateDataTextView() {
        // Junta os dados em uma única string separada por quebras de linha
        val dataText = dataList.joinToString("\n")

        // Atualiza o texto do TextView com os dados
        dataTextView.text = dataText
    }

    companion object {
        private const val ADD_DATA_REQUEST_CODE = 1
    }



}