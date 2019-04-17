package class05;

public class TestBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
	}

	public static boolean isBST(Node head) {
		return process(head).isBST;//
	}

	public static class ReturnType {
		public boolean isBST;
		public int max;
		public int min;

		public ReturnType(boolean isBST, int max, int min) {
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);
		int max = Math.max(x.value, Math.max(leftData.max, rightData.max));
		int min = Math.min(x.value, Math.min(leftData.min, rightData.min));
		boolean isBST = leftData.isBST 
				& rightData.isBST 
				& leftData.max < x.value 
				& rightData.min > x.value;
		return new ReturnType(isBST, max, min);

	}
	
	
	
	public static boolean isBalanced(Node head) {
		return walk(head).isBalanced;// 
	}
	
	public static class ReturnInfo{
		
		public boolean isBalanced;
		public int height;
		
		public ReturnInfo(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	public static ReturnInfo walk(Node x) {
		if(x == null) {
			return new ReturnInfo(true, 0);
		}
		ReturnInfo leftData = walk(x.left);
		ReturnInfo rightData = walk(x.right);
		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced 
				&& Math.abs(leftData.height - rightData.height) < 2;
		return new ReturnInfo(isBalanced, height);
		
	}
	
	
	public static class ReturnDetail{
		public int height;
		public int nodes;
		public ReturnDetail(int h, int n) {
			height = h;
			nodes = n;
		}
	}
	
	public static ReturnDetail f(Node x) {
		if(x == null) {
			return new ReturnDetail(0,0);
		}
		ReturnDetail lDetail = f(x.left);
		ReturnDetail rDetail = f(x.right);
		int height = Math.max(lDetail.height, rDetail.height);
		int nodes = lDetail.nodes + 1 + rDetail.nodes;
		return new ReturnDetail(height, nodes);
	}
	
	public static boolean isFull(Node head) {
		ReturnDetail allDetail =  f(head);
		int height = allDetail.height;
		int allNodes = allDetail.nodes;
		return (1 << height) - 1 == allNodes;
	}
	
	
	
	
	
	
	
	

}
