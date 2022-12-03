import java.util.*;
public class UtMM {


    public static int[] initTab(int nb, int val) {

        int[] tab = new int[nb];
        for (int i = 0; i < nb; i++) {
            tab[i] = val;
        }

        return tab;

    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : une copie de tab
     */
    public static Code copieTab(Code tab) {

        Code tab2 = new Code(tab.getLgCode());
        for (int i = 0; i < tab.getLgCode(); i++) {
            tab2.setCode(i,tab.getCode(i));
        }

        return tab2;

    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : la liste des éléments de t entre parenthèses et séparés par des virgules
     */
    public static String listElem(char[] t) {

        String str = "";

        str += "(" + t[0];

        for (int i = 1; i < t.length; i++) {
            str += "," + t[i];
        }
        str += ")";
        return str;
    }

    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : le plus grand indice d'une case de t contenant c s'il existe, -1 sinon
     */
    public static int plusGrandIndice(char[] t, char c) {

        boolean contient = false;
        int ind = 0;

        for (int i = 0; i < t.length; i++) {
            if (t[i] == c) {
                contient = true;
                ind = i;
            }
        }

        if (!contient) {
            return -1;
        } else {
            return ind;
        }


    }
    //______________________________________________

    /**
     * pré-requis : aucun
     * résultat : vrai ssi c'est un élément de t
     * stratégie : utilise la fonction plusGrandIndice
     */
    public static boolean estPresent(char[] t, char c) {

        int result = plusGrandIndice(t, c);

        return result != -1;

    }

    //______________________________________________

    /**
     * pré-requis : aucun;
     * action : affiche un doublon et 2 de ses indices dans t s'il en existe
     * résultat : vrai ssi les éléments de t sont différents.
     * Stratégie : utilise la fonction plusGrandIndice.
     */
    public static boolean elemDiff(char[] t) {
        for (int i = 0; i < t.length; i++) {
            if (i != plusGrandIndice(t, t[i])) {
                System.out.println(t[i] + " est un doublon et ses indices dans le tableau sont " + i + " et " + plusGrandIndice(t, t[i]));
                System.out.println("\n------------------------------\n");
                return false;
            }

        }
        return true;
    }

    //______________________________________________

    /**
     * pré-requis : t1.length = t2.length
     * résultat : vrai ssi t1 et t2 contiennent la même suite d'entiers
     */
    public static boolean sontEgaux(int[] t1, int[] t2) {

        for (int i = 0; i < t1.length; i++) {
            if (t1[i] != t2[i]) {
                return false;
            }
        }
        return true;

    }

    //______________________________________________

    // Dans toutes les fonctions suivantes, on a comme prérequis implicites sur les paramètres lgCode, nbCouleurs et tabCouleurs :
    // lgCode > 0, nbCouleurs > 0, tabCouleurs.length > 0 et les éléments de tabCouleurs sont différents.

    // fonctions sur les codes pour la manche Humain

    /**
     * pré-requis : aucun
     * résultat : un tableau de lgCode entiers choisis aléatoirement entre 0 et nbCouleurs-1
     */
    public static Code codeAleat(int lgCode, int nbCouleurs) {

        Code tab = new Code(lgCode);

        for (int i = 0; i < lgCode; i++) {
            Random rn = new Random();
            int r = rn.nextInt(nbCouleurs);
            tab.setCode(i,r);
        }

        return tab;

    }

    //____________________________________________________________

    /**
     * pré-requis : aucun.
     * Action : si codMot n'est pas correct, affiche pourquoi
     * résultat : vrai ssi codMot est correct, c'est-à-dire de longueur lgCode et ne contenant que des éléments de tabCouleurs
     */
    public static boolean codeCorrect(String codMot, int lgCode, char[] tabCouleurs) {

        if (codMot.length() != lgCode) {
            System.out.println("Votre mot n'est pas de la bonne longueur.");
            return false;
        } else {
            for (int i = 0; i < codMot.length(); i++) {
                //on va chercher la fonction estPresent pour savoir si le mot est correct
                boolean est_present = estPresent(tabCouleurs, codMot.charAt(i));
                if (!est_present) {
                    System.out.println("La lettre  " + i + " de votre mot n'est pas bonne.");
                    return false;
                }
            }
        }
        return true;

    }

    //____________________________________________________________

    /**
     * prérequis : les caractères de codMot sont des éléments de tabCouleurs
     * résultat : le code codMot sous forme de tableau d'entiers en remplaçant chaque couleur par son indice dans tabCouleurs
     */
    public static Code motVersEntiers(String codMot, char[] tabCouleurs) {

        Code tab = new Code(codMot.length());

        // on cherche l'indice grâce à la 3° fonction plusGrandIndice et on la met dans le tableau final
        for (int i = 0; i < codMot.length(); i++) {
            tab.setCode(i,plusGrandIndice(tabCouleurs, codMot.charAt(i)));
        }

        return tab;

    }

    //____________________________________________________________

    /**
     * pré-requis : aucun.
     * action : demande au joueur humain de saisir la (nbCoups + 1)ème proposition de code sous forme de mot, avec re-saisie éventuelle jusqu'à ce
     * qu'elle soit correcte (le paramètre nbCoups ne sert que pour l'affichage)
     * résultat : le code saisi sous forme de tableau d'entiers
     */
    public static Code propositionCodeHumain(int nbCoups, int lgCode, char[] tabCouleurs) {

        // on demande la saisie*
        System.out.println("\n------------------------------\n");
        System.out.println("Vous êtes a l'essai n° "+nbCoups);
        System.out.println("\n------------------------------\n");
        System.out.println("Veuillez saisir votre Code couleur : ");
        Scanner myObj4 = new Scanner(System.in);
        String demande = myObj4.nextLine();
        System.out.println("\n------------------------------\n");

        // tant que la saisie n'est pas bonne on redemande
        while (!codeCorrect(demande, lgCode, tabCouleurs)) {
            System.out.println("\n------------------------------\n");
            System.out.println("Votre saisie n'est pas correcte");
            System.out.println("Veuillez saisir votre Code couleur : ");
            myObj4 = new Scanner(System.in);
            demande = myObj4.nextLine();
            System.out.println("\n------------------------------\n");


        }

        //on retourne le code sous forme de tableau d'entier (grâce à la fonction motVersEntiers
        return motVersEntiers(demande, tabCouleurs);

    }

    //____________________________________________________________

    /**
     * pré-requis : cod1.length = cod2.length
     * résultat : le nombre d'éléments communs de cod1 et cod2 se trouvant au même indice
     * Par exemple, si cod1 = (1,0,2,0) et cod2 = (0,1,0,0) la fonction retourne 1 (le "0" à l'indice 3)
     */
    public static int nbBienPlaces(Code cod1, Code cod2) {

        int compteur = 0;

        for (int i = 0; i < cod1.getLgCode(); i++) {
            if (cod1.getCode(i) == cod2.getCode(i)) {
                compteur++;
            }

        }

        return compteur;

    }

    //____________________________________________________________

    /**
     * prérequis : les éléments de cod sont des entiers de 0 à nbCouleurs-1
     * résultat : un tableau de longueur nbCouleurs contenant à chaque indice i le nombre d'occurrences de "i" dans cod
     * Par exemple, si cod = (1,0,2,0) et nbCouleurs = 6 la fonction retourne (2,1,1,0,0,0)
     */
    public static Code tabFrequence(Code cod, int nbCouleurs) {

        Code freq = new Code(nbCouleurs);

        // pour chaque valeur de cod, on prend cette valeur qui correspond donc à l'indice du tableau freq et on ajoute 1
        for(int i = 0; i < cod.getLgCode(); i++) {
            freq.setCode(cod.getCode(i),freq.getCode(i)+1);
        }
        return freq;
    }

    //____________________________________________________________

    /**
     * pré-requis : les éléments de cod1 et cod2 sont des entiers de 0 à nbCouleurs-1
     * résultat : le nombre d'éléments communs de cod1 et cod2, indépendamment de leur position
     * Par exemple, si cod1 = (1,0,2,0) et cod2 = (0,1,0,0) la fonction retourne 3 (2 "0" et 1 "1")
     */
    public static int nbCommuns(Code cod1, Code cod2, int nbCouleurs) {
        Code freqCod1 = tabFrequence(cod1, nbCouleurs);
        Code freqCod2 = tabFrequence(cod2, nbCouleurs);
        int nbCommuns = 0;
        for (int i = 0; i < nbCouleurs; i++) {
            if (freqCod1.getCode(i) < freqCod2.getCode(i)) {
                nbCommuns += freqCod1.getCode(i);
            } else {
                nbCommuns += freqCod2.getCode(i);
            }
        }
        return nbCommuns - nbBienPlaces(cod1, cod2);
    }

    //____________________________________________________________

    /**
     * pré-requis : cod1.length = cod2.length et les éléments de cod1 et cod2 sont des entiers de 0 à nbCouleurs-1
     * résultat : un tableau de 2 entiers contenant à l'indice 0 (resp. 1) le nombre d'éléments communs de cod1 et cod2
     * se trouvant  (resp. ne se trouvant pas) au même indice
     * Par exemple, si cod1 = (1,0,2,0) et cod2 = (0,1,0,0) la fonction retourne (1,2) : 1 bien placé (le "0" à l'indice 3)
     * et 2 mal placés (1 "0" et 1 "1")
     */
    public static int[] nbBienMalPlaces(Code cod1,Code cod2, int nbCouleurs) {
        int nbBienPlaces = nbBienPlaces(cod1, cod2);
        int nbCommuns = nbCommuns(cod1, cod2, nbCouleurs);
        return new int[]{nbBienPlaces,nbCommuns};
    }



    //____________________________________________________________

    //...................................................................
    // FONCTIONS COMPLÉMENTAIRES SUR LES CODES POUR LA MANCHE ORDINATEUR
    //...................................................................

    /**
     * pré-requis : les éléments de cod sont des entiers de 0 à tabCouleurs.length-1
     * résultat : le code cod sous forme de mot d'après le tableau tabCouleurs
     */
    public static String entiersVersMot(Code cod, char[] tabCouleurs) {
        String codMot = "";
        for (int i = 0; i < cod.getLgCode(); i++) {
            codMot += tabCouleurs[cod.getCode(i)];
        }
        return codMot;
    }

    //___________________________________________________________________

    /**
     * pré-requis : rep.length = 2
     * action : si rep n'est pas  correcte, affiche pourquoi, sachant que rep[0] et rep[1] sont
     * les nombres de bien et mal placés resp.
     * résultat : vrai ssi rep est correct, c'est-à-dire rep[0] et rep[1] sont >= 0 et leur somme est <= lgCode
     */
    public static boolean repCorrecte(int[] rep, int lgCode) {
        if (rep.length != 2) return false;
        else if (rep[0] < 0) {
            System.out.println("Vous ne pouvez pas donner un nombre négatif de couleurs bien placées : ");
            System.out.println("\n------------------------------\n");
            return false;
        } else if (rep[1] < 0) {
            System.out.println("Vous ne pouvez pas donner un nombre négatif de couleurs mal placées : ");
            System.out.println("\n------------------------------\n");
            return false;
        } else if (rep[0] + rep[1] > lgCode) {
            System.out.println("Vos deux nombres ne doivent pas dépasser la longueur du code : ");
            System.out.println("\n------------------------------\n");
            return false;
        } else return true;
    }


    //___________________________________________________________________

    /**
     * pré-requis : aucun
     * action : demande au joueur humain de saisir les nombres de bien et mal placés,
     * avec re-saisie éventuelle jusqu'à ce qu'elle soit correcte
     * résultat : les réponses du joueur humain dans un tableau à 2 entiers
     */
    public static int[] reponseHumain(int lgCode) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Donnez le nombre de couleur(s) bien placée(s) : ");
        int nbBienplaces = scn.nextInt();
        System.out.println("\n------------------------------\n");
        System.out.println("Donnez le nombre de couleur(s) mal placée(s) : ");
        int nbMalplaces = scn.nextInt();
        System.out.println("\n------------------------------\n");
        int[] rep = {nbBienplaces, nbMalplaces};
        while (!repCorrecte(rep, lgCode)) {
            System.out.println("Donnez le nombre de couleur(s) bien placée(s) : ");
            nbBienplaces = scn.nextInt();
            System.out.println("\n------------------------------\n");
            System.out.println("Donnez le nombres de couleur(s) mal placée(s) : ");
            nbMalplaces = scn.nextInt();
            System.out.println("\n------------------------------\n");
            rep[0] = nbBienplaces;
            rep[1] = nbMalplaces;
        }
        return rep;
    }

    //___________________________________________________________________

    /**CHANGE : action si le code suivant n'existe pas
     *************************************************
     pré-requis : les éléments de cod1 sont des entiers de 0 à nbCouleurs-1
     action/résultat : met dans cod1 le code qui le suit selon l'ordre lexicographique (dans l'ensemble
     des codes à valeurs  de 0 à nbCouleurs-1) et retourne vrai si ce code existe,
     sinon met dans cod1 le code ne contenant que des "0" et retourne faux
     */
    public static boolean passeCodeSuivantLexico(Code cod1, int nbCouleurs) {

        for (int i = cod1.getLgCode() - 1; i >= 0; i--) {
            if (cod1.getCode(i) < nbCouleurs - 1) {
                cod1.setCode(i,cod1.getCode(i)+1);
                return true;
            } else if (cod1.getCode(i) == nbCouleurs - 1) {
                cod1.setCode(i,0);
            } else {
                for (int j = 0; j < cod1.getLgCode(); j++) {
                    cod1.setCode(j,0);
                }
                return false;
            }
        }
        for (int j = 0; j < cod1.getLgCode(); j++) {
            cod1.setCode(j,0);
        }
        return false;
    }

    //___________________________________________________________________

    /**CHANGE : ajout du paramètre cod1 et modification des spécifications
     *********************************************************************
     pré-requis : cod est une matrice à cod1.length colonnes, rep est une matrice à 2 colonnes, 0 <= nbCoups < cod.length,
     nbCoups < rep.length et les éléments de cod1 et de cod sont des entiers de 0 à nbCouleurs-1
     résultat : vrai ssi cod1 est compatible avec les nbCoups premières lignes de cod et de rep,
     c'est-à-dire que si cod1 était le code secret, les réponses aux nbCoups premières
     propositions de cod seraient les nbCoups premières réponses de rep resp.
     */

    public static boolean estCompat(Code cod1, Code[] cod,int [][] rep, int nbCoups, int  nbCouleurs){

        for (int i = 0; i < nbCoups; i++) {

            int[] nbBienMalPlaces = nbBienMalPlaces(cod[i], cod1, nbCouleurs);
            if (!sontEgaux(nbBienMalPlaces, rep[i])) {
                return false;
            }
        }

        return true;
    }

    //___________________________________________________________________

    /**CHANGE : renommage de passePropSuivante en passeCodeSuivantLexicoCompat,
     ajout du paramètre cod1 et modification des spécifications
     **************************************************************************
     pré-requis : cod est une matrice à cod1.length colonnes, rep est une matrice à 2 colonnes, 0 <= nbCoups < cod.length,
     nbCoups < rep.length et les éléments de cod1 et de cod sont des entiers de 0 à nbCouleurs-1
     action/résultat : met dans cod1 le plus petit code (selon l'ordre lexicographique (dans l'ensemble
     des codes à valeurs  de 0 à nbCouleurs-1) qui est à la fois plus grand que
     cod1 selon cet ordre et compatible avec les nbCoups premières lignes de cod et rep si ce code existe,
     sinon met dans cod1 le code ne contenant que des "0" et retourne faux
     */
    public static boolean passeCodeSuivantLexicoCompat(Code cod1, Code[] cod,int [][] rep, int nbCoups, int  nbCouleurs){
        cod[nbCoups] = copieTab(cod[nbCoups - 1]);

        while (passeCodeSuivantLexico(cod[nbCoups], nbCouleurs)) {
            if (estCompat(cod1, cod, rep, nbCoups, nbCouleurs)) {
                return true;
            }
        }
        return false;

    }


    public static int saisirEntierPositif() {

        System.out.println("Veuillez saisir un entier positif :");
        Scanner scan = new Scanner(System.in);
        int demande = scan.nextInt();
        System.out.println("\n------------------------------\n");

        // tant que la saisie n'est pas bonne on redemande
        while (demande < 1) {
            System.out.println("Votre saisie n'est pas correcte. Veuillez saisir un entier positif :");
            scan = new Scanner(System.in);
            demande = scan.nextInt();
            System.out.println("\n------------------------------\n");

        }
        return demande;
    }

    //___________________________________________________________________

    /**
     * pré-requis : aucun
     * action : demande au joueur humain de saisir un entier pair strictement positif,
     * avec re-saisie éventuelle jusqu'à ce qu'elle soit correcte
     * résultat : l'entier pair strictement positif saisi
     */
    public static int saisirEntierPairPositif() {

        System.out.println("Veuillez saisir un entier positif pair :");
        Scanner scan = new Scanner(System.in);
        int demande = scan.nextInt();
        System.out.println("\n------------------------------\n");

        // tant que la saisie n'est pas bonne on redemande
        while (demande < 1 || demande % 2 == 1) {
            System.out.println("Votre saisie n'est pas correcte. Veuillez saisir un entier positif pair :");
            scan = new Scanner(System.in);
            demande = scan.nextInt();
            System.out.println("\n------------------------------\n");

        }
        return demande;
    }


    //___________________________________________________________________

    /**
     * pré-requis : aucun
     * action : demande au joueur humain de saisir le nombre de couleurs (stricement positif),
     * puis les noms de couleurs aux initiales différentes,
     * avec re-saisie éventuelle jusqu'à ce qu'elle soit correcte
     * résultat : le tableau des initiales des noms de couleurs saisis
     */
    public static char[] saisirCouleurs() {

        System.out.println("Combien de couleurs Voulez-vous ?");
        int nbCOuleurs = saisirEntierPositif();
        System.out.println("Veuillez rentrer les initiales des couleurs.");
        char[] couleurs = new char[nbCOuleurs];
        Scanner myObj4 = new Scanner(System.in);
        String demande = myObj4.nextLine();

        for (int i = 0; i < demande.length(); i++) {
            couleurs[i] = demande.charAt(i);
        }

        while (!elemDiff(couleurs) || !demande.equals(demande.toUpperCase())){
            if(!elemDiff(couleurs)) {
                System.out.println("Il y a eu des doublons, veuillez les supprimer.");
            }else{
                System.out.println("Les lettres ne sont pas en majuscule.");
            }
            System.out.println("Veuillez rentrer les initiales des couleurs.");
            myObj4 = new Scanner(System.in);
            demande = myObj4.nextLine();
            System.out.println("\n------------------------------\n");

            for (int i = 0; i < demande.length(); i++) {
                couleurs[i] = demande.charAt(i);
            }
        }

        return couleurs;

    }

}
