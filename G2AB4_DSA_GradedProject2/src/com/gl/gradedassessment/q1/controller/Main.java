package com.gl.gradedassessment.q1.controller;

import java.util.Scanner;

import com.gl.gradedassessment.q1.assembly.AssemblyOfFloors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building:");
		Integer totalFloors = sc.nextInt();
		if (totalFloors < 1) {
			System.out.println("Invalid Input");
			System.exit(0);
		}

		AssemblyOfFloors floor = new AssemblyOfFloors(totalFloors);

		Integer[] sizeOfFloors = new Integer[totalFloors];

		for (int i = 0; i < totalFloors; i++) {

			System.out.println("Enter the floor size given on day: " + (i + 1));
			sizeOfFloors[i] = Integer.valueOf(sc.nextInt());

			int count = 0;
			for (int j = 0; j < i; j++) {
				if (sizeOfFloors[i] == sizeOfFloors[j]) {
					count++;
					System.out.println(count);
					break;
				}
			}

			if (sizeOfFloors[i] < 1 || sizeOfFloors[i] > totalFloors || count != 0) {
				System.out.println("Invalid Input");
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
