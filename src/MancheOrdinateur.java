public class MancheOrdinateur {

    private Plateau p;

    public MancheOrdinateur(int nbEssaisMax, int lgCode) {
        p = new Plateau(nbEssaisMax, lgCode);
    }

    public int joue(int lgCode) {
        System.out.println("Voici le code proposé par l'ordinateur.");
        System.out.println("\n------------------------------\n");
        System.out.println(UtMM.entiersVersMot(p.getCod(0), Couleur.getTabCouleurs()));
        p.setRep(0, UtMM.reponseHumain(lgCode));
        if (p.getRep(0)[0] == lgCode) {
            System.out.println("!!! L'IA a trouvé le bon code !!!");
            return 1;
        }

        for (int i = 1; i < Plateau.getNbEssaisMax(); i++) {
            Code cod1 = UtMM.copieTab(p.getCod(i - 1));
            if (!UtMM.passeCodeSuivantLexicoCompat(cod1, p.getCod(), p.getRep(), i, Couleur.getTaille())) {
                return 0;
            }
            p.setCod(i, cod1);
            System.out.println("Voici le code proposé par l'ordinateur.");
            System.out.println("\n------------------------------\n");
            System.out.println(UtMM.entiersVersMot(p.getCod()[i], Couleur.getTabCouleurs()));
            p.setRep(i, UtMM.reponseHumain(lgCode));
            if (p.getRep(i)[0] == lgCode) {
                System.out.println("!!! L'IA a trouvé le bon code !!!");

                return i;
            }

        }

        return p.getRep(lgCode - 1)[1] + 2 * (lgCode - (p.getRep(lgCode - 1)[0] + p.getRep(lgCode - 1)[1]));
    }
}
