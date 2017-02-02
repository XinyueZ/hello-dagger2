package com.hellodg.itbooks;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ServiceModule.class, dependencies = RetrofitComponent.class)
public interface ServiceComponent {
	void injectItBooksObservable(ItBookListActivity activity);
	void injectItBooks(ItBooksListAdapter adapter);
}
