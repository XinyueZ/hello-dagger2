package com.hellodg.society;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = CompanyModule.class)
public interface CompanyComponent {
	void buildCompany(MainActivity activity);
}
