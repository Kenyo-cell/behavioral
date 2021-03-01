package com.company;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Randoms implements Iterable<Integer> {
    private class RandomsIterator implements Iterator<Integer> {
        Random r;

        public RandomsIterator() {
            r = new Random();
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return min + r.nextInt(max - min);
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {

        }
    }
    private int min;
    private int max;


    public Randoms(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomsIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }
}
