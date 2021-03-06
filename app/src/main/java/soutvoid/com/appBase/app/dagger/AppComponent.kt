package soutvoid.com.appBase.app.dagger

import android.content.Context
import com.agna.ferro.mvp.component.scope.PerApplication
import dagger.Component
import soutvoid.com.appBase.interactor.common.network.NetworkModule
import soutvoid.com.appBase.interactor.common.network.OkHttpModule
import soutvoid.com.appBase.interactor.common.network.cache.CacheModule
import soutvoid.com.appBase.interactor.network.NetworkConnectionChecker
import soutvoid.com.appBase.ui.base.activity.ActivityModule

@PerApplication
@Component(modules = arrayOf(
        AppModule::class,
        OkHttpModule::class,
        NetworkModule::class,
        CacheModule::class,
        ActivityModule::class
))
interface AppComponent {
    fun context() : Context
    fun networkConnectionChecker() : NetworkConnectionChecker
}