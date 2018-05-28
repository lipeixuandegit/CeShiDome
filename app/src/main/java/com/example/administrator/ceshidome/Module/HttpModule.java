package com.example.administrator.ceshidome.Module;

import com.example.administrator.ceshidome.net.Api;
import com.example.administrator.ceshidome.net.MobileAPi;
import com.example.administrator.ceshidome.net.MobileAPiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/28.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder providesOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.MINUTES)
                .writeTimeout(20,TimeUnit.MINUTES)
                .connectTimeout(10,TimeUnit.MINUTES);
    }
    @Provides
    MobileAPi provideMobileAPi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        MobileAPiService mobileAPiService = retrofit.create(MobileAPiService.class);
        return MobileAPi.getMobileAPi(mobileAPiService);


    }

}
