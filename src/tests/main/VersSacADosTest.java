package main;

import org.junit.jupiter.api.Test;
import sacADos.SacADos;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersSacADosTest {

    @Test
    void lectureFichierMKPTest() throws Exception {

        URL mkpFileURL = getClass().getResource("/All-MKP-Instances/chubeas/OR5x100/OR5x100-0.25_1.dat");
        Path mkpFilePath = Paths.get(mkpFileURL.toURI());

        VersSacADos versSacADos = new VersSacADos(mkpFilePath);

        assertEquals(100, versSacADos.n);
        assertEquals(5, versSacADos.k);
        assertArrayEquals(new int[]{11927, 13727, 11551, 13056, 13460}, versSacADos.budgets);
        
    }
}