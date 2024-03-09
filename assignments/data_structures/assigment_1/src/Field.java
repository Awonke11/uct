package src;

public class Field {
    private String term = "";
    private String sentence = "";
    private Double confidenceScore = 0.0;
    private Integer key = null;

    public Field() {}

    public Field(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
        this.key = term.hashCode();
    }

    public String getTerm() {
        return term;
    }

    public String getSentence() {
        return sentence;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public Integer getKey() {
        return key;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void updateField(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
        this.key = term.hashCode();
    }

    @Override
    public String toString() {
        return String.format("\t\tKey: %d,\n \t\tTerm: %s,\n \t\tSentence: %s,\n \t\tConfidence Score: %f", key, term, sentence, confidenceScore);
    }
}
