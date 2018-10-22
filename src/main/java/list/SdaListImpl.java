package list;

public class SdaListImpl implements SdaList {

    Node head;

    public SdaListImpl() {
        head = null;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public int size() {
        int size = 1;
        Node current = head;
//        tmp.next = head.next;

        if (current == null)
            return 0;
        while (current.next != null) {
            if (current.next != null) {
//                System.out.println(size + " head value: " + tmp.value + " next object value: " + tmp.next.value);
                size++;
            } else {
                break;
            }
            current = current.next;
        }
        System.out.println("Liczba elementow w liscie: " + size);
        return size;
    }

    public int getFirst() {
        System.out.println("Wartosc pierwszego elementu: " + head.value);
        return head.value;
    }

    public int getLast() {
        Node current = head;
        while (current != null) {

            if (current.next == null) {
                System.out.println("Wartosc ostatniego elementu: " + current.value);
                return current.value;
            } else {
                current = current.next;
            }
        }
        return 0;
    }

    public int get(int index) {
        Node tmp = new Node();

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                System.out.println("Element o indeksie " + index + " ma wartosc: " + tmp.value);
                return tmp.value;
            } else {
                tmp = head.next;
            }
        }

        return 0;
    }

    public void clear() {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = head.next;
            head = null;
            if (tmp.next == null) {
                tmp.value = 0;
                tmp = null;
                System.out.println("Lista wyczyszczona");
                break;
            } else
                head = tmp;

        }
    }

    public void addFirst(int element) {
//        System.out.println("Jestem w addFirst");
//        Node tmp = new Node();                              // tworzy tymczasowy obiekt ktory dostanie wartosc element ale jego wskaznik na nic nie wskazuje
//        tmp.value = element;
//        System.out.println("tmp.value = " + element);
//        tmp = head;                                    // wskaznik obiektu tmp teraz dostaje wartosc z head
//        head = tmp;                                         // head wskazuje teraz na kolejny element

        Node newNode = new Node();
        newNode.value = element;

        Node previous;

        if (head == null)
            head = newNode;
        else {
            previous = head;
            newNode.next = previous;
            head = newNode;
        }
    }


    public void addLast(int element) {                          // POPRAWIC
//        System.out.println("jest w addLast");
        if (head == null) {
            addFirst(element);
        } else {
            Node current = head;

            Node newNode = new Node();                          // brzydki nawyk
            newNode.value = element;
//            System.out.println("dodaje kolejny");

            do {
//                System.out.println("\tcurrent: " + current.value);
                if (current.next == null) {
                    current.next = newNode;
                    break;
                } else
                    current = current.next;
            } while (true);
        }
    }

    public void removeFirst() {
        if (head.next == null)           // ten warunek obsluzy wszystkie inne warunki zalezne od ilosci elementow w liscie
            return;
        head = head.next;               // trzeba zmienic wskaznik head na drugi element. Po tym w liscie bedzei nieuzywany element ktory zostanie zniszczony przez GC
    }

    public void removeLast() {          //
        Node current = head;
        Node tmp;
        if (current != null) {
            while (current.next != null) {
                tmp = current.next;

                if (tmp.next == null) {
                    System.out.println("Wartosc ostatniego kasowanego elementu: " + current.next.value);
                    current.next = null;
                } else
                    current = tmp;
            }
        }
    }


    public void setAt(int index, int element) {     // zmien wartosc elemetu o wskazanym indeksie
        Node current = head;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                current.value = element;
            } else
                current = current.next;
        }

    }

    public void addAt(int index, int element) {     // dodaj pomiedzy node'ami
        Node previous = head;
        Node next;

        Node nodeToAdd = new Node();
        nodeToAdd.value = element;

        int i = 0;

        while (i < (index + 1)) {
            if (index == 0 || previous == null) {
                addFirst(element);
                break;

            } else if (previous.next == null) {
                addLast(element);                   // nieoptymalne jezel byloby w tablicy duzo elementow <= przypadek skrajny
                break;
            }


            if (i == index) {
                next = previous.next;
                previous.next = nodeToAdd;
                nodeToAdd.next = next;
                break;
            } else {
                previous = previous.next;
                i++;
            }
        }
    }

    public void removeAt(int index) {               // usun konkretny wezel
        Node previous = head;
        Node next;
        int i = 0;

        while (true) {
            if (i == 0 && index == 0) {
                removeFirst();
                break;
            }
            if (i == index - 1 && index > 0) {
                next = previous.next;
                previous.next = next.next;
                break;
            } else {
                previous = previous.next;
                i++;
            }
        }

    }

    public void printListElements() {
        Node printTmp = head;
        int i = 0;
        while (printTmp != null) {
            System.out.println(i + " node has value:" + printTmp.value);
            printTmp = printTmp.next;
            i++;
        }

    }

    class Node {
        int value;
        Node next;
    }

}
