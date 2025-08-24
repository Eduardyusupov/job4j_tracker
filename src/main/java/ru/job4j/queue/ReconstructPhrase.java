package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder phrase = new StringBuilder();
        int position = 0;
        for (Character character : evenElements) {
            if (position % 2 == 0) {
                phrase.append(character);
            }
            position++;
        }
        return phrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder phrase = new StringBuilder();
        for (int i = descendingElements.size(); i > 0;  i--) {
            phrase.append(descendingElements.pollLast());
        }
        return phrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}