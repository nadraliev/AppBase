package soutvoid.com.appBase.app

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import com.facebook.stetho.Stetho
import io.realm.Realm
import soutvoid.com.appBase.app.dagger.AppComponent
import soutvoid.com.appBase.app.dagger.AppModule
import soutvoid.com.appBase.app.dagger.DaggerAppComponent
import soutvoid.com.appBase.app.log.Logger


class App : Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        initFabric()
        initLogger()
        initInjector()
        initStetho()
        initRealm()
    }

    fun initFabric() {
        Fabric.with(this, Crashlytics())
    }

    fun initLogger() {
        Logger.init()
    }

    fun initInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        )
    }

    fun initRealm() {
        Realm.init(this)
    }
}