package linked_list;

public class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
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
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void prepend(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void insert(int pos, int data) {
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException("Enter a valid position to insert a value.");
        } else if (pos == size) {
            append(data);
        } else if (pos == 0) {
            prepend(data);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            DoublyLinkedNode current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.setNext(newNode);
            if (newNode.getNext() != null) {
                newNode.getNext().setPrev(newNode);
            }
            size++;
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
            } else {
                tail = current;
            }
            size--;
        }
    }

    public int deleteHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        int popped = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return popped;
    }

    public int deleteTail() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        int popped = tail.getData();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return popped;
    }

    public int delete(int pos) {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Enter a valid position to delete a value.");
        } else if (pos == 0) {
            return deleteHead();
        } else if (pos == size - 1) {
            return deleteTail();
        } else {
            DoublyLinkedNode current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }

            int popped = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(current);
            }
            size--;
            return popped;
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("Enter valid positions to swap values.");
        }
        if (i == j) {
            return;
        }
        DoublyLinkedNode node1 = head;
        DoublyLinkedNode node2 = head;
        for (int k = 0; k < i; k++) {
            node1 = node1.getNext();
        }
        for (int k = 0; k < j; k++) {
            node2 = node2.getNext();
        }
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    public int get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Enter a valid position to get a value.");
        }
        DoublyLinkedNode current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void set(int pos, int data) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Enter a valid position to set a value.");
        }
        DoublyLinkedNode current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        current.setData(data);
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
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
