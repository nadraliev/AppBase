package soutvoid.com.appBase.interactor.common.network.error

import soutvoid.com.appBase.interactor.common.network.response.BaseResponse


class HttpError(message: String, cause: Throwable, val code: Int, val errorResponse: BaseResponse) : NetworkException(message, cause)
