package de.raxander.myquotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quote.view.*

/**
 *
  RecyclerView.Adapter

   Eine eigene Klasse wird als Subklasse von RecyclerViewAdapter deklariert und
   muss mindestens diese Funktionen implementieren:

∙ onCreateViewHo1der()
    Liefert eine neue ViewHoIder-Instanz für einzelne Elemente der Liste bzw. des
    Pagers. Der ViewHoIder wird meist an ein Layeut gebunden.

∙ onBindViewHo1der()
    Bindet ein Element der Liste bzw. des Pagers zur Darstellung an eine
    ViewHoIder-Instanz (wird ggf. wiedervenNendet → „RecycIerView“).

∙ getItemCount()
    Gibt die Anzahl der Elemente des RecycIerViews zurück.
 */

class QuoteViewPageAdapter : RecyclerView.Adapter<QuoteViewPageAdapter.QuoteViewHolder>() {
    private var quotes = emptyList<Quote>()
    override fun getItemCount() =/* Anzah den Zitaten*/ quotes.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        // View erzeugen für  Layout aus quote.xml
        val quoteView = LayoutInflater.from(parent.context).inflate(R.layout.quote, parent, false)
        return QuoteViewHolder(quoteView)
    }

    fun setQuotes(quotes: List<Quote>) {
        this.quotes = quotes
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        // wird beim Blättern im Adapter aufgerufen
        with(quotes[position]) {
            holder.content.text = text
            holder.author.text = author
            holder.year.text = year
        }
    }

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referenzen der Elemente für Inhalt, Autor und Jahr
        val content = itemView.quote_text
        val author = itemView.quote_author
        val year = itemView.quote_year
    }
}