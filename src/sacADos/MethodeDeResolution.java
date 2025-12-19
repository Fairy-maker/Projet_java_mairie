package sacADos;

/**
 * Méthodes de résolution
 *
 * Enumération représentant les différentes stratégies pour résoudre le problème du sac à dos.
 * Utilisée par la classe SacADos pour déterminer l’algorithme à appliquer.
 * Chaque valeur correspond à une approche spécifique de résolution.
 */
public enum MethodeDeResolution {
    GLOUTON_A_AJOUT,
    GLOUTON_A_RETRAIT,
    HILL_CLIMBING_SIMPLE,
    HILL_CLIMBING_MULTIPLE,
}
