package src;

/**
 * The `Field` class represents a data structure for storing information related to a field, such as term, sentence, confidence score, and a unique key.
 * It provides methods for retrieving and updating these properties, as well as generating a string representation of the field.
 *
 * @author Awonke Mnotoza
 * @version 1.0.0
 */
public class Field {
    private String term = "";
    private String sentence = "";
    private Double confidenceScore = 0.0;
    private Integer key = null;

    /**
     * <h3>Constructor</h3>
     * Constructs an empty `Field` object.
     */
    public Field() {}

    /**
     * <h3>Constructor</h3>
     * Constructs a `Field` object with the specified term, sentence, and confidence score.
     *
     * @param term            The term associated with the field.
     * @param sentence        The sentence associated with the field.
     * @param confidenceScore The confidence score associated with the field.
     */
    public Field(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
        this.key = term.hashCode();
    }

    /**
     * <h3>Get term</h3>
     * Gets the term associated with the field.
     *
     * @return The term as a string.
     */
    public String getTerm() {
        return term;
    }

    /**
     * <h3>Get sentence</h3>
     * Gets the sentence associated with the field.
     *
     * @return The sentence as a string.
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * <h3>Get confidence score</h3>
     * Gets the confidence score associated with the field.
     *
     * @return The confidence score as a double.
     */
    public Double getConfidenceScore() {
        return confidenceScore;
    }

    /**
     * <h3>Get key</h3>
     * Gets the unique key associated with the field.
     *
     * @return The key as an integer.
     */
    public Integer getKey() {
        return key;
    }

    /**
     * <h3>Set term</h3>
     * Sets the term associated with the field.
     *
     * @param term The term to set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * <h3>Set sentence</h3>
     * Sets the sentence associated with the field.
     *
     * @param sentence The sentence to set.
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * <h3>Set confidence score</h3>
     * Sets the confidence score associated with the field.
     *
     * @param confidenceScore The confidence score to set.
     */
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    /**
     * <h3>Set key</h3>
     * Sets the unique key associated with the field.
     *
     * @param key The key to set.
     */
    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     * <h3>Update field</h3>
     * Updates the field with new values for term, sentence, and confidence score.
     *
     * @param term            The new term to set.
     * @param sentence        The new sentence to set.
     * @param confidenceScore The new confidence score to set.
     */
    public void updateField(String term, String sentence, Double confidenceScore) {
        this.term = term;
        this.sentence = sentence;
        this.confidenceScore = confidenceScore;
        this.key = term.hashCode();
    }

    /**
     * <h3>Generate string</h3>
     * Generates a string representation of the `Field` object, including key, term, sentence, and confidence score.
     *
     * @return A formatted string representing the field.
     */
    @Override
    public String toString() {
        return String.format("\t\tKey: %d,\n \t\tTerm: %s,\n \t\tSentence: %s,\n \t\tConfidence Score: %f", key, term, sentence, confidenceScore);
    }
}
