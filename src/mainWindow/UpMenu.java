package mainWindow;


import createDB.SelestDB;
import emploees.MainEmployees;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpMenu extends JMenuBar {

    JDesktopPane desktopPane;
    JDialog about = null;
    JDialog database = null;
    JFrame frame = null;


    public UpMenu(JDesktopPane desktopPane, JFrame frame){
        this.desktopPane = desktopPane;
        this.frame = frame;
        add(createFileMenu());
        add(createTablesMenu());
        add(createSettingsMenu());
        add(createHelpMenu());
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

        emploees.addActionListener(new OpenEmploee());

        return tablesMenu;
    }

    private JMenu createSettingsMenu(){
        JMenu settingsMenu = new JMenu("Настройки");
        JMenuItem dataBase = new JMenuItem("База данных");
        settingsMenu.add(dataBase);
        settingsMenu.addSeparator();
        dataBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (database == null){
                    database = new SelestDB(frame);
                }
                database.setVisible(true);
            }
        });

        return settingsMenu;
    }

    private JMenu createHelpMenu(){
        JMenu helpMenu = new JMenu("Помощь");
        JMenuItem aboutProgram = new JMenuItem("О программе");
        helpMenu.add(aboutProgram);
        helpMenu.addSeparator();
        aboutProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (about == null){
                    about = new AboutProgram(frame);
                }
                about.setVisible(true);
            }
        });

        return helpMenu;
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

    class OpenEmploee extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            desktopPane.add(new MainEmployees());
        }
    }

//    class OpenAbout extends AbstractAction{
//
//        JDialog dialog;
//
//        public OpenAbout(JDialog dialog){
//            this.dialog = dialog;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//           dialog.setVisible(true);
//        }
//    }

}
