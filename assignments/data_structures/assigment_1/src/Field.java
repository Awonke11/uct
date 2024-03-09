package src;

/**
 * The `Field` class represents a data structure for storing information related to a field, such as term, sentence, confidence score, and a unique key.
 * It provides methods for retrieving and updating these properties, as well as generating a string representation of the field.
 *
 * author: Awonke Mnotoza
 * version: 1.0.0
 */
public class Field {
    private String term = "";
    private String sentence = "";
    private Double confidenceScore = 0.0;
    private Integer key = null;

    /**
     *  Constructor<br />
     * Constructs an empty `Field` object.
     */
    public Field() {}

    /**
     *  Constructor<br />
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
     *  Get term<br />
     * Gets the term associated with the field.
     *
     * @return The term as a string.
     */
    public String getTerm() {
        return term;
    }

    /**
     *  Get sentence<br />
     * Gets the sentence associated with the field.
     *
     * @return The sentence as a string.
     */
    public String getSentence() {
        return sentence;
    }

    /**
     *  Get confidence score<br />
     * Gets the confidence score associated with the field.
     *
     * @return The confidence score as a double.
     */
    public Double getConfidenceScore() {
        return confidenceScore;
    }

    /**
     *  Get key<br />
     * Gets the unique key associated with the field.
     *
     * @return The key as an integer.
     */
    public Integer getKey() {
        return key;
    }

    /**
     *  Set term<br />
     * Sets the term associated with the field.
     *
     * @param term The term to set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     *  Set sentence<br />
     * Sets the sentence associated with the field.
     *
     * @param sentence The sentence to set.
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     *  Set confidence score<br />
     * Sets the confidence score associated with the field.
     *
     * @param confidenceScore The confidence score to set.
     */
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    /**
     *  Set key<br />
     * Sets the unique key associated with the field.
     *
     * @param key The key to set.
     */
    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     *  Update field<br />
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
     *  Generate string<br />
     * Generates a string representation of the `Field` object, including key, term, sentence, and confidence score.
     *
     * @return A formatted string representing the field.
     */
    @Override
    public String toString() {
        return String.format("\t\tKey: %d,\n \t\tTerm: %s,\n \t\tSentence: %s,\n \t\tConfidence Score: %f", key, term, sentence, confidenceScore);
    }
}
