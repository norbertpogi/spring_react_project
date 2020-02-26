package io.agileeclipse.project.projectboard;

import java.util.Scanner;

public class Task {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String username = "ADMIN";
		String password = "admin";
		
		try {
			System.out.println("enter username");
			String input = scan.nextLine();
			System.out.println("enter password");
			String input2 = scan.nextLine();
			
			if(input.equals(username) && input2.equals(password)) {
				System.out.println("welcome");
			} else if (!input.equals(username)) {
				System.out.println("invalid username");
			} else if (!input2.equals(password)) {
				System.out.println("invalid password");
			} else {
				System.out.println("invalid username or password");
			}
			
			
		} catch (Exception e){
			System.out.println("invalid input");
		}
		
		
	}

}
