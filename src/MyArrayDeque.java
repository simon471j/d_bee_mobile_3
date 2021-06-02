import java.util.Arrays;

public class MyArrayDeque<E> implements ArrayDeque<E> {
    final int INITIAL_CAPACITY = 8;
    int elementsCnt = 0;
    Object[] elements;
    //添加元素之后head始终指向第一个元素
    int head = 0;
    //    添加元素之后tail始终指向最后一个元素的下一个位置
    int tail = 0;
    private Object[] objects;

    public MyArrayDeque() {
        elements = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addFirst(E e) {
        //如果加入的元素为空则抛出异常
        if (e == null)
            throw new NullPointerException("没有元素");
        //如果head为0则回到数组尾部 避免IndexOutOfBounds
        if (head == 0) {
            elements[head = (elements.length - 1)] = e;
        } else
            elements[--head] = e;
        elementsCnt++;

        //      如果head和tail相遇 则扩大容积
        if (head == tail)
            doubleCapacity();
    }

    @Override
    public void addLast(E e) {
        //如果加入的元素为空则抛出异常
        if (e == null)
            throw new NullPointerException("没有元素");
        elements[tail] = e;
        if (tail == elements.length - 1) {
            tail = 0;
        } else
            tail++;
        elementsCnt++;
        //      如果head和tail相遇 则扩大容积
        if (head == tail)
            doubleCapacity();
    }

    @Override
    public void deleteFirst() {
//        如果集合里面没有元素那么直接不操作
        if (elementsCnt == 0)
            return;
        elements[head] = null;

        if (head != elements.length - 1)
            head++;
        else {
            head = 0;
        }
        elementsCnt--;

    }

    @Override
    public void deleteLast() {
//        如果集合里面没有元素那么直接不操作
        if (elementsCnt == 0)
            return;
        if (tail != 0)
            tail--;
        else
            tail = elements.length - 1;
        elements[tail] = null;
        elementsCnt--;
    }

    @Override
    public E get(int index) {
        if (index > elementsCnt)
            throw new IndexOutOfBoundsException("超出范围！");
        if (head + index >= elements.length) {
            return (E) elements[elements.length - head];
        } else
            return (E) elements[head + index];
    }

    @Override
    public void update(int index, E e) {
        if (head + index < elements.length) {
            elements[head + index] = e;
        } else
            elements[index - (elements.length - head)] = e;
    }

    @Override
    public E getLargest() {
        objects = new Object[elementsCnt];
        newArray();
        Arrays.sort(objects);
        return (E) objects[0];
    }

    @Override
    public E getSmallest() {
        objects = new Object[elementsCnt];
        newArray();
        Arrays.sort(objects);
        return (E) objects[elementsCnt - 1];
    }

    @Override
    public E getMiddleOne() {
        if ((elementsCnt & 1) == 1) {
            objects = new Object[elementsCnt];
            newArray();
            Arrays.sort(objects);
            return (E) objects[elementsCnt / 2];
        }
        try {
            throw new Exception("数据大小为偶数 取不到中间值");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doubleCapacity() {
        objects = new Object[2 * elementsCnt];
        newArray();
        elements = objects;
        head = 0;
        tail = elementsCnt;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        objects = new Object[elementsCnt];
        newArray();
        stringBuffer.append("[");
        for (Object element : objects) {
            if (element != null)
                stringBuffer.append(" " + element + " ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    void newArray() {
        if (head >= tail) {
            System.arraycopy(elements, head, objects, 0, elements.length - head);
            System.arraycopy(elements, 0, objects, elements.length - head, tail);
        } else
            System.arraycopy(elements, head, objects, 0, elementsCnt);
    }

    ;
}
