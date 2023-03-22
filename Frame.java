import javax.swing.JFrame;

public class Frame extends JFrame {
    private static final int width = 1000;
    private static final int height = 400;
    public Frame(String framename)
{
    super(framename);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(width, height);
    setVisible(true);
}


}
