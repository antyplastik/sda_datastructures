package list;

public class Runner {
    public static void main(String[] args) {
        SdaListImpl list = new SdaListImpl();

//        list.addFirst(60);
        list.addLast(10);
        list.getLast();
        list.addLast(20);
        list.getLast();
        list.addLast(30);
        list.getLast();
        list.addLast(40);
        list.getLast();
        list.addLast(50);
        list.getLast();

        System.out.println("Czy lista jest pusta? " + list.isEmpty());
        list.size();
        list.get(2);
        list.getFirst();
        list.getLast();
        System.out.println("Aktualna wartosc head: " + list.head.value);
        list.removeLast();
//        System.out.println("Aktualna wartosc head: " + list.head.value);
        list.getLast();
//        list.clear();
        list.addAt(1,100);
        System.out.println("Czy lista jest pusta? " + list.isEmpty());
        list.printListElements();
        System.out.println("");
        list.addAt(0,100);
        list.printListElements();
        list.size();
        System.out.println("");
        list.removeAt(3);
        list.removeAt(0);
        list.printListElements();
        System.out.println("");
        list.setAt(1,200);
        list.printListElements();
        list.size();

    }
}
