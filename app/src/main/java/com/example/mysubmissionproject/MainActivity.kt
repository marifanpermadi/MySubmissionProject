package com.example.mysubmissionproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<Foods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        list.addAll(getListFoods())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodsAdapter = ListFoodsAdapter(list)
        rvFoods.adapter = listFoodsAdapter
    }

    private fun getListFoods(): ArrayList<Foods> {
        val dataName = resources.getStringArray(R.array.foods_name)
        val dataDescription = resources.getStringArray(R.array.foods_description)
        val dataPhoto = resources.obtainTypedArray(R.array.foods_photo)
        val dataPrice = resources.getStringArray(R.array.foods_price)
        val dataOrigin = resources.getStringArray(R.array.foods_origin)
        val listFoods = ArrayList<Foods>()

        for (i in dataName.indices) {
            val foods = Foods(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPrice[i], dataOrigin[i])
            listFoods.add(foods)
        }
        return listFoods
    }
}