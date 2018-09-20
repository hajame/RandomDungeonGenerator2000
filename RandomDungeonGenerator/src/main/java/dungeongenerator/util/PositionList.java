/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeongenerator.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * ArrayList-type data structure containing Position objects. Will be replaced
 * with a custom model.
 *
 * @author hajame
 */
public class PositionList {

    private ArrayList<Position> list;
    private int size;
    final Random random;

    public PositionList() {
        this.list = new ArrayList<>();
        this.size = 0;
        this.random = new Random();
    }

    public void add(Position position) {
        list.add(position);
        size += 1;
    }

    public void remove(int index) {
        list.remove(index);
        size -= 1;
    }

    public Position get(int i) {
        if (size == 0) {
            return null;
        }
        return list.get(i);
    }

    public int size() {
        return size;
    }

    public Position poll(int i) {
        Position pos = get(i);
        if (pos != null) {
            remove(i);
        }
        return pos;
    }

    public Position pollRandom() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return poll(0);
        }
        int i = random.nextInt(size);
        Position pos = get(i);
        remove(i);
        return pos;
    }

}
