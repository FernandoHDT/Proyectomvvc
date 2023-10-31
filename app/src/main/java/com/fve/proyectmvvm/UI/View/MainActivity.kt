package com.fve.proyectmvvm.UI.View

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.fve.proyectmvvm.Data.Database.DBapp
import com.fve.proyectmvvm.databinding.ActivityMainBinding
import com.fve.proyectmvvm.UI.viewmodel.QuoteViewModel
import kotlinx.coroutines.launch


private lateinit var binding: ActivityMainBinding



class MainActivity : AppCompatActivity() {
    //val app = applicationContext as DBapp
    private val quoteViewModel: QuoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQ.text = currentQuote.quote
            binding.tvA.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
        binding.ViewContainer.setOnClickListener{quoteViewModel.randomQuote()}
        /*lifecycleScope.launch {
            val listado= app.room.bdDAO().getAll()
            Log.d("","onCreate ${listado}" )
        }*/


    }
}