package com.hellodg.itbooks;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
	private String mUrl;

	public RetrofitModule(String url) {
		mUrl = url;
	}

	@Provides
	Retrofit provideRetrofit() {
		return new Retrofit.Builder().baseUrl(mUrl)
		                             .addConverterFactory(GsonConverterFactory.create())
		                             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
		                             .build();
	}



}
