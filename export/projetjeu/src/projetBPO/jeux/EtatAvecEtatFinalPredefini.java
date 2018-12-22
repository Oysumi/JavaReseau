package projetBPO.jeux;

/**
 * @version Avril 2018
 * @author martine
 */
public abstract class EtatAvecEtatFinalPredefini implements IEtat {

    protected static EtatAvecEtatFinalPredefini etatFinal;

    /**
     * Fixer l'état final
     * @param e état final
     */
    public static void setEtatFinal(EtatAvecEtatFinalPredefini e) {
        etatFinal = e;
    }

    public static EtatAvecEtatFinalPredefini getEtatFinal() { return etatFinal ; }

    /**
     * @return vrai si l'état est final
     */
    public boolean estFinal() {
        return this.equals(getEtatFinal());
    }

}
