public class Couleur {
    
    private static char[] tabCouleurs;

    public static char getCouleur(int i){
        return tabCouleurs[i];
    }

    public static char[] getTabCouleurs() {
        return tabCouleurs;
    }

    public static int getTaille(){
        return tabCouleurs.length;
    }
}