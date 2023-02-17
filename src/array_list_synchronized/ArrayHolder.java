package array_list_synchronized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Magomed on 07.07.2017.
 */
public class ArrayHolder implements Collection<Integer> {
    private Integer[] integ;
    private int coll = 0;

    public ArrayHolder() {
        integ = new Integer[10];
    }

    public synchronized Integer sumElement() throws InterruptedException {
        if (isEmpty()) return null;
        if (coll == 1) return integ[0];
        int result = 0;
        for (int i = 0; i < coll; i++) {
            Thread.sleep(200);
            result += integ[i];
        }
        result = result/coll;
        return result;
    }

    public synchronized Integer maxElement() throws InterruptedException {
        if (isEmpty()) return null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < coll; i++) {
            Thread.sleep(200);
            Integer integer = integ[i];
            if (integer > max) max = integer;
        }
        return max;
    }

    public synchronized Integer minElement() throws InterruptedException {
        if (isEmpty()) return null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coll; i++) {
            Thread.sleep(200);
            Integer integer = integ[i];
            if (integer < min) min = integer;
        }
        return min;
    }

    public Integer removeElement(int index){
        rangeCheck(index);
        return integ[index];
    }

    public synchronized Integer removeIndex(int index) throws InterruptedException {
        rangeCheck(index);
        int value = integ[index];
        System.arraycopy(integ, index + 1, integ, index, coll - index + 1);
        coll--;
        for (int i = 0; i < size(); i++) {
            Thread.sleep(200);
            integ[i] -= value;
        }
        return value;
    }

    private void rangeCheck(int index) {
        if (index >= coll) throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
    }

    private String outOfBoundsMessage(int index) {
        return "Индекс " + index + " размер " + coll;
    }

    public synchronized int indexOf(Object o) throws InterruptedException {
        if (isCorrectType(o)){
            for (int i = 0; i < size(); i++) {
                Thread.sleep(200);
                if (integ[i].equals(o)) return i;
            }
        }
        return -1;
    }

    @Override
    public synchronized String toString() {
        if (isEmpty()) return "Коллекция: \nДобавить null:";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coll; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append(integ[i]);
            if (i + 1 != coll) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean isCorrectType(Object o) {
        return o instanceof Integer;
    }

    @Override
    public synchronized int size() {
        return coll;
    }

    @Override
    public synchronized boolean isEmpty() {
        return coll == 0;
    }

    @Override
    public synchronized boolean contains(Object o) {
        if (isEmpty() || !isCorrectType(o)) return false;
        for (int i = 0; i < coll; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (integ[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return coll > count;
            }

            @Override
            public Integer next() {
                return integ[count++];
            }
        };
    }

    @Override
    public synchronized Object[] toArray() {
        return Arrays.copyOf(integ, coll);
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public synchronized boolean add(Integer integer) {
        if (integer == null) return false;
        for (int i = 0; i < coll; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integ[i] += integer;
        }
        coll++;
        integ[coll - 1] = integer;
        return true;
    }

    @Override
    public synchronized boolean remove(Object o) {
        int index;
        try {
            if (isEmpty() || !isCorrectType(o) || (index = indexOf(o)) == -1) return false;

            removeIndex(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized void clear() {
        coll = 0;
    }
}
