package soutvoid.com.appBase.ui.base.activity

import com.agna.ferro.core.PersistentScreenScope
import com.agna.ferro.mvp.component.provider.ActivityProvider
import com.agna.ferro.mvp.component.scope.PerScreen
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(val persistentScreenScope: PersistentScreenScope) {

    @Provides
    @PerScreen
    fun provideActivityProvider() : ActivityProvider = ActivityProvider(persistentScreenScope)

}