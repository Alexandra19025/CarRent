package gui;

import javax.swing.*;
import java.awt.*;

public class ImageViewerForCars extends JFrame {
    private JFrame frame;

    public ImageViewerForCars() {
        makeFrame();
    }
    private void makeFrame() {
        frame = new JFrame("Cars");
        Container contentPane = frame.getContentPane();

        JLabel label = new JLabel("Cars");
        contentPane.add(label);

        pack();
        setVisible(true);



    }
}
