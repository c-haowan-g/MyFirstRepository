package com.test;

public class Test {
	
	public static void main(String[] args) {
		
		User user = new User();
		String code = user.getRightMachineCode();
		System.out.println(code);
		
		if (User.isEqualsExceptNullOrEmpty(code, user.getLeftMachineCode())) {
			System.out.println("===");
		} else {
			System.out.println("---");
		}
		
		if (User.isEqualsExceptNullOrEmpty(user.getOfflinerunflagString(), "1")) {
			System.out.println("µ¥»ú");
		} else {
			System.out.println("Ë«»ú");
		}
		
	}
	
}
