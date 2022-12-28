public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(112);
        list.add(15);
        list.add(45);
        list.add(67);
        list.add(82);
        list.add(34);
        list.add(12);
        list.add(90);
        list.add(5);

        list.forEach(System.out::println);

        System.out.println();
        System.out.println(String.format("Size: %d", list.size()));
        System.out.println();
        System.out.println(list.getPreviousByIndex(5));
        System.out.println(list.getByIndex(5));
        System.out.println(list.getNextByIndex(5));
        list.replaceByIndex(5, 100500);
        System.out.println(list.getByIndex(5));
    }
}