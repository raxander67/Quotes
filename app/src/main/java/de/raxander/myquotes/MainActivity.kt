package de.raxander.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.raxander.myquotes.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.dialog_new_quote.*

class MainActivity : AppCompatActivity() {
    private lateinit var dialog: AlertDialog
    private lateinit var viewModel: QuoteViewMode


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(QuoteViewMode::class.java)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this

        val viewPager=binding.quotePager
        val adapter=QuoteViewPageAdapter()
        viewPager.adapter=adapter
        viewModel.quotes.observe(this, Observer { quotes->
            adapter.setQuotes(quotes)
            if(viewModel.newQuoteAdded)
            viewPager.setCurrentItem(quotes.size-1,true)
            viewModel.newQuoteAdded=false
        })

    }

    fun addQuote(view: View){
        //Dialog anzeigen
        val builder= AlertDialog.Builder(this)
        builder.apply {
            setTitle("Neues Zitat")
            setView(R.layout.dialog_new_quote)
            setPositiveButton("Ok"){dialog,id->
                createQuote()
            }
            setNegativeButton("Abbrechen",null)
        }
        dialog=builder.create()
        dialog.show()

    }

    private fun createQuote() {
        val text=dialog.new_quote_text.text.toString()
        val author=dialog.new_quote_author.text.toString()
        val year=dialog.new_quote_year.text.toString()
        viewModel.createQuote(text,author,year)
    }
}