package com.gl.gradedassessment.q1.controller;

import java.util.Scanner;

import com.gl.gradedassessment.q1.assembly.AssemblyOfFloors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		Integer totalFloors = 0;

		System.out.println("Enter the total number of floors in the building:");
		while (flag) {
			try {
				totalFloors = sc.nextInt();
				flag = false;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Enter an Integer:");
				sc.next();
				continue;
			}
			if (totalFloors < 1) {
				System.out.println("Entered integer should be greater than 0:");
				flag = true;
			}
		}

		AssemblyOfFloors floor = new AssemblyOfFloors(totalFloors);

		Integer[] sizeOfFloors = new Integer[totalFloors];

		for (int i = 0; i < totalFloors; i++) {

			try {
				System.out.println("Enter the floor size given on day: " + (i + 1));
				sizeOfFloors[i] = Integer.valueOf(sc.nextInt());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				i--;
				System.out.println("Enter an Integer.");
				sc.next();
				continue;
			}

			int count = 0;
			for (int j = 0; j < i; j++) {
				if (sizeOfFloors[i] == sizeOfFloors[j]) {
					count++;
					break;
				}
			}

			if (count > 0) {
				System.out.println("Enter a distinct Integer.");
				i--;
				continue;
			}

			if (sizeOfFloors[i] < 1) {
				System.out.println("Enter an integer greater than 0.");
				i--;
				continue;
			}

			if (sizeOfFloors[i] > totalFloors) {
				System.out.println("Enter an integer less than " + (totalFloors + 1));
				i--;
				continue;
			}
		}

		sc.close();

		System.out.println("The order of construction is as follows:");
		for (int i = 0; i < totalFloors; i++) {
			System.out.println("Day: " + (i + 1));
			floor.floorConstruction(sizeOfFloors[i]);
			System.out.println();
		}

	}

}
