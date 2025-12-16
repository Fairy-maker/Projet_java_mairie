package main;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class VersSacADosTest {

    @Test
    void lectureFichierMKPTest() throws Exception {

        URL mkpFileURL = getClass().getResource("/All-MKP-Instances/chubeas/OR5x100/OR5x100-0.25_1.dat");
        assertNotNull(mkpFileURL, "Fichier MKP introuvable dans resources");
        
        Path mkpFilePath = Paths.get(mkpFileURL.toURI());

        VersSacADos versSacADos = new VersSacADos(mkpFilePath);

        assertEquals(100, versSacADos.n);
        assertEquals(5, versSacADos.k);
        assertArrayEquals(new int[]{11927, 13727, 11551, 13056, 13460}, versSacADos.budgets);
        
    }
}