package com.hellodg.data;

public final class InternalUser extends AbstractUser {

	public InternalUser(String id, String name, int age) {
		super(id, name, age);
	}


	@Override
	public String toString() {
		return "This is INTERNAL-USER: " + super.toString() + "\n\n";
	}
}
