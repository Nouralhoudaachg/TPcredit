package jdbc;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        String url="jdbc::mysql://loclahost:3306/bankati",
                username= "root",
                password="noursql@1";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        ResultSetMetaData resultMetaData=null;
       // PreparedStatement ps=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Chargement du Driver JDBC pour MySql reussi ^_^");
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connexion établit à la BD bankati");
            //Creation d'un objet statement
            statement=connection.createStatement();
            //ps=connection.prepareStatement("SELECT c.id,c.capital_emprinte,c.nbrmois,c.taux_mensuel,c.nom_demandeur,c.mensualite from Credit c WHERE c.id=?");
            //resultSet=ps.executeQuery();
            //L'objet ResultSet contient le resultat de la requete SQL
            resultSet=statement.executeQuery("SELECT c.id,c.capital_emprinte,c.nbrmois,c.taux_mensuel,c.nom_demandeur,c.mensualite from Credit c ");
            //On recupere les MetaData
            resultMetaData=resultSet.getMetaData();
            //ORM
            System.out.println("\n-----------------");
            while(resultSet.next()){
                for(int i=1;i <= resultMetaData.getColumnCount();i++)
                    System.out.println("\t"+resultMetaData.getColumnName(i).toUpperCase()+":"+resultSet.getObject(i).toString()+"\t");
                System.out.println("\n-----------------");//fin ORM

            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Fermeture des objets de connexion(recommandée)
        finally {
            if(connection!=null){
                try{
                    connection.close();

                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(statement !=null){
                try{
                    statement.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(resultSet !=null){
                try{
                    resultSet.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }

    }

}


