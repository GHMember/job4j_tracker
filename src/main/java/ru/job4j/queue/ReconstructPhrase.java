package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder firstPart = new StringBuilder();
        Iterator<Character> iterator = evenElements.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            if (i % 2 == 0) {
                firstPart.append(evenElements.element());
            }
            evenElements.poll();
        }
        return firstPart.toString();
    }

    private String getDescendingElements() {
        StringBuilder secondPart = new StringBuilder();
        Iterator<Character> dIterator = descendingElements.descendingIterator();
        while (dIterator.hasNext()) {
            secondPart.append(dIterator.next());
        }
        return secondPart.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}