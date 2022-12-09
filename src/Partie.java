public class Partie {

    private int nbManches;
    private int numManche;
    private int scoreJoueur;
    private int scoreOrdi;

    public Partie(int nbManches) {
        this.nbManches = nbManches;
        numManche = 1;
        scoreJoueur = 0;
        scoreOrdi = 0;
    }

    public void joue(int nbEssaisMax, int lgCode) {
        for (int i = 1; i <= nbManches; i++) {

            System.out.println("\n------------------------------\n");

            if (i % 2 == 1) {
                MancheHumain MH = new MancheHumain(nbEssaisMax, lgCode);

                System.out.println("C'est à votre tour d'être le codeur.");
                System.out.println("\n------------------------------\n");
                scoreOrdi += MH.joue(lgCode);

                System.out.println("Le score de l'IA est de : " + scoreOrdi);
                System.out.println("\n------------------------------\n");


            } else {
                MancheOrdinateur MO = new MancheOrdinateur(nbEssaisMax, lgCode);

                System.out.println("C'est au tour de notre IA d'être le codeur.");
                System.out.println("\n------------------------------\n");
                int M_o = MO.joue(lgCode);

                if (M_o != 0) {
                    scoreJoueur += M_o;
                    System.out.println("Votre score est de : " + scoreJoueur);
                    System.out.println("\n------------------------------\n");
                } else {
                    System.out.println("Vous vous êtes trompé dans vos saisies. Passons à la manche suivante.");
                }

            }


        }

        System.out.println("----------------- \n\n");
        System.out.println("C'est la fin de la partie. \nVotre score final est : " + scoreJoueur + ". \nLe score final de l'IA est : " + scoreOrdi + ".");
        System.out.println("\n------------------------------\n");

        if (scoreJoueur > scoreOrdi) {
            System.out.println("Vous avez gagné la parti !!! \nMerci d'avoir joué avec nous.");
        } else if (scoreJoueur==scoreOrdi) {
            System.out.println("vous avez fait égalité!!! \nMerci d'avoir joué avec nous.");
        } else {
            System.out.println("Vous avez perdu la parti ... \nMerci d'avoir joué avec nous.");
        }
    }
}
