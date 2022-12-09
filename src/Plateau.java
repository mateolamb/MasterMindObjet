public class Plateau {

    private static int nbEssaisMax;
    private Code[] cod;
    private int[][] rep;
    private int nbCoups;

    public Plateau(int nbEssaisMax, int lgCode) {
        Plateau.nbEssaisMax = nbEssaisMax;
        cod = new Code[nbEssaisMax];
        for (int i = 0; i < nbEssaisMax; i++) {
            cod[i] = new Code(lgCode);
        }
        rep = new int[nbEssaisMax][2];
        nbCoups = 0;
    }


    public void setCod(int nbCoups, Code cod1) {
        this.cod[nbCoups] = cod1;
    }

    public void setRep(int nbCoups, int[] rep) {
        this.rep[nbCoups] = rep;
    }

    public Code getCod(int i) {
        return cod[i];
    }

    public Code[] getCod() {
        return cod;
    }

    public int[][] getRep() {
        return rep;
    }


    public int[] getRep(int i) {
        return rep[i];
    }

    public static int getNbEssaisMax() {
        return nbEssaisMax;
    }
}
