package linked_list.singly;

public class SinglyLinkedList {
    private SinglyLinkedNode head;

    public SinglyLinkedList() {
        head = null;
    }

    public SinglyLinkedNode getHead() {
        return head;
    }

    public void setHead(SinglyLinkedNode head) {
        this.head = head;
    }

    public void append(int data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            SinglyLinkedNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void prepend(int data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insert(int pos, int data) {
        if (pos < 0) {
            throw new IllegalArgumentException("Enter a valid position to insert a value.");
        } else if (pos == 0) {
            prepend(data);
        } else {
            SinglyLinkedNode newNode = new SinglyLinkedNode(data);
            SinglyLinkedNode current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }

            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds.");
            }


            newNode.setNext(current.getNext());
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
            SinglyLinkedNode current = head;
            while (current.getNext() != null && current.getNext().getData() != target) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                throw new IllegalArgumentException("Value not found.");
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        head = head.getNext();
    }

    public void deleteTail() {
        SinglyLinkedNode current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void delete(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("Enter a valid position to delete a value.");
        } else if (pos == 0) {
            deleteHead();
        } else {
            SinglyLinkedNode current = head;
            for (int i = 0; i < pos-1; i++) {
                current = current.getNext();
            }
            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds.");
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        SinglyLinkedNode current = head;
        while (current != null) {
            temp.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return temp.toString();
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println(list);
        list.prepend(0);
        System.out.println(list);
        list.insert(0,0);
        System.out.println(list);
        list.deleteTail();
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
        list.deleteByValue(1);
        System.out.println(list);
    }
}
