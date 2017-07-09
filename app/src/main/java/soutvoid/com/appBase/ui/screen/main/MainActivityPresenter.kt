package soutvoid.com.appBase.ui.screen.main

import com.agna.ferro.mvp.component.scope.PerScreen
import soutvoid.com.appBase.ui.base.activity.BasePresenter
import soutvoid.com.appBase.ui.common.error.ErrorHandler
import javax.inject.Inject

@PerScreen
class MainActivityPresenter @Inject constructor(errorHandler: ErrorHandler) : BasePresenter<MainActivityView>(errorHandler) {



}