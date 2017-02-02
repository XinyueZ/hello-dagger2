package com.hellodg.data.society;

public final class SuperUser extends AbstractUser {

	public SuperUser(String id, String name, int age) {
		super(id, name, age);
	}


	@Override
	public String toString() {
		return "This is SUPER-USER: " + super.toString() + "\n\n";
	}
}
