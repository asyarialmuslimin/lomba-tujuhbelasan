package tech.saifurridho.lombatujuhbelasan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import tech.saifurridho.lombatujuhbelasan.Adapter.LombaAdapter
import tech.saifurridho.lombatujuhbelasan.Model.Lomba
import tech.saifurridho.lombatujuhbelasan.Model.LombaData

class MainActivity : AppCompatActivity() {

    private lateinit var rview: RecyclerView
    private var list: ArrayList<Lomba> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rview = findViewById(R.id.rview)
        rview.setHasFixedSize(true)

        list.addAll(LombaData.listData)
        showRecyclerView()
    }

    private fun showRecyclerView(){
        rview.layoutManager = LinearLayoutManager(this)
        val lombaAdapter = LombaAdapter(list)
        rview.adapter = lombaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_profile -> {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }
}