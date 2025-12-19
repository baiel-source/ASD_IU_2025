import java.util.Scanner;

public class IterativeDeepeningSearch {
    public static boolean findWithIterativeDeepening(Tree.TreeNode root, int targetValue) {
        if (root == null) {
            return false;
        }

        int currentDepth = 0;
        final int MAX_DEPTH = 100; // Защита от бесконечного цикла

        while (currentDepth <= MAX_DEPTH) {
            System.out.println("\nПоиск на глубине: " + currentDepth);

            boolean found = depthLimitedSearch(root, targetValue, currentDepth);

            if (found) {
                System.out.println("Элемент " + targetValue + " найден на глубине " + currentDepth);
                return true;
            }
            currentDepth++;
        }

        System.out.println("Элемент " + targetValue + " не найден в пределах максимальной глубины " + MAX_DEPTH);
        return false;
    }

    private static boolean depthLimitedSearch(Tree.TreeNode currentNode, int targetValue, int remainingDepth) {
        if (currentNode == null) {
            return false;
        }

        System.out.println("  Проверка узла: " + currentNode.value);

        if (currentNode.value == targetValue) {
            return true;
        }

        if (remainingDepth == 0) {
            return false;
        }

        boolean foundInLeft = depthLimitedSearch(currentNode.leftChild, targetValue, remainingDepth - 1);
        boolean foundInRight = depthLimitedSearch(currentNode.rightChild, targetValue, remainingDepth - 1);

        return foundInLeft || foundInRight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Построение дерева из пользовательского ввода
        Tree tree = TreeHelper.buildTreeFromUserInput(scanner);

        // Отображение структуры дерева
        TreeHelper.displayTreeStructure(tree.getRoot());

        // Запрос целевого значения для поиска
        int target = TreeHelper.getSearchValue(scanner);

        // Выполнение поиска
        boolean found = findWithIterativeDeepening(tree.getRoot(), target);

        if (!found) {
            System.out.println("Элемент не найден");
        }

        scanner.close();
    }
}