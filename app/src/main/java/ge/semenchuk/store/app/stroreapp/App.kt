package ge.semenchuk.store.app.stroreapp

import android.app.Application
import ge.semenchuk.store.app.stroreapp.di.data
import ge.semenchuk.store.app.stroreapp.di.domain
import ge.semenchuk.store.app.stroreapp.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                level = Level.ERROR
            )
            androidContext(
                androidContext = this@App
            )
            modules(presentation, domain, data)
        }
    }
}