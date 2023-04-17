import java.awt.Graphics;

public interface ExtraAction{

    static final int sizeX = 30;
    static final int sizeY = 39;

    void draw(Graphics g);
    boolean isUsed();
    boolean doesItMove();
    void reset();
    boolean isClicked(int mouseX, int mouseY);
    ExtraAction copy();
    void setAvailableMoves(Board b, Player p, Hex h);


}
