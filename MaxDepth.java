
class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int x){
        this.val = x;
    }
}

/*

    트리 노드에 대해서 머리 속에 그림이 그려진다.
    maxDepth에서 재귀함수를 사용했다. 

    완전한 이진트리라서 max값을 사용한 것이다.


*/

public class MaxDepth{
    public static void main(String[] args){
        MaxDepth a = new MaxDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        root.left.right.right.right.left = new TreeNode(8);
        root.left.right.right.right.left.right = new TreeNode(9);
        root.left.right.right.right.left.left = new TreeNode(10);
        System.out.println(a.solve(root));
    }

    int max = 0;

    public int solve(TreeNode root){
        System.out.println(maxDepth(root)); 

        int a = maxDepth(root);
        return a;
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(left + right, max);
        System.out.printf("left: %d ", left);
        System.out.printf("right: %d ", right);

        System.out.println("--------------------------");

        return Math.max(left, right) + 1;
    }
}