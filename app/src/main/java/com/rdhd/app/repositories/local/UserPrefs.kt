package com.rdhd.app.repositories.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object UserPrefs {

    private val SCORE_KEY = "score"
    private val SP = "user_prefs"
    private val TOKEN = "token"

    fun increaseScore(context: Context, amount : Int) {
        val sp = getSharedPreferences(context)
        val score = sp.getInt(SP, 1000)
        sp.edit {
            putInt(SP, score + amount)
        }
    }


    private fun getSharedPreferences(context: Context) = context.getSharedPreferences(SCORE_KEY, Context.MODE_PRIVATE)


    fun score(context: Context) : Int {
        return getSharedPreferences(context).getInt(SP, 1000)
    }

    fun isLoggedIn(context: Context) = !token(context).isNullOrEmpty()

    fun token(context: Context) = getSharedPreferences(context).getString(TOKEN, null)

    fun setToken(context: Context, token : String) {
        val sp = getSharedPreferences(context)
        sp.edit {
            putString(TOKEN, token)
        }
    }
}