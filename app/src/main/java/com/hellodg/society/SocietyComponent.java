package com.hellodg.society;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = SocietyModule.class)
public interface SocietyComponent {
	void createSociety(SocietyActivity activity);
}
