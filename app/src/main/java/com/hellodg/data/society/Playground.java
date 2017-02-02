package com.hellodg.data.society;

import javax.inject.Inject;


public final class Playground {
	private String mPemo;

	@Inject
	public Playground() {
		mPemo = "Playground is playground, it is simple";
	}

	@Override
	public String toString() {
		return mPemo +   "\n\n";
	}
}
