package com.example.tm.data

import androidx.datastore.preferences.core.intPreferencesKey

object DataStoreManager {
    const val FILTER_PREFERENCES_NAME = "filter_preferences"

    val FILTER_INDEX_KEY = intPreferencesKey("FILTER_INDEX")

}