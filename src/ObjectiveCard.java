import java.awt.Graphics;

public interface ObjectiveCard {
    void scorePlayer(Board board, Player player);
    void draw(Graphics g);
}
