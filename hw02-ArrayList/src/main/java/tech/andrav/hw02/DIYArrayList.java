package tech.andrav.hw02;

import java.util.*;

public class DIYArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private Object[] items;

    public DIYArrayList() {
        super();
        this.items = new Object[DEFAULT_CAPACITY];
    }

    public DIYArrayList(int initialCapacity) {
        super();
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        this.items = new Object[initialCapacity];
    }

    private void grow() {
        Object[] old = this.items;
        this.items = new Object[old.length << 1];
        System.arraycopy(old, 0, items, 0, this.size);
    }

    public int getCapacity() {
        return this.items.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new DIYIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size - 1];
        System.arraycopy(this.items, 0, arr, 0, this.size);
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        checkCapacity();
        items[size] = e;
        size++;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        checkCapacity();
        System.arraycopy(this.items, index, this.items, index + 1, this.size - index);
        this.items[index] = e;
        this.size++;
    }

    private boolean checkCapacity() {
        if (this.size == this.items.length) {
            grow();
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) this.items[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) (this.items[index] = element);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        E removeItem = (E) this.items[index];
        System.arraycopy(this.items, index + 1, this.items, index, this.size - index - 1);
        this.size--;
        return removeItem;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new DIYListIterator();
    }


    // UnsupportedOperations
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // inner class
    private class DIYIterator implements Iterator<E> {

        int cursorPos = 0;

        public boolean hasNext() {
            return cursorPos < size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) DIYArrayList.this.items[cursorPos++];
        }

        public void remove() {
            DIYArrayList.this.remove(--cursorPos);
        }
    }

    private class DIYListIterator extends DIYIterator implements ListIterator<E> {

        @Override
        public void set(E o) {
            DIYArrayList.this.items[cursorPos - 1] = o;
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E o) {
            throw new UnsupportedOperationException();
        }
    }
}
