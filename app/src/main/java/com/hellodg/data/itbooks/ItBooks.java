package com.hellodg.data.itbooks;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.inject.Inject;


public final class ItBooks {
	@SerializedName("Error") private int mError;
	@SerializedName("Time") private float mTime;
	@SerializedName("Total") private String mTotal;
	@SerializedName("Page") private int mPage;
	@SerializedName("Books") private List<Book> mBookList;


	@Inject
	public ItBooks() {

	}

	public ItBooks(int error, float time, String total, int page, List<Book> bookList) {
		mError = error;
		mTime = time;
		mTotal = total;
		mPage = page;
		mBookList = bookList;
	}

	public int getError() {
		return mError;
	}

	public float getTime() {
		return mTime;
	}

	public String getTotal() {
		return mTotal;
	}

	public int getPage() {
		return mPage;
	}


	public List<Book> getBookList() {
		return mBookList;
	}
}
