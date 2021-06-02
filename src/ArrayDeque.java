public interface ArrayDeque<E> {
    void addFirst(E e);
    void addLast(E e);
    void deleteFirst();
    void deleteLast();
    E get(int index);
    void update(int index,E e);
    E getLargest();
    E getSmallest();
    E getMiddleOne();
    void doubleCapacity();
}
