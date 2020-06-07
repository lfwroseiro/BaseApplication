package br.com.baseapplication.provider

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import br.com.baseapplication.entity.Values.ZERO_VALUE

@SuppressLint("Registered")
open class BaseContentProvider : ContentProvider() {

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return ZERO_VALUE
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return ZERO_VALUE
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}