package soutvoid.com.appBase.ui.screen.main

import android.os.Bundle
import com.agna.ferro.mvp.component.ScreenComponent
import soutvoid.com.appBase.R
import soutvoid.com.appBase.ui.base.activity.BaseActivityView
import soutvoid.com.appBase.ui.base.activity.BasePresenter
import javax.inject.Inject

class MainActivityView : BaseActivityView() {

    @Inject
    lateinit var presenter : MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        super.onCreate(savedInstanceState, viewRecreated)
    }

    override fun getPresenter(): BasePresenter<*> = presenter

    override fun getName(): String = "MainActivity"

    override fun getContentView(): Int = R.layout.activity_main

    override fun createScreenComponent(): ScreenComponent<*> {
        return DaggerMainActivityComponent.builder()
                .activityModule(activityModule)
                .appComponent(appComponent)
                .build()
    }
}