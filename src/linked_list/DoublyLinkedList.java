package linked_list;

public class DoublyLinkedList {
    private DoublyLinkedNode head;

    public DoublyLinkedList() {
        head = null;
    }

    public DoublyLinkedNode getHead() {
        return head;
    }

    public void setHead(DoublyLinkedNode head) {
        this.head = head;
    }

    public void append(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            DoublyLinkedNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public void prepend(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }

    public void insert(int pos, int data) {
        if (pos < 0) {
            throw new IllegalArgumentException("Enter a valid position to insert a value.");
        } else if (pos == 0) {
            prepend(data);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            DoublyLinkedNode current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }

            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds.");
            }

            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.setNext(newNode);
        }
    }

    public void deleteByValue(int target) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (head.getData() == target) {
            deleteHead();
        } else {
            DoublyLinkedNode current = head;
            while (current.getNext() != null && current.getNext().getData() != target) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                throw new IllegalArgumentException("Value not found.");
            }
            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(current);
            }
        }
    }

    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        head = head.getNext();
        head.setPrev(null);
    }

    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        DoublyLinkedNode current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void delete(int pos) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (pos < 0) {
            throw new IllegalArgumentException("Enter a valid position to delete a value.");
        } else if (pos == 0) {
            deleteHead();
        } else {
            DoublyLinkedNode current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }

            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds.");
            }

            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(current);
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        DoublyLinkedNode current = head;
        while (current != null) {
            temp.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);
        list.insert(2, 10);
        System.out.println(list);
    }
}
