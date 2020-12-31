package de.raxander.myquotes


import androidx.lifecycle.ViewModel

class QuoteViewMode:ViewModel(){

    val quotes = listOf(
        Quote(
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
    )

   /* private var index=0
    private var _quote= MutableLiveData<Quote>().apply { value=quotes[index] }
    val quote:LiveData<Quote>
        get()=_quote
    val isFirst=Transformations.map(quote){index==0}
    val isLast=Transformations.map(quote){index==quotes.size-1}

    fun nextQuote() {
        if (index < quotes.size - 1) {
            index++
            _quote.value=quotes[index]
        }
    }

    fun previousQuote() {
        if (index > 0) {
            index--
            _quote.value=quotes[index]
        }

    }*/
}