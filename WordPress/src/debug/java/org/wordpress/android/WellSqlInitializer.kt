package org.wordpress.android

import android.content.Context
import com.yarolegovich.wellsql.WellSql
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WellSqlInitializer @Inject constructor(private val context: Context) {
    fun init() {
        val wellSqlConfig = WPWellSqlConfig(context)
        WellSql.init(wellSqlConfig)
    }
}
