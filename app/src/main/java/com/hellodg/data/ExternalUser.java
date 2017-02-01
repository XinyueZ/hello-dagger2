package com.hellodg.data;

public final class ExternalUser extends AbstractUser {

	public ExternalUser(String id, String name, int age) {
		super(id, name, age);
	}


	@Override
	public String toString() {
		return "This is EXTERNAL-USER: " + super.toString()+ "\n\n";
	}
}
