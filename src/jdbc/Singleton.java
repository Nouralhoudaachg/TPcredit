package jdbc;

import java.sql.*;

public class Singleton {
    private static Connection connection;

    private Singleton(){
        String url="jdbc::mysql://loclahost:3306/bankati",
                userName="root",
                password="noursql@1",
                driver="com.mysql.cj.jdbc.Driver";
        try{
                Class.forName(driver);
                connection= DriverManager.getConnection(url,userName,password);
            System.out.println("Creation de l'instance connexion reussite ^_^ ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Methode qui va retourner notre instance et la creer si elle n'existe pas

    public static  Connection getConnection(){
        if(connection ==null) new Singleton();
        else
            System.out.println("Appel à l'instance de connexion existante");
        return  connection;
    }

    public static void main(String[] args) {
        try{
            PreparedStatement ps=getConnection().prepareStatement("SELECT * FROM Credit WHERE id=?");
            Statement state= getConnection().createStatement();
            getConnection().setAutoCommit(false);
            DatabaseMetaData meta=getConnection().getMetaData();


        }
        catch(SQLException e){
            e.printStackTrace();

        }
    }

}
