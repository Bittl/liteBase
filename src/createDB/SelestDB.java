package createDB;

import javax.swing.*;
import java.awt.*;

public class SelestDB extends JDialog {

    public SelestDB(JFrame frame){

        super(frame, "Базы данных");
        setSize(300, 300);
        setLayout(new GridLayout(5, 1));


        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(4, 1));
        JLabel createPanelLabel = new JLabel("Создать БД");
        JTextField createField = new JTextField(100);
        JButton createButton = new JButton("Создать");
        createPanel.add(createPanelLabel);
        createPanel.add(createField);
        createPanel.add(createButton);
        add(createPanel);
        add(new JSeparator());

        JPanel openPanel = new JPanel();
        openPanel.setLayout(new GridLayout(3, 2));
        JLabel openLabel = new JLabel("Открыть БД");
        JTextField openField = new JTextField(100);
        JButton openPath = new JButton("поиск");
        openPanel.add(openLabel);
        openPanel.add(openLabel);
        openPanel.add(openField);
        openPanel.add(openPath);
        add(openPanel);
        add(new JSeparator());

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel);


    }
}
