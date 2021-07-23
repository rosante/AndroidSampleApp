package com.example.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular.setOnClickListener(){
            val resultado = resultado
            val nota1 = Integer.parseInt(nota1.text.toString())
            val nota2 = Integer.parseInt(nota2.text.toString())
            val faltas = Integer.parseInt(faltas.text.toString())

            val media = calculaMedia(nota1, nota2)
            val mensagem = calculaAprovado(media, faltas)
            resultado.setText(mensagem)

        }
    }

    fun calculaMedia(nota1:Int, nota2:Int):Double = (nota1+nota2/2).toDouble()
    fun calculaAprovado(media:Double, faltas:Int):String{
        if (media >= 6 && faltas < 11){
            resultado.setTextColor(Color.parseColor("#5555FF"))
            return "Aluno aprovado. \nMédia: ${media.toString()} \nFaltas: ${faltas.toString()}"
        }
        else {
            resultado.setTextColor(Color.parseColor("#FF5555"))
            return "Aluno reprovado. \nMédia: ${media.toString()} \nFaltas: ${faltas.toString()}"
        }
    }
}