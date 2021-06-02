import java.util.ArrayDeque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayDeque<Person> personMyArrayDeque = new MyArrayDeque<>();
        personMyArrayDeque.addFirst(new Person(15, "zhangsan"));
        personMyArrayDeque.addFirst(new Person(16, "lisi"));
        personMyArrayDeque.addLast(new Person(17, "wangwu"));
        personMyArrayDeque.addFirst(new Person(15, "zhangsan1"));
        personMyArrayDeque.addFirst(new Person(16, "lisi1"));
        personMyArrayDeque.addLast(new Person(17, "wangwu1"));
        personMyArrayDeque.addFirst(new Person(15, "zhangsan2"));
        personMyArrayDeque.addFirst(new Person(16, "lisi2"));
        personMyArrayDeque.addLast(new Person(17, "wangwu2"));
        personMyArrayDeque.addFirst(new Man(25, "子类人1"));
        personMyArrayDeque.addFirst(new Man(25, "子类人2"));
        System.out.println(personMyArrayDeque);
        System.out.println("=======================");
        System.out.println("getLargest: " + personMyArrayDeque.getLargest());
        System.out.println("=======================");
        System.out.println("getMiddleOne: " + personMyArrayDeque.getMiddleOne());
        System.out.println("=======================");
        System.out.println("getSmallest:" + personMyArrayDeque.getSmallest());
        System.out.println("=======================");
        System.out.println("get(0):" + personMyArrayDeque.get(0));
        System.out.println("=======================");
        personMyArrayDeque.deleteFirst();
        System.out.println("after deleteFirst" + personMyArrayDeque);
        System.out.println("=======================");
        personMyArrayDeque.deleteLast();
        System.out.println("after deleteLast: " + personMyArrayDeque);
        System.out.println("=======================");
        personMyArrayDeque.update(0, new Person(1, "修改人"));
        System.out.println(personMyArrayDeque);
        System.out.println("=======================");
        print(personMyArrayDeque);
    }

    static void print(MyArrayDeque<? extends Person> deque) {
        for (Object p : deque.elements) {
            if (p != null)
                System.out.print(p + "  ");
        }
    }
}
