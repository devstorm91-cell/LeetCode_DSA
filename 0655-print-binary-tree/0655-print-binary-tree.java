class Solution {

    public List<List<String>> printTree(TreeNode root) {

        int height = getHeight(root);

        int rows = height;
        int cols = (1 << height) - 1;

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            List<String> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add("");
            }

            result.add(row);
        }

        fill(result, root, 0, 0, cols - 1);

        return result;
    }

    private int getHeight(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(
            getHeight(root.left),
            getHeight(root.right)
        );
    }

    private void fill(
        List<List<String>> result,
        TreeNode root,
        int row,
        int left,
        int right
    ) {

        if (root == null)
            return;

        int mid = (left + right) / 2;

        result.get(row).set(mid, String.valueOf(root.val));

        fill(result, root.left, row + 1, left, mid - 1);

        fill(result, root.right, row + 1, mid + 1, right);
    }
}