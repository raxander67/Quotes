package de.raxander.myquotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/*
• Dao ist ein Interface, das mit Annotation @Dao ausgestattet wird.
• Dao-Interface wird häufig mit „EntityNameDao“ benannt, also bei uns QuoteDao.
• Das Dao deklariert Datenbankzugriffe für Entities durch Funktionen mit passenden Annotationen:
    SELECT -> @Query • INSERT -> (ainsert • UPDATE -* (aUpdate • DELETE -> @Delete
 Im Dao-Interface werden nur die Signaturen der benötigten Datenbank-Funktionen angegeben und Room
    implementiert automatisch die konkreten Funktionen mit passenden SQL-Anweisungen.
• SQL wird meistens nur für Anfragen mit SELECT benötigt.
    SQL für INSERT, UPDATE, DELETE kann in der Regel automatisch von Room generiert werden.
• Falls SQL in Dao geschrieben wird (z.B. für SELECT-Anfragen), dann werden in Android Studio mögliche
    Fehler im SQL während der Entwicklung des Codes angezeigt.
• Mit LiveData für SELECT-Anfragen und suspend aus Kotlin Coroutines für INSERT/UPDATE/DELETE
    werden SQL-Anweisungen automatisch im Hintergrund verarbeitet, ohne den UI-Thread zu blockieren.
 */
@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes ORDER BY id ASC")
    fun getQuotes():LiveData<List<Quote>>

    @Insert
    suspend fun insert(quote: Quote)    //suspend - im Hintegrund

}