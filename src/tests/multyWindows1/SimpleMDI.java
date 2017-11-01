package tests.multyWindows1;

import javax.swing.*;

public class SimpleMDI extends JFrame {

    public SimpleMDI(){

        super("SimpleMDI");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JDesktopPane desktopPane = new JDesktopPane();
        add(desktopPane);

        JInternalFrame frame1 = new JInternalFrame("window 1", true);
        JInternalFrame frame2 = new JInternalFrame("window 2", true, true, true, true);
        JInternalFrame frame3 = new JInternalFrame("Palitrs", false, true);

        frame3.putClientProperty("JIternalFrame.isPallette", true);

        desktopPane.add(frame1);
        desktopPane.add(frame2);
        desktopPane.add(frame3);

        frame1.setSize(200, 100);
        frame1.setLocation(80, 100);
        frame1.setVisible(true);
        frame2.setSize(200, 60);
        frame2.setVisible(true);
        frame3.setSize(100, 200);
        frame3.setVisible(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleMDI();
            }
        });
    }


}
