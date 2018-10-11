package dungeongenerator.util;

import java.util.Arrays;

/**
 * Custom ArrayList named after its creator.
 *
 * @author hajame
 * @param <E>
 */
public class HarrayList<E> {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public HarrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Object e) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size] = e;
        size++;
    }

    public Object get(int index) {
        checkRange(index);
        return elements[index];
    }

    /**
     * Removes an element from the list and returns it.
     * 
     * @param index
     * @return 
     */
    public E remove(int index) {
        checkRange(index);
        E removedElement = (E) elements[index];
        int shiftAmount = size - index - 1;
        
        // Shifts all elemets to the left
        System.arraycopy(elements, index + 1, elements, index, shiftAmount);
        size--;
        elements[size] = null;
        return removedElement;
    }

    /**
     * Checks if index is within limits.
    */
    public void checkRange(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
    }

    private void increaseCapacity() {
        Object list[] = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            list[i] = elements[i];
        }
        elements = list;
    }
}
