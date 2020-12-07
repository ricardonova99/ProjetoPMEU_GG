package ipvc.estg.projetopmeu_gg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import ipvc.estg.projetopmeu_gg.api.EndPoints
import ipvc.estg.projetopmeu_gg.api.ServiceBuilder
import ipvc.estg.projetopmeu_gg.api.Utilizador
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private val mapsActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPref: SharedPreferences = getSharedPreferences(
            getString(R.string.sharedPref), Context.MODE_PRIVATE)

        val notesButton = findViewById<Button>(R.id.notesButton)
        notesButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, NotasActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            /* val request = ServiceBuilder.buildService(EndPoints::class.java)
            val call = request.getUtilizador("Diogo", "123")
            call.enqueue(object : Callback<Utilizador> {
                override fun onResponse(call: Call<Utilizador>, response: Response<Utilizador>) {
                    if (response.isSuccessful) {*/
                        val intent = Intent(this@LoginActivity, MapsActivity::class.java)
                        startActivityForResult(intent, mapsActivityRequestCode)
                        /*}
                    Toast.makeText(this@LoginActivity, response.body()!!.nome, Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Utilizador>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })*/
        }
    }
}
