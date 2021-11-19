package com.example.mycryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycryptoapp.pojo.CoinPriceInfo
import com.google.android.material.circularreveal.CircularRevealHelper

@Dao
interface CoinPriceInfoDao {
    @Query ("SELECT * FROM full_price_list ORDER BY highHour DESC")
    fun getPriceList() : LiveData<List<CoinPriceInfo>>

    @Query ("SELECT * FROM full_price_list WHERE fromSymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String) : LiveData<CoinPriceInfo>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceList(priceList : List<CoinPriceInfo>)
}