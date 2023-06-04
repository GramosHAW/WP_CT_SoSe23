

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class TabellenLeser {

        public List<List<String>> leseTabelle(String filePath) {
            List<List<String>> tableData = new ArrayList<>();
            String zeile;
            boolean start = false;
            boolean ueberschrift = false;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while ((zeile = br.readLine()) != null) {
                    if (zeile.trim().startsWith("|")) {
                        if (!start) {
                            start = true;
                            continue;
                        }

                        if (!ueberschrift) {
                            ueberschrift = true;
                            continue;
                        }
                        List<String> daten = datenParsen(zeile);
                        tableData.add(daten);
                    } else {
                        if (start && !ueberschrift) {
                            ueberschrift = true;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return tableData;
        }

        private List<String> datenParsen(String zeile) {
            List<String> daten = new ArrayList<>();
            Pattern pattern = Pattern.compile("(?<=\\|)\\s*([^|]+)\\s*(?=\\|)");
            Matcher matcher = pattern.matcher(zeile);

            while (matcher.find()) {
                String value = matcher.group(1).trim();
                daten.add(value);
            }

            return daten;
        }
    }



