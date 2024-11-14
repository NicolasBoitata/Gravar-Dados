package com.test.gravardados

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.test.gravardados.databinding.ActivityTelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {

    lateinit var binding: ActivityTelaPrincipalBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btDeslogar.setOnClickListener {
//            FirebaseAuth.getInstance().signOut()
//            val voltarTelaLogin = Intent(this, FormLogin::class.java)
//            startActivity(voltarTelaLogin)
//            finish()
//        }

        binding.btGravarDadosDB.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this, FormLogin::class.java)
            startActivity(voltarTelaLogin)
            finish()
        }

        binding.btGravarDadosDB.setOnClickListener{
            val usuariosMap = hashMapOf(
                "nome" to "Marcos",
                "sobrenome" to "Duarte Gomes",
                "idade" to 28
            )
            db.collection("Usuários").document("Marcos")
            .set(usuariosMap).addOnCompleteListener {
            Log.d("db", "Sucesso ao salvar os dados do usuário!")
        }.addOnFailureListener {
            }
        }
    }
}