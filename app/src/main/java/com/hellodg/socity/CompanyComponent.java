package com.hellodg.socity;


import com.hellodg.MainActivity;

import dagger.Component;

@Component(modules = CompanyModule.class)
public interface CompanyComponent {
	void buildCompany(MainActivity activity);
}
