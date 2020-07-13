import java.util.Stack;


/*

    찬우씨 말대로  stack 2개를 사용했다.
    재귀 함수를 쓰지 않고 while문 안에 stack에 push를 하게해서 while 종료 조건이 충족되지 않도록 했다.
    
    node.left가 갖고있는 데이터가 stack에 고대로 들어가는 듯
    이걸 stack.pop을 하고 또하고 해서 결과나오는 듯.
    이진트리라서 같은 동선에 count +1이 있어도 되는 듯하다.

*/



public class DiameterOfBinaryTree_DFS {

	public static void main(String[] args) {
		DiameterOfBinaryTree_DFS a = new DiameterOfBinaryTree_DFS();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		

		System.out.println("val: "+ a.dfs(node));
	}
	
	public int dfs(TreeNode root) {
		if(root ==null) return 0;
		
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max=0;
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println("node: "+ node.val);
			int count = value.pop();
			max = Math.max(max, count);
			if(node.left !=null) {
				stack.push(node.left);
				value.push(count+1);
			}
			if(node.right !=null) {
				stack.push(node.right);
				value.push(count+1);
			}
		}
		return max;
	}
}

