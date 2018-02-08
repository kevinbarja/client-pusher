package com.icorebiz.clientpusher.preference

import android.content.Context
import org.jetbrains.anko.AnkoLogger
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class BasePreference(private val context: Context, private val key: String):  AnkoLogger {

    val prefs by lazy {
        context.getSharedPreferences(key, Context.MODE_PRIVATE)!!
    }

     inner class PreferenceDelegate<T> : ReadWriteProperty<Any?, T> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
//          TODO: ENCRYPT
            return findPreference(property.returnType.toString(), property.name)
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
//          TODO: DECRYPT
            putPreference(property.name, value)
        }

        private fun <T> findPreference(type: String, name: String): T = with(prefs) {
            val res: Any = when (type) {
                "kotlin.Long" -> getLong(name, 0L)
                "kotlin.String" -> getString(name, "")
                "kotlin.Int" -> getInt(name, 0)
                "kotlin.Boolean" -> getBoolean(name, false)
                "kotlin.Float" -> getFloat(name, 0F)
                else -> throw IllegalArgumentException("This type can't be saved into Preferences ")
            }
            res as T
        }

        private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
            when (value) {
                is Long -> putLong(name, value)
                is String -> putString(name, value)
                is Int -> putInt(name, value)
                is Boolean -> putBoolean(name, value)
                is Float -> putFloat(name, value)
                else -> throw IllegalArgumentException("This type can't be saved into Preferences")
            }.apply()
        }
    }
}