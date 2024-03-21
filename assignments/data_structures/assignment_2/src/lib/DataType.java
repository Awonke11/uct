package lib;
public class DataType {
    private String term = "";
    private String sentence = "";
    private Double confidenceScore = 0.0;

    /**
     * Default constructor
     */
    public DataType() {}

    /**
     * Constructor for DataType
     * @param term
     * @param sentence
     * @param confidenceScore
     */
    public DataType(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }

    /**
     * @return String return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return String return the sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * @param sentence the sentence to set
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * @return Double return the confidenceScore
     */
    public Double getConfidenceScore() {
        return confidenceScore;
    }

    /**
     * @param confidenceScore the confidenceScore to set
     */
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    /**
     * Override toString
     * @return string format
     */
    @Override
    public String toString() {
        return "[term=" + term + ", sentence=" + sentence + ", confidenceScore=" + confidenceScore + "]";
    }
}
