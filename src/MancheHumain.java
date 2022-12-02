public class MancheHumain {

    private Plateau p;

    public MancheHumain(int nbEssaisMax){
        p=new Plateau(nbEssaisMax);
    }

    public int partie(int lgCode){
        Code cod1 = UtMM.codeAleat(lgCode, Couleur.getTaille());
        Code cod2;
        Code nbBienMal = new Code(2);
        for (int i = 1; i <= Plateau.getNbEssaisMax(); i++) {
            System.out.println("\n------------------------------\n");
            System.out.println("Vous pouvez choisir entre ses couleurs : " +Couleur.pourEcrire());
            cod2 = UtMM.propositionCodeHumain(i, lgCode, Couleur.getTabCouleurs());
            if (UtMM.nbBienMalPlaces(cod1, cod2, Couleur.getTaille()).getCode(0) == lgCode) {
                System.out.println("\n------------------------------\n");
                System.out.println("!!! vous avez trouvé le code !!!");
                System.out.println("\n------------------------------\n");

                return i;
            } else {
                nbBienMal = UtMM.nbBienMalPlaces(cod1, cod2,Couleur.getTaille());

                System.out.println("Voici le code que vous avez rentré.");
                System.out.println(UtMM.entiersVersMot(cod2, Couleur.getTabCouleurs()));
                System.out.println("\n------------------------------\n");
                System.out.println("vous avez " + nbBienMal.getCode(0) + " pion(s) bien placé(s).");
                System.out.println("Vous avez " + nbBienMal.getCode(1) + " pion(s) mal placé(s) :");
                System.out.println("\n------------------------------\n");

            }
        }
        return nbBienMal.getCode(1) + 2 * (lgCode - (nbBienMal.getCode(0) + nbBienMal.getCode(1)));
    }
}
