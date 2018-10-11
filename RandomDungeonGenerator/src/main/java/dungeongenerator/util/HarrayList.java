package dungeongenerator.util;

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
        for(int k = index+1; k < size; k++) {
            elements[k-1] = elements[k];
        }
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

    @Override
    public String toString() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string += elements[i] + ", ";
        }
        string = string.substring(0, string.length()-2);
        return string + "]";
    }
    
    
}
