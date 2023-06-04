import java.util.ArrayList;
import java.util.List;

public class MCDCCoverageCalculator {

    public static void main(String[] args) {
        boolean[][] testCases = {
                {true, true, true, true},
                {true, true, false, true},
                {true, false, true, true},
                {true, false, false, false},
                {false, true, true, true},
                {false, true, false, true},
                {false, false, true, true},
                {false, false, false, false}
        };

        int mcDCCoverage = calculateMCDCCoverage(testCases);
        System.out.println("MC/DC Coverage: " + mcDCCoverage);
    }

    public static int calculateMCDCCoverage(boolean[][] testCases) {
        int conditionCount = testCases[0].length - 1; // Subtract 1 for the output element

        List<Integer> significantRows = new ArrayList<>();

        // Find the significant rows
        for (int i = 0; i < testCases.length; i++) {
            boolean[] currentRow = testCases[i];
            boolean currentRowOutput = currentRow[conditionCount];

            boolean isSignificant = true;

            for (int j = 0; j < testCases.length; j++) {
                if (i != j) {
                    boolean[] neighborRow = testCases[j];
                    boolean neighborRowOutput = neighborRow[conditionCount];

                    if (currentRowOutput == neighborRowOutput) {
                        boolean isModified = false;

                        for (int k = 0; k < conditionCount; k++) {
                            if (currentRow[k] != neighborRow[k]) {
                                isModified = true;
                                break;
                            }
                        }

                        if (!isModified) {
                            isSignificant = false;
                            break;
                        }
                    }
                }
            }

            if (isSignificant) {
                significantRows.add(i);
            }
        }

        // Calculate MC/DC Coverage
        int totalConditions = conditionCount;
        int totalSignificantConditions = significantRows.size();

        return (totalSignificantConditions * 100) / totalConditions;
    }
}
