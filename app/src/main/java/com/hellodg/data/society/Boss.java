package com.hellodg.data.society;

import javax.inject.Inject;

public final class Boss extends AbstractUser {
	@Inject
	public Boss() {
		super("0", "Mr. Boss", 30);
	}


	@Override
	public String toString() {
		return "This is BOSS: " + super.toString() + "\n\n";
	}
}
