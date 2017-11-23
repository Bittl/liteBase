package emploees;

import javax.swing.*;
import java.awt.*;

public class MainEmployees extends JInternalFrame {

    public MainEmployees(){
        super("Сотрудники", true,true, true, true);
        setSize(200, 200);

        JPanel buttonPanel = new JPanel();
//        buttonPanel.set

        JButton buttonAdd = new JButton("Добавить");
        JButton buttonEdit = new JButton("Изменить");
        JButton buttonDelete = new JButton("Удалить");

        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonEdit);
        buttonPanel.add(buttonDelete);




        JPanel tablePanel = new JPanel();


        add(buttonPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        setVisible(true);

    }

}
