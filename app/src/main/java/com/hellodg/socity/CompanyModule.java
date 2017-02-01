package com.hellodg.socity;


import com.hellodg.data.Boss;
import com.hellodg.data.Company;
import com.hellodg.data.SuperUser;

import dagger.Module;
import dagger.Provides;

@Module
public final class CompanyModule {
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
	static Company provideCompany(Boss boss, SuperUser superUser) {
		return new Company(boss, superUser);
	}
}
