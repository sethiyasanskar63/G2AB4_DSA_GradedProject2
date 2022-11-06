package com.gl.gradedassessment.q2.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.gl.gradedassessment.q2.datastructure.BinarySearchTree;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();

		try {
			while (true) {
				System.out.println("Enter the numbers to insert, enter any letter to exit");
				int num = sc.nextInt();
				bst.insert(num);
			}
		} catch (InputMismatchException ex) {
			sc.close();
			System.out.println("Preorder traversal of Binary Search Tree:");
			bst.preOrder();
		}

		bst.bstToRst(bst.root);
		System.out.println();
		System.out.println("Preorder traversal of Right Skewed Tree:");
		bst.perOrderSkewed();
	}
}
