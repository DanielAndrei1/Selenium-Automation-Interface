package image;
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel
{
    protected Image Image;

    public ImagePanel()
    {
        this.Image =
                new ImageIcon(getClass().getResource("/image/computer.jpg")).getImage();
        setLayout(new BorderLayout());
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(Image, -900, -800, null);
    }
}
