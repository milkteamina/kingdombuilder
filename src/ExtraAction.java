import java.awt.Graphics;

public interface ExtraAction {

    void draw(Graphics g);
    boolean isUsed();
    boolean doesItMove();
    void reset();

}
