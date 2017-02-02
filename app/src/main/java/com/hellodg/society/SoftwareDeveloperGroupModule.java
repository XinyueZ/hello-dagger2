package com.hellodg.society;

import com.hellodg.data.society.Boss;
import com.hellodg.data.society.ExternalUser;
import com.hellodg.data.society.InternalUser;
import com.hellodg.data.society.SoftwareDeveloperGroup;
import com.hellodg.data.society.SuperUser;

import dagger.Module;
import dagger.Provides;

@Module
public final class SoftwareDeveloperGroupModule {
	/**
	 * Provide a boss, this method is useless, because the {@link Boss} has a default constructor.
	 *
	 * @return A {@link Boss}
	 */
//	@Provides
//	static Boss provideBoss() {
//		return new Boss();
//	}

	@Provides
	static SuperUser provideSuperUser() {
		return new SuperUser("1", "Only one super", 35);
	}

	@Provides
	static InternalUser provideInternalUser() {
		return new InternalUser("2", "Only one internal", 56);
	}

	@Provides
	static ExternalUser provideExternalUser() {
		return new ExternalUser("3", "Only one external", 67);
	}

	@Provides
	static SoftwareDeveloperGroup provideSoftwareDeveloperGroup(Boss boss, SuperUser superUser, InternalUser internalUser, ExternalUser externalUser) {
		return new SoftwareDeveloperGroup(boss, superUser, internalUser, externalUser);
	}
}
