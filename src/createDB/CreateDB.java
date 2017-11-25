package createDB;

import dbConnect.DBConnect;

import java.sql.SQLException;

public class CreateDB {

    public CreateDB(String name){
        name = name + ".base";
        try {

            DBConnect.connect(name);
        } catch (SQLException e) {
            DBConnect.create(name);
        }


    }

    /**
     * Создаём базу, на вход полный путь к базе.
     * @param db
     */

    public static void createDatabase(String db){
        db = db + ".base";
        try {

            DBConnect.connect(db);
        } catch (SQLException e) {
            DBConnect.create(db);
        }
    }

    /**
     * создаём таблицу "Сотрудники"
     * на вход принимаем имя таблицы
     * @param table
     */
    public static void createEmployees(String table){

    }

}
