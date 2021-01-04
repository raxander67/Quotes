package de.raxander.myquotes


import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

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
class QuoteViewMode(application: Application) : AndroidViewModel(application) {
    private var quoteDao = AppDatabase.getDatabase(application).quoteDao()
    val quotes = quoteDao.getQuotes()

    private val _quotes = MutableLiveData<MutableList<Quote>>().apply {
        value = mutableListOf()
    }

    var newQuoteAdded = false
    val hasNoQuotes = Transformations.map(quotes) { quotes.value.isNullOrEmpty() }

    fun createQuote(text: String, author: String, year: String) = viewModelScope.launch {
        newQuoteAdded = true
        quoteDao.insert(Quote(text, author, year))
    }


}