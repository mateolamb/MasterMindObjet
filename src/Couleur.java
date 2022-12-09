public class Couleur {

    private static char[] tabCouleurs;

    public static void rentrerCouleurs(char[] tab) {
        tabCouleurs = tab;
    }

    public static char[] getTabCouleurs() {
        return tabCouleurs;
    }

    public static int getTaille() {
        return tabCouleurs.length;
    }

    public static String pourEcrire() {
        String str = "";

        str += "(" + tabCouleurs[0];

        for (int i = 1; i < tabCouleurs.length; i++) {
            str += "," + tabCouleurs[i];
        }
        str += ")";
        return str;
    }
}