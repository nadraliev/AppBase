package soutvoid.com.appBase.ui.common.dagger

import dagger.Module
import soutvoid.com.appBase.ui.base.activity.ActivityModule
import soutvoid.com.appBase.ui.common.error.ErrorHandlerModule

@Module(includes = arrayOf(
        ActivityModule::class,
        ErrorHandlerModule::class
))
class ActivityViewModule