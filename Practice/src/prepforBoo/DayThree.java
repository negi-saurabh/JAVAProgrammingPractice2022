package prepforBoo;


public class DayThree {

    public static void main(String[] args) {

//        int first = firstUniqChar("loveleetcode");
//        List<List<String>> anagrams = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        int dfs(TreeNode node) {
            if (node == null) return 0;
            int l = dfs(node.left), r = dfs(node.right);
            return 1;
        }

        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

    }
}