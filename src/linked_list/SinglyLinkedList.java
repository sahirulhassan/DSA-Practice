package linked_list;

public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insert(int pos, int element) {
        if (pos < 1) {
            return;
        }
        Node newNode = new Node(element);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = head;
            int currentPos = 1;
            while (currentNode.next != null) {
                if (currentPos == pos) {
                    break;
                }
                currentPos++;
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insert(1, 10);
        linkedList.insert(2,20);
        linkedList.insert(3, 30);
        linkedList.insert(1, 5);
    }
}
