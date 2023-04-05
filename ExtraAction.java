import java.awt.Graphics2D;
public interface ExtraAction {
   
    void draw(Graphics2D graphics);
    boolean isUsed();
    boolean doesItMove();
    void reset();



}
/*+void draw(Graphics2D graphics)
draws the ExtraAction
+boolean isUsed()
returns isUsed
+boolean doesItMove()
returns doesItMove
+void reset()
makes isUsed false
 */
