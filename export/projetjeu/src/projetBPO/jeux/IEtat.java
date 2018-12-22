package projetBPO.jeux;

public interface IEtat extends Iterable<IEtat>{

    /**
     * @return vrai si l'état est final
     */
    boolean estFinal();
}
