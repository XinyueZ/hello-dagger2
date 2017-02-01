package com.hellodg.data;


public final class Company {
	private Boss mBoss;
	private SuperUser mSuperUser;

	public Company(Boss boss, SuperUser superUser) {
		mBoss = boss;
		mSuperUser = superUser;
	}

	public Boss getBoss() {
		return mBoss;
	}

	public SuperUser getSuperUser() {
		return mSuperUser;
	}

	@Override
	public String toString() {
		return "This is the Company of this example." + "\n\n";
	}
}
