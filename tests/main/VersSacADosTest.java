package main;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;
import sacADos.MethodeDeResolution;
import sacADos.SacADos;
import solveurGlouton.ObjetInterface;
import solveurGlouton.Utils;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void hillClimbingMeilleurQueGloutonTest() throws Exception {

        URL mkpFileURL = getClass().getResource("/All-MKP-Instances/chubeas/OR5x100/OR5x100-0.25_1.dat");
        Path mkpFilePath = Paths.get(mkpFileURL.toURI());

        VersSacADos versSacADos = new VersSacADos(mkpFilePath);
        SacADos sac = versSacADos.genererSacADos();

        List<ObjetInterface> solutionGloutonAjout = sac.resoudre(MethodeDeResolution.GLOUTON_A_AJOUT);
        List<ObjetInterface> solutionHillClimbingSimple = sac.resoudre(MethodeDeResolution.HILL_CLIMBING_SIMPLE);
        List<ObjetInterface> solutionHillClimbingMultiple = sac.resoudre(MethodeDeResolution.HILL_CLIMBING_MULTIPLE);

        assertTrue(Utils.utilite(solutionGloutonAjout) <= Utils.utilite(solutionHillClimbingSimple));
        assertTrue(Utils.utilite(solutionHillClimbingSimple) <= Utils.utilite(solutionHillClimbingMultiple));

    }

}