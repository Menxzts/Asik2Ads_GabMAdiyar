import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        Mystack<Integer> stack = new Mystack<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        while (true) {
            System.out.println("\nChoose a data structure:");
            System.out.println("1 - Stack");
            System.out.println("2 - Queue");
            System.out.println("3 - MinHeap");
            System.out.println("4 - ArrayList");
            System.out.println("5 - LinkedList");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> stackMenu(scanner, stack);
                case 2 -> queueMenu(scanner, queue);
                case 3 -> heapMenu(scanner, heap);
                case 4 -> arrayListMenu(scanner, arrayList);
                case 5 -> linkedListMenu(scanner, linkedList);
                case 0 -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void stackMenu(Scanner scanner, Mystack<Integer> stack) {
        while (true) {
            System.out.println("\nStack Menu:");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Peek");
            System.out.println("4 - Size");
            System.out.println("5 - Clear");
            System.out.println("0 - Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    stack.push(scanner.nextInt());
                }
                case 2 -> System.out.println("Popped: " + stack.pop());
                case 3 -> System.out.println("Top element: " + stack.peek());
                case 4 -> System.out.println("Size: " + stack.size());
                case 5 -> {
                    stack.clear();
                    System.out.println("Stack cleared.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void queueMenu(Scanner scanner, MyQueue<Integer> queue) {
        while (true) {
            System.out.println("\nQueue Menu:");
            System.out.println("1 - Enqueue");
            System.out.println("2 - Dequeue");
            System.out.println("3 - Peek");
            System.out.println("4 - Size");
            System.out.println("5 - Clear");
            System.out.println("0 - Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    queue.enqueue(scanner.nextInt());
                }
                case 2 -> System.out.println("Dequeued: " + queue.dequeue());
                case 3 -> System.out.println("Front element: " + queue.peek());
                case 4 -> System.out.println("Size: " + queue.size());
                case 5 -> {
                    queue.clear();
                    System.out.println("Queue cleared.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void heapMenu(Scanner scanner, MyMinHeap<Integer> heap) {
        while (true) {
            System.out.println("\nMinHeap Menu:");
            System.out.println("1 - Insert");
            System.out.println("2 - Extract Min");
            System.out.println("3 - Get Min");
            System.out.println("4 - Size");
            System.out.println("0 - Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    heap.insert(scanner.nextInt());
                }
                case 2 -> System.out.println("Extracted min: " + heap.extractMin());
                case 3 -> System.out.println("Current min: " + heap.getMin());
                case 4 -> System.out.println("Size: " + heap.size());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void arrayListMenu(Scanner scanner, MyArrayList<Integer> list) {
        while (true) {
            System.out.println("\nArrayList Menu:");
            System.out.println("1 - Add");
            System.out.println("2 - Add at index");
            System.out.println("3 - Add First");
            System.out.println("4 - Add Last");
            System.out.println("5 - Get");
            System.out.println("6 - Remove");
            System.out.println("7 - Remove First");
            System.out.println("8 - Remove Last");
            System.out.println("9 - Sort");
            System.out.println("10 - Clear");
            System.out.println("0 - Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    list.add(scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter element: ");
                    list.add(index, scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter element: ");
                    list.addFirst(scanner.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter element: ");
                    list.addLast(scanner.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter index: ");
                    System.out.println("Element: " + list.get(scanner.nextInt()));
                }
                case 6 -> {
                    System.out.print("Enter index: ");
                    list.remove(scanner.nextInt());
                }
                case 7 -> list.removeFirst();
                case 8 -> list.removeLast();
                case 9 -> {
                    list.sort();
                    System.out.println("List sorted.");
                }
                case 10 -> {
                    list.clear();
                    System.out.println("List cleared.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void linkedListMenu(Scanner scanner, MyLinkedList<Integer> list) {
        while (true) {
            System.out.println("\nLinkedList Menu:");
            System.out.println("1 - Add");
            System.out.println("2 - Add at index");
            System.out.println("3 - Add First");
            System.out.println("4 - Add Last");
            System.out.println("5 - Get");
            System.out.println("6 - Remove");
            System.out.println("7 - Remove First");
            System.out.println("8 - Remove Last");
            System.out.println("9 - Sort");
            System.out.println("10 - Clear");
            System.out.println("0 - Back");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element: ");
                    list.add(scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter element: ");
                    list.add(index, scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter element: ");
                    list.addFirst(scanner.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter element: ");
                    list.addLast(scanner.nextInt());
                }
            }
        }
    }
}
