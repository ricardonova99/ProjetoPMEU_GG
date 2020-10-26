package ipvc.estg.projetopmeu_gg

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val sharedPref: SharedPreferences = getSharedPreferences(
        getString(R.string.sharedPref), Context.MODE_PRIVATE)

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)
        {
            R.id.add -> true
            R.id.remove -> true
            R.id.edit -> true
            R.id.selectMultiple -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}