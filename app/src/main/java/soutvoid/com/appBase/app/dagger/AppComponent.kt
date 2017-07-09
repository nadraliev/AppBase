package soutvoid.com.appBase.app.dagger

import android.content.Context
import com.agna.ferro.mvp.component.scope.PerApplication
import dagger.Component

@PerApplication
@Component(modules = arrayOf(
        AppModule::class
))
interface AppComponent {
    fun context() : Context
}