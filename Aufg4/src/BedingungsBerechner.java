import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BedingungsBerechner {

    Set<List<String>> ergebnisSet = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {

        List<String> alleExercizes = new ArrayList<>();
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex1.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex2.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex3.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex4.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex5.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex6.md");
        alleExercizes.add("C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex7.md");

        BedingungsBerechner bedingungsBerechner = new BedingungsBerechner();
        String exercize = "C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex7.md";
        String neueMD = "C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\test2.md";


        //bedingungsBerechner.mcdc(exercize);
        bedingungsBerechner.mdTabelleErstellen(neueMD, bedingungsBerechner.mmbue(exercize));
    }

    private TabellenLeser leser = new TabellenLeser();

    public boolean istNachbar(List<String> zeile1, List<String> zeile2) {
        int noMatch = 0;

        for (int i = 0; i < zeile1.size() - 1; i++) {
            if (!zeile1.get(i).equals(zeile2.get(i))) {
                noMatch++;
            }
        }

        if (noMatch > 1) {
            return false;
        }

        return true;
    }

    public List<List<String>> getNachbarn(List<String> zeile, List<List<String>> liste) {

        List<List<String>> nachbarn = new ArrayList<>();

        for (int i = 0; i < liste.size(); i++) {
            if (istNachbar(zeile, liste.get(i))) {
                nachbarn.add(liste.get(i));
            }
        }
        return nachbarn;
    }


    public Set<List<String>> mmbue(String file) throws FileNotFoundException {

        List<List<String>> werteListe = leser.leseTabelle(file);
        Set<List<String>> ergebnisSet = new HashSet<>();

        int werteListeSize = werteListe.size();
        int werteListeZeileSize = werteListe.get(0).size();


        for (int zeile = 0; zeile < werteListeSize; zeile++) {
            List<List<String>> nachbarn = getNachbarn(werteListe.get(zeile), werteListe);

            for (List<String> nachbar : nachbarn) {
                if (!werteListe.get(zeile).get(werteListeZeileSize - 1).equals(nachbar.get(werteListeZeileSize - 1))) {
                    ergebnisSet.add(nachbar);
                }
            }
        }
        ergebnisSet.forEach(System.out::println);
        return ergebnisSet;
    }

    public Set<List<String>> mcdc(String file) throws FileNotFoundException {

        List<List<String>> werteTabelle = leser.leseTabelle(file);
        //Set<List<String>> ergebnisSet = new HashSet<>();

        int werteTabelle_size = werteTabelle.size();
        int werteTabeleZeile_size = werteTabelle.get(0).size();


        for (int zeile = 0; zeile < werteTabelle_size; zeile++) {
            List<List<String>> nachbarn = getNachbarn(werteTabelle.get(zeile), werteTabelle);


            for (List<String> nachbar : nachbarn) {
                if (!werteTabelle.get(zeile).get(werteTabeleZeile_size - 1).equals(nachbar.get(werteTabeleZeile_size - 1))) {
                    ergebnisSet.add(nachbar);
                }
            }
        }
        System.out.println(ergebnisSet);
        return ergebnisSet;
    }

    public void mdTabelleErstellen(String dateiPfad, Set<List<String>> ergebnisTabelle) {
        try (FileWriter writer = new FileWriter(dateiPfad)) {
            writer.write("| A | B | C | Ergebnis |\n");
            writer.write("| --- | --- | --- | --- |\n");


            for (List<String> zeileData : ergebnisTabelle) {
                writer.write("| " + zeileData.get(0) + " | " + zeileData.get(1) + " | " + zeileData.get(2) + " | " + zeileData.get(3) + " |\n");
            }

            System.out.println("Markdowntabelle generiert");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<List<String>> getErgebnisSet() {
        return ergebnisSet;
    }

}


