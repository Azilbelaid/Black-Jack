package blackjack.view;

import blackjack.model.jeu.JeuBlackjack;
import blackjack.model.proxy.MainCroupierProxy;
import cartes.model.Carte;
import cartes.model.observer.EcouteurModele;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Vue graphique de la main du croupier.
 * Affiche la première carte cachée et le reste face visible,
 * mais révèle toutes les cartes quand le croupier commence à jouer.
 */
public class VueMainCroupier extends JPanel implements EcouteurModele {

    private final JeuBlackjack jeu;
    private final MainCroupierProxy proxy;

    private static final int LARGEUR_CARTE = 80;
    private static final int HAUTEUR_CARTE = 120;
    private static final int ESPACEMENT = 90;

    public VueMainCroupier(JeuBlackjack jeu) {
        this.jeu = jeu;
        this.proxy = new MainCroupierProxy(jeu.getCroupier());
        this.jeu.ajoutEcouteur(this);

        setPreferredSize(new Dimension(600, 150));
    }

    /** Méthode à appeler quand le croupier commence à jouer */
    public void revelerCartes() {
        proxy.revelerCartes(); // toutes les cartes deviennent visibles
        repaint();             // force la mise à jour graphique
    }

    /** Réinitialiser la vue pour une nouvelle partie (cacher la première carte) */
    public void cacherPremiereCarte() {
        proxy.cacherPremiereCarte();
        repaint();
    }

    @Override
    public void modeleMisAJour(Object source) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<Carte> visibles = proxy.getCartesVisibles(); // récupère selon état du proxy
        int totalCartes = jeu.getCroupier().getMain().taille();

        int x = 10;

        // 2️⃣ Cartes cachées
        int cartesCachees = totalCartes - visibles.size();
        for (int i = 0; i < cartesCachees; i++) {
            g.setColor(new Color(20, 60, 20)); // couleur du dos de carte
            g.fillRoundRect(x, 20, LARGEUR_CARTE, HAUTEUR_CARTE, 12, 12);

            g.setColor(Color.BLACK);
            g.drawRoundRect(x, 20, LARGEUR_CARTE, HAUTEUR_CARTE, 12, 12);

            x += ESPACEMENT;
        }

        // 1️⃣ Cartes visibles
        for (Carte c : visibles) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(x, 20, LARGEUR_CARTE, HAUTEUR_CARTE, 12, 12);

            g.setColor(Color.BLACK);
            g.drawRoundRect(x, 20, LARGEUR_CARTE, HAUTEUR_CARTE, 12, 12);

            String symbole = switch (c.getCouleur()) {
                case "pique" -> "♠";
                case "cœur" -> "♥";
                case "carreau" -> "♦";
                default -> "♣";
            };

            Color color = (c.getCouleur().equals("cœur") || c.getCouleur().equals("carreau"))
                    ? Color.RED : Color.BLACK;
            g.setColor(color);

            g.setFont(new Font("SansSerif", Font.BOLD, 16));
            g.drawString(c.getHauteur(), x + 10, 50);
            g.drawString(symbole, x + 10, 90);

            x += ESPACEMENT;
        }
    }
}
