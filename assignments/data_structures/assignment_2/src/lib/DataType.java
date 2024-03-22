package lib;

/**
 * DataType class
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
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
     * @param term the term
     * @param sentence the sentence
     * @param confidenceScore the confidenceScore
     */
    public DataType(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
    }

    /**
     * Get the term
     * @return String return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Set the term
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Get the sentence
     * @return String return the sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Set the sentence
     * @param sentence the sentence to set
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Get the confidenceScore
     * @return Double return the confidenceScore
     */
    public Double getConfidenceScore() {
        return confidenceScore;
    }

    /**
     * Set the confidenceScore
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
