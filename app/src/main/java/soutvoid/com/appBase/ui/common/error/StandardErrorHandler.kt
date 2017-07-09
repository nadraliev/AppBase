package soutvoid.com.appBase.ui.common.error

import com.agna.ferro.mvp.component.scope.PerScreen
import soutvoid.com.appBase.R
import soutvoid.com.appBase.app.log.Logger
import soutvoid.com.appBase.interactor.common.network.error.ConversionException

import java.util.Locale

import javax.inject.Inject

import soutvoid.com.appBase.interactor.common.network.error.HttpCodes
import soutvoid.com.appBase.interactor.common.network.error.HttpError
import soutvoid.com.appBase.interactor.common.network.error.NoInternetException
import soutvoid.com.appBase.ui.common.message.MessagePresenter


@PerScreen
class StandardErrorHandler @Inject
constructor(private val messagePresenter: MessagePresenter) : ErrorHandler() {


    override fun handleHttpError(e: HttpError) {
        if (e.code >= HttpCodes.CODE_500) {
            messagePresenter.show(R.string.server_error_message)
        } else {
            messagePresenter.show(String.format(Locale.getDefault(), "%d %s", e.code, e.message))
        }
    }

    override fun handleNoInternetError(e: NoInternetException) {
        messagePresenter.show(R.string.no_internet_connection_error_message)
    }

    override fun handleConversionError(e: ConversionException) {
        messagePresenter.show(R.string.bad_response_error_message)
    }

    override fun handleOtherError(e: Throwable) {
        messagePresenter.show(R.string.unexpected_error_error_message)
        Logger.e(e, "Unexpected error")
    }
}
