package com.hellodg.itbooks;

import com.hellodg.data.itbooks.ItBooks;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface Service {
	@GET("v1/search/android")
	Observable<ItBooks> itbooks();
}
