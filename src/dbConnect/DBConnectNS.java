package dbConnect;

import java.sql.*;

public class DBConnectNS {


    /**
     * создание глобальных переменных
     */

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String reqest;
    private String[] columnNames;
    private int countColls;
    private int countRows;

    /**
     * Конструктор для подключения к БД
     * На вход получает адрес (полный адрес с именем файла и расширения) БД
     * Исключение добавлено в сигнатуру для перехвата в программе и создания новой БД
     * Класс вспомогательный
     * @param address
     */

    public DBConnectNS (String address )throws SQLException {
        String connectAddress = "jdbc:sqlite:"+ address;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectAddress);
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для подключения к БД, создаёт подключение к БД. То же что и конструктор.
     * На вход получает адрес (полный адрес с именем файла и расширения) БД
     * Исключение добавлено в сигнатуру для перехвата в программе и создания новой БД
     * Класс вспомогательный
     * @param address
     */

    public void connect(String address) throws SQLException {

        String connectAddress = "jdbc:sqlite:"+ address;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(connectAddress);
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * создание бд при её отсутствии.
     * на вход принимает полный адрес БД с именем и расширением
     * исключения не в сигнатуре.
     * @param create
     */

    public synchronized void create (String create){
        try {
            statement.execute(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * запись Строк в таблицу с помощью SQL запросов
     * на вход принимает готовый SQL запрос
     * @param reqest
     */

    public synchronized void write(String reqest){
        try {
            statement.execute(reqest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * возвращает готовый массив строк для таблицы
     * на вход принимает название таблицы
     * Исключение в сигнатуре на случай отсутствия таблицы (что надо ещё проверить)
     * @param tableName
     * @return
     * @throws SQLException
     */

    public synchronized String [][] read (String tableName) throws SQLException{

        String sql = "SELECT * FROM " + tableName;
        int countRows;
        String[][] data = null;

        resultSet = statement.executeQuery(sql);
        countColls = resultSet.getMetaData().getColumnCount();
        columnNames = new String[countColls];
        countRows = 0;
        for (int i = 0; i < countColls; i++) {
            columnNames[i] = resultSet.getMetaData().getColumnName(i + 1);
        }

        while (resultSet.next()){
            countRows++;
        }

        resultSet.close();

        resultSet = statement.executeQuery(sql);
        data = new String[countRows][countColls];
        int a = 0;

        while (resultSet.next()){
            for (int i = 0; i < countColls; i++) {
                data[a][i] = resultSet.getString(columnNames[i]);
            }
        }

        resultSet.close();

        return data;
    }

    /**
     * просто закрытие работы с БД для очистки памяти
     */

    public synchronized void closeDB(){
        try{
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * метод, возвращающий количество колонок (НЕ РАБОТАЕТ БЕЗ МЕТОДА read()!!!!!!!!!)
     * @return
     */

    public synchronized int getColls(){
        return countColls;
    }

    /**
     * метод, возвращающий количество строк (НЕ РАБОТАЕТ БЕЗ МЕТОДА read()!!!!!!!!!)
     * @return
     */

    public synchronized int getRows(){
        return countRows;
    }

    /**
     * Возвращает имена всех столбцов таблицы, так как они представлены в БД
     * На вход Имя таблицы
     * @param tableName
     * @return
     */

    public synchronized String[] getCollsNames(String tableName){
        String sql = "SELECT * FROM " + tableName;
        String names[] = null;
        try{
            resultSet = statement.executeQuery(sql);
            names = new String[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < names.length; i++) {
                names[i] = resultSet.getMetaData().getColumnLabel(i+1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return names;
    }

    /**
     * на вход принимается номер строки, которая выделена в данный момент
     * возвращает массив строк.
     * @param rowId
     * @param tableName
     * @return
     */

    public synchronized String[] getRow(int rowId, String tableName){
        String sql = "SELECT * FROM " + tableName + " WHERE ID =" + rowId +";";
        String [] rowData = null;
        try{
            resultSet = statement.executeQuery(sql);
            rowData = new String[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < rowData.length; i++) {
                rowData[i] = resultSet.getString(i+1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return rowData;
    }


}
