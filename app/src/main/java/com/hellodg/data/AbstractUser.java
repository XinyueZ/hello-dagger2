package com.hellodg.data;

public abstract class AbstractUser {
	private final String mId;
	private final String mName;
	private final int mAge;

	protected AbstractUser(String id, String name, int age) {
		mId = id;
		mName = name;
		mAge = age;
	}

	public String getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public int getAge() {
		return mAge;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("ID:")
		                          .append(getId())
		                          .append(", NAME:")
		                          .append(getName())
		                          .append(", AGE:")
		                          .append(getAge())
		                          .toString();
	}
}
