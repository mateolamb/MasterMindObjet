public class MancheHumain {

    private Plateau p;

    public MancheHumain(int nbEssaisMax, int lgCode) {
        p = new Plateau(nbEssaisMax, lgCode);
    }

    public int joue(int lgCode) {
        Code cod1 = UtMM.codeAleat(lgCode, Couleur.getTaille());
        for (int i = 1; i < Plateau.getNbEssaisMax(); i++) {
            System.out.println("\n------------------------------\n");
            System.out.println("Vous pouvez choisir entre ses couleurs : " + Couleur.pourEcrire());
            p.setCod(i, UtMM.propositionCodeHumain(i, lgCode, Couleur.getTabCouleurs()));
            if (UtMM.nbBienMalPlaces(cod1, p.getCod(i), Couleur.getTaille())[0] == lgCode) {
                System.out.println("\n------------------------------\n");
                System.out.println("!!! vous avez trouvé le code !!!");
                System.out.println("\n------------------------------\n");

                return i;
            } else {
                p.setRep(i, UtMM.nbBienMalPlaces(cod1, p.getCod(i), Couleur.getTaille()));

                System.out.println("Voici le code que vous avez rentré.");
                System.out.println(UtMM.entiersVersMot(p.getCod(i), Couleur.getTabCouleurs()));
                System.out.println("\n------------------------------\n");
                System.out.println("vous avez " + p.getRep(i)[0] + " pion(s) bien placé(s).");
                System.out.println("Vous avez " + p.getRep(i)[1] + " pion(s) mal placé(s) :");
                System.out.println("\n------------------------------\n");

            }
        }
        return p.getRep(lgCode - 1)[1] + 2 * (lgCode - (p.getRep(lgCode - 1)[0] + p.getRep(lgCode - 1)[1]));
    }
}
