package mainWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();


    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize((int)(dimension.width/1.3), (int)(dimension.height/1.3));
        JDesktopPane desktopPane = new JDesktopPane();
        JMenuBar upMenu = new UpMenu(desktopPane);


        add(desktopPane);


        setJMenuBar(upMenu);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }


}
