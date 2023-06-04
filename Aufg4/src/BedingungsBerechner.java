import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BedingungsBerechner {

    Set<List<String>> ergebnisWerte = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        BedingungsBerechner bedingungsBerechner = new BedingungsBerechner();
        String exercize = "C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex7.md";
        String neueMD = "C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\test2.md";

        bedingungsBerechner.mcdc(exercize);
        bedingungsBerechner.mdTabelleErstellen(neueMD, bedingungsBerechner.getErgebnisWerte());

    }

        private TabellenLeser leser = new TabellenLeser();

        public boolean isNachbar(List<String> zeile1, List<String> zeile2) {
            int count = 0;

            for (int i = 0; i < zeile1.size() - 1; i++) {
                if (!zeile1.get(i).equals(zeile2.get(i))) {
                    count++;
                }
            }

            if (count > 1) {
                return false;
            }

            return true;
        }

        public List<List<String>> findAllNeighbours(List<String> zeile, List<List<String>> liste) {

            List<List<String>> neighbours = new ArrayList<>();

            for (int i = 0; i < liste.size(); i++) {
                if (isNachbar(zeile, liste.get(i))) {
                    neighbours.add(liste.get(i));
                }
            }
            return neighbours;
        }



        public Set<List<String>> mmbue(String file) throws FileNotFoundException {

            List<List<String>> werteListe = leser.leseTabelle(file);


            int werteListeSize = werteListe.size();
            int werteListeZeileSize = werteListe.get(0).size();


            for (int zeile = 0; zeile < werteListeSize; zeile++){
                List<List<String>> neighbours = findAllNeighbours(werteListe.get(zeile), werteListe);

                for (int n = 0; n < neighbours.size(); n++) {
                    if (!werteListe.get(zeile).get(werteListeZeileSize - 1).equals(neighbours.get(n).get(werteListeZeileSize - 1))) {
                        ergebnisWerte.add(neighbours.get(n));
                    }
                }
            }
            ergebnisWerte.forEach(System.out::println);
            return ergebnisWerte;
        }

        public void mcdc(String file) throws FileNotFoundException {

            List<List<String>> werteListe = leser.leseTabelle(file);
            Set<List<String>> ergebnisWerte = new HashSet<>();

            int werteListeSize = werteListe.size();
            int werteListeZeileSize = werteListe.get(0).size();



            for (int zeile = 0; zeile < werteListeSize; zeile++){
                List<List<String>> neighbours = findAllNeighbours(werteListe.get(zeile), werteListe);

                for (int n = 0; n < neighbours.size(); n++) {
                    if (!werteListe.get(zeile).get(werteListeZeileSize - 1).equals(neighbours.get(n).get(werteListeZeileSize - 1))) {
                        ergebnisWerte.add(neighbours.get(n));

                    }


                }
            }
            System.out.println(ergebnisWerte);
        }

    public void mdTabelleErstellen(String filePath, Set<List<String>> tableData) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write the Markdown table header
            writer.write("| A | B | C | Ergebnis |\n");
            writer.write("| -------- | -------- | -------- | -------- |\n");

            // Write the table data
            for (List<String> rowData : tableData) {
                writer.write("| " + rowData.get(0) + " | " + rowData.get(1) + " | " + rowData.get(2) + " | " + rowData.get(3) + " |\n");
            }

            System.out.println("Markdown table generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<List<String>> getErgebnisWerte() {
            return ergebnisWerte;
    }

    }


