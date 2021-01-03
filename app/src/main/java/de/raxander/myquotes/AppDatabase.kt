package de.raxander.myquotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
Verbindung zur Room-Datenbank
• Für die eigentliche Datenbankverbindung wird eine eigene abstrakte Klasse als Subklasse von
androidx.room.RoomDatabase deklariert und mit (aDatabase annotiert.
• In der Annotation @Database werden die Entities und die Versionsnummer angegeben:
    @Database(entities = [Quote::class], version = 1)
    abstract class AppDatabase : RoomDatabase()
• Die Tabellen für die Entities werden von Room erstellt und mit version ist es möglich,
    Datenbankmigrationen zu späteren Zeitpunkten duchzuführen (neue/geänderte Tabellen etc.).
• getter-Funktionen für die zuvor definierten Daos werden als abstrakte Funktionen deklariert
    und Room wird sich automatisch um die eigentliche Implementierung kümmern:
    abstract fun quoteDao(): QuoteDao
• Eine konkrete Datenbankverbindung für die App wird mit Room.databaseBuilder () hergestellt.
• Es sollte höchtens eine Verbindung bestehen, daher wird AppDatabase als Singleton implementiert.
• Daos können dann z.B. in den ViewModels verwendet werden.
 */

@Database(entities = [Quote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            if (instance==null) {
                instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quotes.db"
                ).build()
            }
            return instance!!
        }
    }
}