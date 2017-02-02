package com.hellodg.socity;


import com.hellodg.data.SoftwareDeveloperGroup;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SoftwareDeveloperGroupModule.class)
public interface SoftwareDeveloperGroupComponent {
	SoftwareDeveloperGroup buildSoftwareDeveloperGroup();
}
