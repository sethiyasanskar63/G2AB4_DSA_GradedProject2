package com.gl.gradedassessment.q2.datastructure;

class Node {

	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {

	public Node root, prev = null, next = null;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertNode(root, key);
	}

	Node insertNode(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data)
			root.left = insertNode(root.left, data);
		else if (data > root.data)
			root.right = insertNode(root.right, data);

		return root;
	}

	public void preOrder() {
		preOrderTraversal(this.root);
	}

	public void perOrderSkewed() {
		preOrderTraversal(next);
	}

	void preOrderTraversal(Node node) {

		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		// System.out.print(node.data + " ");
		preOrderTraversal(node.right);
	}

	public void bstToRst(Node node) {

		if (node == null) {
			return;
		}

		bstToRst(node.left);

		Node rightNode = node.right;

		if (next == null) {
			next = node;
			node.left = null;
			prev = node;
		} else {
			prev.right = node;
			node.left = null;
			prev = node;
		}

		bstToRst(rightNode);
	}

}
