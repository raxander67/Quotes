package de.raxander.myquotes


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/*
 * Quote(
"Probleme kann man niemals mit derselben Denkweise lösen, durch die sie enstanden sind.",
"Albert Einstein",
"1948"
),
Quote(
"Man braucht nichts im Leben zu fürchten, man muss nur alles verstehen.",
"Marie Curie",
"1928"
),
Quote(
"Nichts ist so beständig wie der Wandel.", "-- Heraklit", "480 v. Chr."
)
 */
class QuoteViewMode : ViewModel() {
    val quotes: LiveData<MutableList<Quote>>
        get() = _quotes

    private val _quotes = MutableLiveData<MutableList<Quote>>().apply {
        value = mutableListOf()
    }

    var newQuoteAdded = false
    val hasNoQuotes=Transformations.map(quotes){quotes.value.isNullOrEmpty()}

    fun createQuote(text: String, author: String, year: String) {
        newQuoteAdded = true
        val quote = Quote(text, author, year)
        val list = _quotes.value ?: mutableListOf()
        list.add(quote)
        _quotes.value = list
    }


}