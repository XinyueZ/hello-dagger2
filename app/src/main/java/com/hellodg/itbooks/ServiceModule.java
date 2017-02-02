package com.hellodg.itbooks;


import com.hellodg.data.itbooks.ItBooks;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Module
public class ServiceModule {
	private ItBooks mItBooks;

	public ServiceModule(ItBooks itBooks) {
		mItBooks = itBooks;
	}

	public ServiceModule() {
	}

	@Provides
	static Observable<ItBooks> provideObservableItBooks(Retrofit retrofit) {
		return retrofit.create(Service.class)
		               .itbooks()
		               .subscribeOn(Schedulers.io())
		               .observeOn(AndroidSchedulers.mainThread());
	}

	@Provides
	ItBooks provideItBooks() {
		return mItBooks;
	}
}
