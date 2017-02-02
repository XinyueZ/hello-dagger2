package com.hellodg.data.society;

import javax.inject.Inject;

/**
 * Created by xzhao on 02.02.17.
 */

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
