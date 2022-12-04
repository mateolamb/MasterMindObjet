public class MainMasterMind {

    public static void main(String[] args) {

        System.out.println("\n\n\n /$$      /$$                       /$$                               /$$      /$$ /$$                 /$$");
        System.out.println("| $$$    /$$$                      | $$                              | $$$    /$$$|__/                | $$");
        System.out.println(("| $$$$  /$$$$  /$$$$$$   /$$$$$$$ /$$$$$$    /$$$$$$   /$$$$$$       | $$$$  /$$$$ /$$ /$$$$$$$   /$$$$$$$"));
        System.out.println("| $$ $$/$$ $$ |____  $$ /$$_____/|_  $$_/   /$$__  $$ /$$__  $$      | $$ $$/$$ $$| $$| $$__  $$ /$$__  $$");
        System.out.println("| $$  $$$| $$  /$$$$$$$|  $$$$$$   | $$    | $$$$$$$$| $$  \\__/      | $$  $$$| $$| $$| $$  \\ $$| $$  | $$");
        System.out.println("| $$\\  $ | $$ /$$__  $$ \\____  $$  | $$ /$$| $$_____/| $$            | $$\\  $ | $$| $$| $$  | $$| $$  | $$");
        System.out.println("| $$ \\/  | $$|  $$$$$$$ /$$$$$$$/  |  $$$$/|  $$$$$$$| $$            | $$ \\/  | $$| $$| $$  | $$|  $$$$$$$");
        System.out.println("|__/     |__/ \\_______/|_______/    \\___/   \\_______/|__/            |__/     |__/|__/|__/  |__/ \\_______/");
        System.out.println("\n\n\n------------------------------\n\nBienvenue sur notre MasterMind\n\n------------------------------\n\n\n  ");


        System.out.println("Veuillez choisir la longueur du code à trouver, ");
        int lgCode = UtMM.saisirEntierPositif();
        System.out.println("\n------------------------------\n");


        System.out.println("Combien de manches voulez-vous faire ?");
        int numManche = UtMM.saisirEntierPairPositif();
        System.out.println("\n------------------------------\n");


        System.out.println("Veuillez choisir le nombre d'essaie maximum");
        int nbEssaisMax = UtMM.saisirEntierPositif();
        System.out.println("\n------------------------------\n");

        // on demande tabCouleurs
        char[] tabCouleurs = UtMM.saisirCouleurs();
        Couleur.rentrerCouleurs(tabCouleurs);

        Partie LaPartie = new Partie(numManche);

        LaPartie.joue(nbEssaisMax, lgCode);

    }


}
