package com.hellodg.socity;


import com.hellodg.data.SoftwareDeveloperGroup;

import dagger.Component;

@Component(modules = SoftwareDeveloperGroupModule.class)
public interface SoftwareDeveloperGroupComponent {
	SoftwareDeveloperGroup buildSoftwareDeveloperGroup();
}
