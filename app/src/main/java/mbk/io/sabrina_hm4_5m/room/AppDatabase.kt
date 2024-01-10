package mbk.io.sabrina_hm4_5m.room

import androidx.room.Database
import androidx.room.RoomDatabase
import mbk.io.sabrina_hm4_5m.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

abstract fun getDao(): LoveDao
}