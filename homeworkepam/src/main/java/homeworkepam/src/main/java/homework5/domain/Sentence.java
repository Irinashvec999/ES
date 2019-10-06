package homework5.domain;

import java.util.List;

public class Sentence {
    public List<Word> getWords() {
        return words;
    }

    private final List<Word> words;

    public Sentence(List<Word> words) {
        this.words = words;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((words == null) ? 0 : words.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return (getWords() == sentence.words || words != null && words.equals(sentence.words));
    }

    @Override
    public String toString() {
        return words.toString().split(" ") + ".";
    }
}
