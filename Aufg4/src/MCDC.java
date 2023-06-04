import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MCDC {
    public static void main(String[] args) {
        MCDC mcdc = new MCDC();
        boolean [] arr = {true, false, false, false};
        boolean[][] alley = {
                {true, true, true, true},
                {true, true, false, true},
                {true, false, true, true},
                {true, false, false, false},
                {false, true, true, true},
                {false, true, false, true},
                {false, false, true, true},
                {false, false, false, false}
        };

        System.out.println(mcdc.alleNachbarn(arr,alley));

    }

    public boolean isNachbar(boolean x1[], boolean x2[]) {

        int zaehler = 0;

        for (int i = 0; i <  x1.length - 1; i++) {
            if (x1[i] == x2[i]) {
                zaehler++;
            }

            if (zaehler == 2) {
                return true;
            }

        }

        return false;
    }




    public List<List<Boolean>> alleNachbarn(boolean [] arr, boolean[][] array) {
        List<List<Boolean>> nachbarn = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {
            if (isNachbar(arr, array[i])) {
                List<Boolean> nachbarZeile = new ArrayList<>();
                for (boolean value : array[i]) {
                    nachbarZeile.add(value);
                }
                nachbarn.add(nachbarZeile);
            }
        }
        return nachbarn;
    }




    private static List<String> readMarkdownTableFromFile(String filePath) {
        List<String> markdownTable = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                markdownTable.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return markdownTable;
    }



}
