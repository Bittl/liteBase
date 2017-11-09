package mainWindow;

import javax.swing.*;
import java.awt.*;

public class AboutProgram extends JDialog {

    public AboutProgram(JFrame frame){
        super(frame,"О программе", true );
//        setModal(true);
//        setTitle("О программе");
        setSize(200, 200);
        setLayout(new GridLayout(3, 1));
        add(new JLabel("Версия: 0.0.0.1"));
//        add(new JLabel("Версия: 0.0.0.1" + "\n" + "\"ИТЕРАЭЛЬ\"" + "\n" + "Разработка: Роман Егоров"));
        add(new JLabel("\"ИТЕРАЭЛЬ\""));
        add(new JLabel("Разработка: Роман Егоров"));


    }


}
