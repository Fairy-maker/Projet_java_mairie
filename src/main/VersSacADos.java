package main;

import equipe.Projet;
import sacADos.Objet;
import sacADos.SacADos;
import solveurGlouton.ObjetInterface;

import java.util.ArrayList;
import java.util.List;

public class VersSacADos {

    private final int[] budgets;
    private final List<Projet> projets;

    public VersSacADos(int[] budgets, List<Projet> projets) {
        this.budgets = budgets;
        this.projets = projets;
    }

    public SacADos genererSacADos() {

        List<ObjetInterface> objets = new ArrayList<>();
        for (Projet projet: this.projets) {
            Objet objet = new Objet(projet.getCout().toArray(), projet.getBenefice());
            objets.add(objet);
        }

        return new SacADos(this.budgets, objets);

    }

}

