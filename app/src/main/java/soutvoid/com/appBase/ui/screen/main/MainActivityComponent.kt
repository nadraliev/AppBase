package soutvoid.com.appBase.ui.screen.main

import com.agna.ferro.mvp.component.ScreenComponent
import com.agna.ferro.mvp.component.scope.PerScreen
import dagger.Component
import soutvoid.com.appBase.app.dagger.AppComponent
import soutvoid.com.appBase.ui.common.dagger.ActivityViewModule

@PerScreen
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityViewModule::class))
interface MainActivityComponent : ScreenComponent<MainActivityView>