package class05;

import java.util.LinkedList;

public class Code05_IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isCBT(Node head) { // 完全二叉树
		if (head == null) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		boolean leaf = false; // 判断叶节点的阶段是否开始了
		Node l = null;
		Node r = null;
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.add(l);
			}
			if (r != null) {
				queue.add(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

}
