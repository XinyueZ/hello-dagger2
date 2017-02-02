package com.hellodg.data.itbooks;

import com.google.gson.annotations.SerializedName;

public final class Book {


	@SerializedName("ID") private long mId;
	@SerializedName("Title") private String mTitle;
	@SerializedName("SubTitle") private String mSubTitle;
	@SerializedName("Description") private String mDescription;
	@SerializedName("Image") private String mImage;
	@SerializedName("isbn") private String mISBN;


	public Book(long id, String title, String subTitle, String description, String image, String ISBN) {
		mId = id;
		mTitle = title;
		mSubTitle = subTitle;
		mDescription = description;
		mImage = image;
		mISBN = ISBN;
	}


	public long getId() {
		return mId;
	}

	public String getTitle() {
		return mTitle;
	}

	public String getSubTitle() {
		return mSubTitle;
	}

	public String getDescription() {
		return mDescription;
	}

	public String getImage() {
		return mImage;
	}

	public String getISBN() {
		return mISBN;
	}
}
