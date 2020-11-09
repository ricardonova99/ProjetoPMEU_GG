package ipvc.estg.projetopmeu_gg

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.projetopmeu_gg.R
import ipvc.estg.projetopmeu_gg.ViewModel.NotaViewModel
import ipvc.estg.projetopmeu_gg.adapters.NotaAdapter
import ipvc.estg.projetopmeu_gg.entities.Nota


class MainActivity : AppCompatActivity(), CellClickListener {

    private lateinit var notaViewModel: NotaViewModel
    private val newWordActivityRequestCode = 1
    private var adapter: NotaAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.listaNotas)
        adapter = NotaAdapter(this, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // view model
        notaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)
        notaViewModel.allNotas.observe(this, Observer { notas ->
            // Update the cached copy of the words in the adapter.
            notas?.let { adapter!!.setNotas(it) }
        })

        val sharedPref: SharedPreferences = getSharedPreferences(
            getString(R.string.sharedPref), Context.MODE_PRIVATE)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val ptitulo = data?.getStringExtra(AddNota.EXTRA_REPLY_TITULO)
            val pdescricao = data?.getStringExtra(AddNota.EXTRA_REPLY_DESCRICAO)

            if (ptitulo != null && pdescricao != null) {
                val nota = Nota(titulo = ptitulo, descricao = pdescricao)
                notaViewModel.insert(nota)
            }

        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)
        {
            R.id.add ->
            {
                val intent = Intent(this@MainActivity, AddNota::class.java)
                startActivityForResult(intent, newWordActivityRequestCode)
                true
            }

            R.id.remove ->
            {
                adapter!!.selectedNota?.id?.let { notaViewModel.deleteByID(it) }

                true
            }

            R.id.edit -> true

            R.id.removeAll ->
            {
                notaViewModel.deleteAll()
                true
            }
            /* R.id.selectMultiple -> true
             */
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCellClickListener(data: Nota) {
        //Toast.makeText(this, data.id.toString(), Toast.LENGTH_SHORT).show()
    }
}