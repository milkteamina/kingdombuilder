import javax.swing.JFrame;

public class Frame extends JFrame {
    
    private static final int width = 1200;
    private static final int height = 650;
    public Frame(String framename)
{
    super(framename);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(width, height);
    setVisible(true);
    add(new Panel());
    setVisible(true);
}


}