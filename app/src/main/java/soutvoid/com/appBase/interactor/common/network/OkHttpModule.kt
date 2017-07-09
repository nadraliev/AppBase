package soutvoid.com.appBase.interactor.common.network

import com.agna.ferro.mvp.component.scope.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import soutvoid.com.appBase.interactor.common.network.cache.RequestCacheInterceptor
import soutvoid.com.appBase.interactor.common.network.cache.ResponseCacheInterceptor
import soutvoid.com.appBase.interactor.common.network.request.RequestHeadersInterceptor
import java.util.concurrent.TimeUnit

@Module
class OkHttpModule {

    companion object {
        val NETWORK_TIMEOUT = 10L
    }

    @Provides
    @PerApplication
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                            requestHeadersInterceptor: RequestHeadersInterceptor,
                            responseCacheInterceptor: ResponseCacheInterceptor,
                            requestCacheInterceptor: RequestCacheInterceptor,
                            cache: Cache) : OkHttpClient {
        val okHttpClientBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)

        okHttpClientBuilder.addInterceptor(requestHeadersInterceptor)
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        okHttpClientBuilder.addInterceptor(requestCacheInterceptor)
        okHttpClientBuilder.addNetworkInterceptor(responseCacheInterceptor)
        okHttpClientBuilder.cache(cache)
        return okHttpClientBuilder.build()
    }

}