package homework5.domain;

import java.util.List;

public class Word {
    private final List<Symbol> symbols;

    public Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return symbols.toString() + "";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Word word = (Word) o;
        return (symbols == word.symbols || symbols != null && symbols.equals(word.symbols));
    }
}
