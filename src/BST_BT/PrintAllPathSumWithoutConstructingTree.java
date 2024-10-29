package src.BST_BT;


public class PrintAllPathSumWithoutConstructingTree {


    public static void main(String[] args) {
        // print all sums without constructing tree
         int[] tree = new int[]{2,3,4,5,6,9,5,8};
         printAllPathSumArr(tree);
    }

    private static void printAllPathSumArr(int[] tree) {
        printUtil(tree, 0, 0);
    }

    private static void printUtil(int[] tree, int curIdx, int curSum) {
        if (curIdx >=tree.length) {
            return;
        }
        int curVal = curSum + tree[curIdx];

        int leftChild = 2 * curIdx + 1;
        int rightChild = 2 * curIdx + 2;
        if (leftChild >= tree.length) {
            System.out.println(curVal);
            return;
        }
        if (rightChild < tree.length) {
            printUtil(tree, rightChild,  curVal);
        }
        printUtil(tree, leftChild, curVal);

    }
}
