package list;

public class SdaListImpl implements SdaList {

    Node head;

    public SdaListImpl() {
        head = null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public int getFirst() {
        return 0;
    }

    public int getLast() {
        return 0;
    }

    public int get(int index) {
        return 0;
    }

    public void clear() {

    }

    public void addFirst(int elementValue) {
        System.out.println("Jestem w addFirst");
        Node tmp = new Node();                              // tworzy tymczasowy obiekt ktory dostanie wartosc elementValue ale jego wskaznik na nic nie wskazuje
        tmp.value = elementValue;
        System.out.println("tmp.value = " + elementValue);
        tmp.next = head;                                    // wskaznik obiektu tmp teraz dostaje wartosc z head
        head = tmp;                                         // head wskazuje teraz na kolejny element

    }

    public void addLast(int element) {
        System.out.println("jest w addLast");
        if (head == null) {
            System.out.println("dodaje pierwszy");
            head = new Node();
            head.value = element;
        } else {
            System.out.println("dodaje kolejny");
            Node current = head;
            while (current.next != null) {
                System.out.println("\tcurrent: " + current.value);
                current = current.next;
            }
            Node newNode = new Node();
            newNode.value = element;
            current.next = newNode;
        }
    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void setAt(int index, int element) {

    }

    public void addAt(int index, int element) {

    }

    public void removeAt(int index) {

    }

    class Node {
        int value;
        Node next;
    }

}
