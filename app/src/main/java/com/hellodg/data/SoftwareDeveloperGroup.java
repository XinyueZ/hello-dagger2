package com.hellodg.data;

public final class SoftwareDeveloperGroup {
	private Boss mBoss;
	private SuperUser mSuperUser;
	private InternalUser mInternalUser;
	private ExternalUser mExternalUser;

	public SoftwareDeveloperGroup(Boss boss, SuperUser superUser, InternalUser internalUser, ExternalUser externalUser) {
		mBoss = boss;
		mSuperUser = superUser;
		mInternalUser = internalUser;
		mExternalUser = externalUser;
	}

	public SuperUser getSuperUser() {
		return mSuperUser;
	}

	public InternalUser getInternalUser() {
		return mInternalUser;
	}

	public ExternalUser getExternalUser() {
		return mExternalUser;
	}

	public Boss getBoss() {
		return mBoss;
	}

	@Override
	public String toString() {
		return "This is the SoftwareDeveloperGroup of this example." + "\n\n";
	}
}
