package createDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelestDB extends JDialog {

    public SelestDB(JFrame frame){

        super(frame, "Базы данных");
        setSize(300, 300);
        setLayout(new GridLayout(3, 1));


        JPanel createPanel = new JPanel();
        createPanel.setLayout(new BoxLayout(createPanel, BoxLayout.Y_AXIS));
        JLabel createPanelLabel = new JLabel("Создать БД");
        JTextField createField = new JTextField(100);
        JButton createButton = new JButton("Создать");
        createPanel.add(createPanelLabel);
        createPanel.add(createField);
        createPanel.add(createButton);
        add(createPanel);
//        add(new JSeparator());

        JPanel openPanel = new JPanel();
        openPanel.setLayout(new BoxLayout(openPanel, BoxLayout.Y_AXIS));
        JLabel openLabel = new JLabel("Открыть БД");
        JTextField openField = new JTextField(100);
        JButton openPath = new JButton("поиск");
        openPanel.add(openLabel);
        openPanel.add(openLabel);
        openPanel.add(openField);
        openPanel.add(openPath);
        add(openPanel);
//        add(new JSeparator());

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        final JDialog[] sdb = {null};



        JButton button = new JButton("button");
        button.setSize(20, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sdb[0] == null){
                    sdb[0] = new SelestDB(frame);
                }
                sdb[0].setVisible(true);
            }
        });

        frame.add(button);


        frame.setVisible(true);

    }
}
