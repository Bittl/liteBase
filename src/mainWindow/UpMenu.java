package mainWindow;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpMenu extends JMenuBar {

    public UpMenu(){
        add(createFileMenu());
        add(createTablesMenu());
    }

    private JMenu createFileMenu(){
        JMenu file = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem exit = new JMenuItem(new ExitAction());

        file.add(open);
        file.addSeparator();
        file.add(exit);

        return file;
    }

    private JMenu createTablesMenu(){
        JMenu tablesMenu = new JMenu("Таблицы");

        JMenuItem emploees = new JMenuItem("Сотрудники");
        tablesMenu.add(emploees);
        tablesMenu.addSeparator();

        return tablesMenu;
    }

    class ExitAction extends AbstractAction{

        ExitAction(){
            putValue(NAME, "Выход");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
