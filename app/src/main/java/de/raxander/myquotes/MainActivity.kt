package de.raxander.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import de.raxander.myquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel=ViewModelProvider(this).get(QuoteViewMode::class.java)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this

        val viewPager=binding.quotePager
        val adapter=QuoteViewPageAdapter()
        adapter.setQuotes(viewModel.quotes)
        viewPager.adapter=adapter
    }

}