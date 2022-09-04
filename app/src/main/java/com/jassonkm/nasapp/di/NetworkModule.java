package com.jassonkm.nasapp.di;

import static com.jassonkm.nasapp.utils.Constants.BASE_URL_NASA;

import com.jassonkm.nasapp.BuildConfig;
import com.jassonkm.nasapp.data.datasource.remote.network.nasa.NasaApi;
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Singleton
    @Provides
    public static HttpLoggingInterceptor provideLoggingInterceptor() {
         HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
         httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
         return httpLoggingInterceptor;
    }

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL_NASA)
                .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public static NasaApi provideApiService(Retrofit retrofit) {
        return retrofit.create(NasaApi.class);
    }
}