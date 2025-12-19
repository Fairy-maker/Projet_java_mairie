package equipe;

import java.util.*;

/**
 * Représente une équipe municipale composé de :
 * <ul>
 * <li> un élu qui évalue le bénéfice d'un projet, </li>
 * <li> trois évaluateurs (un économique, un social et un environnemental) qui évaluent le coût du projet, </li>
 * <li> une liste d'expert spécialisés dans des secteurs particuliers et qui proposent des projets. </li>
 * </ul>
 *
 * @author feryel benameur
 * @version 1.0
 */

public class EquipeMunicipale {

    private final Elu elu;
    private final List<Evaluateur> evaluateurs;
    private final List<Expert> experts;

    private final List<Projet> projetsEtudies = new ArrayList<>();

    /**
     * Constructeur qui nous permet de créer une nouvelle équipe municipale
     *
     * @param elu             l'élu chargé d'évaluer le bénéfice des projets
     * @param evaluateurs     l'ensemble des évaluateurs
     * @param experts         la liste d'expert spécialisé dans des secteurs particulier et qui sont chargé de proposer des projets
     */
    public EquipeMunicipale(Elu elu, List<Evaluateur> evaluateurs, List<Expert> experts) {
        this.elu = elu;
        this.evaluateurs = evaluateurs;
        this.experts = experts;
    }

    /**
     * Méthode qui retourne la liste des projets étudiés.
     *
     * @return La liste des projets étudiés.
     */
    public List<Projet> getProjetsEtudies() {
        return projetsEtudies;
    }

    /**
     * Exécute un cycle de simulation des projets
     * <p>
     * Si la liste des projets à évaluer est vide alors la méthode demande à chaque experts de proposer un projet,
     * en fait évaluer les coûts par nos évaluateurs,
     * fait estimer le bénéfice par l'élu et enfin,
     * ajoute le projet à la liste des projets étudiés.
     * </p>
     * <p>
     * Si des projets ont déjà été étudiés, la méthode ne fait rien.
     * </p>
     */
    public void executerUnCycleDeSimulation() {
        if (!this.projetsEtudies.isEmpty()) {
            return;
        }
        for (Expert expert : this.experts) {
            List<Projet> projetsDeExpert = expert.proposerProjets();
            for (Projet p : projetsDeExpert) {
                for (Evaluateur evaluateur : evaluateurs) {
                    evaluateur.evaluerCoutProjet(p);
                }
                elu.estimerBenefice(p);
                this.projetsEtudies.add(p);
            }
        }
    }

}
