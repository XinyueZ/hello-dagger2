package com.hellodg.society;


import com.hellodg.data.society.SoftwareDeveloperGroup;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SoftwareDeveloperGroupModule.class)
public interface SoftwareDeveloperGroupComponent {
	SoftwareDeveloperGroup buildSoftwareDeveloperGroup();
}
