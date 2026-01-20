package blackjack.view;

import blackjack.model.jeu.JeuBlackjack;
import cartes.model.Paquet;
import cartes.model.observer.EcouteurModele;
import cartes.view.VuePaquetVisible;
import java.awt.Color;

public class VueMainJoueur extends VuePaquetVisible implements EcouteurModele {

    private final JeuBlackjack jeu;

    public VueMainJoueur(JeuBlackjack jeu) {
        // On initialise avec la première main du joueur
        super(jeu.getJoueur().getMain());
        this.jeu = jeu;
        
        // On s'abonne aux changements pour que la vue se mette à jour toute seule
        this.jeu.ajoutEcouteur(this);

        // Transparence pour voir le tapis vert derrière les cartes
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }

    /**
     * Méthode appelée quand le modèle change (Tirer, Splitter, etc.)
     * C'est ici qu'on gère l'affichage dynamique pour le SPLIT.
     */
    @Override
    public void modeleMisAJour(Object source) {
        // 1. On demande au jeu : "Quelle est la main active maintenant ?"
        // (Important pour le Split : ça peut être la main 1 ou la main 2)
        Paquet mainActive = jeu.getJoueur().getMain();
        
        // 2. On dit à la vue (librairie cartes) de changer de cible
        setPaquet(mainActive);
        
        // 3. On redessine tout
        repaint();
    }

    @Override
    public void setPaquet(Paquet paquet) {
        super.setPaquet(paquet); 
        repaint();
    }
    
    // Getter utile pour le contrôleur si besoin
    public JeuBlackjack getJeu() {
        return jeu;
    }
}