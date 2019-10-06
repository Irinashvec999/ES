package homework5.domain;

import java.util.List;

public class Text {
    private final Sentence header;
    private final List<Sentence> sentences;

    public Text(Sentence header, List<Sentence> sentences) {
        this.header = header;
        this.sentences = sentences;
    }

    public Sentence getHeader() {
        return header;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((header == null) ? 0 : header.hashCode());
        result = prime * result + ((sentences == null) ? 0 : sentences.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Text text = (Text) o;
        return (header == text.header || header != null && header.equals(text.header)) &&
                (sentences == text.sentences || sentences != null && sentences.equals(text.sentences));

    }

    @Override
    public String toString() {
        return header + "\n" + sentences;
    }
}
