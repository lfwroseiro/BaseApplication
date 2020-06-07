package br.com.baseapplication.provider

import br.com.baseapplication.BuildConfig
import com.facebook.stetho.Stetho

class StethoProvider : BaseContentProvider() {

    override fun onCreate(): Boolean {
        if (BuildConfig.DEBUG) {
            context?.let(Stetho::initializeWithDefaults)
        }
        return true
    }
}