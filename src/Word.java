import java.util.Comparator;

public class Word implements  Comparable<Word>{
    private String engWord;
    private String ruWord;
    private int count;

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Word(String engWord, int count) {

        this.engWord = engWord;
        this.count = count;
    }
    public Word(String engWord, String ruWord, int count) {

        this.engWord = engWord;
        this.ruWord = ruWord;
        this.count = count;
    }

    @Override
    public String toString() {
        return getCount() + " - " + getEngWord() + " - " + getRuWord();
    }

    @Override
    public int compareTo(Word o) {

        if (this.getCount() < o.getCount())
        {
            return 1;
        }
        else if (this.getCount() == o.getCount() && this.getEngWord().compareTo(o.getEngWord()) > 0)
        {
            return 1;
        }
        else if (this.getCount() == o.getCount() && this.getEngWord().compareTo(o.getEngWord()) == 0)
        {
            return 0;
        }
        else if (this.getCount() == o.getCount() && this.getEngWord().compareTo(o.getEngWord()) < 0)
        {
            return -1;
        }
        else
        {
            return -1;
        }

    }
}
