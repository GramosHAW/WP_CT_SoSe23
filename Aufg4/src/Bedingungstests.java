import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Bedingungstests {

    @Test
    void excercise01() throws FileNotFoundException {

        BedingungsBerechner bedingungsBerechner = new BedingungsBerechner();
        String exercize = "C:\\Users\\G\\Desktop\\CT\\Praktikumsaufgaben\\Material-Aufg4\\exercises\\ex1.md";
        
        //Set<List<String>> mmbueTabelle = bedingungsBerechner.mmbue(exercize);
        Set<List<String>> mcdcTabelle = bedingungsBerechner.mcdc(exercize);

        Set<List<String>> expected = null;


        expected.add(List.of("0,1,0,1"));
        expected.add(List.of("0,1,1,1"));



    }

}
