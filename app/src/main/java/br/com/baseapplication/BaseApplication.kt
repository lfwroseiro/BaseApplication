package br.com.baseapplication

import android.app.Application
import br.com.baseapplication.data.di.DataModules.dataModules
import br.com.baseapplication.di.AppModules.appModules
import br.com.baseapplication.domain.di.DomainModules.domainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class BaseApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(appModules.plus(dataModules.plus(domainModules)))
        }
    }
}
