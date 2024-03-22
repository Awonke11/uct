package performance;

/**
 * A class to test performance of executions
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class Performance {
    private int executionCount = 0;
    /**
     * General Constructor
     */
    public Performance() {}

    /**
     * Get the execution count
     * @return the execution count
     */
    public int getExecutionCount() {
        return executionCount;
    }

    /**
     * Increment the execution count
     */
    public void incrementExecutionCount() {
        executionCount++;
    }

    /**
     * Evaluate the time complexity
     * @param count the number of executions
     * @param size the size of the tree
     * @return the time complexity
     */
    private String evaluateTimeComplexity(int count, int size) {
        if (count == 1) {
            return "O(1)";
        }
        if (count <= (size / 2)) {
            return "O(log(n))"; 
        }
        return "O(n)";
    }

    /**
     * Print the performance analysis
     * @param count the number of executions
     * @param size the size of the tree
     * @return the performance analysis
     */
    public String performanceAnalysis(int count, int size) {
        String timeComplexity = evaluateTimeComplexity(count, size);
        String analysisOutput = String.format("""
                +------------------------+-------------+-----------------+
                | Number of executions   | Data size   | Time complexity |
                -------------------------+-------------+------------------
                | %d                     | %d        | %s       |
                +------------------------+-------------+-----------------+
                """, count, size, timeComplexity);

        return analysisOutput;
    }

    /**
     * Override toString
     * @return string format
     */
    @Override
    public String toString() {
        return "Performance [Execution count = " + executionCount + " ]";
    }
}
