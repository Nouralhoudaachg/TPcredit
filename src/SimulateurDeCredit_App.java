import Modele.Credit;
import dao.CreditDao;
import dao.IDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.CreditControleur;
import presentation.IControleur;
import service.CreditMetier;
import service.IMetier;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class SimulateurDeCredit_App {

    static Scanner clavier= new Scanner(System.in);
    //test2
    static IControleur creditControleur;

    private static boolean  estUnNombre(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        public static void test1(){
            //instanciation des differentes composantes de l'application

            var dao= new CreditDao();
            var metier= new CreditMetier();
            var controleur= new CreditControleur();

            //injection des dependances

            metier.setCreditDao(dao);
            controleur.setCreditMetier(metier);

            //tester
            String rep="";
            do{
                System.out.println("=> [Test 1 ] Calcul de mensualité de crédit <=\n");
                try{
                    String input="";
                    while(true){
                        System.out.println("=>Entrez l'id du crédit :");
                        input=clavier.nextLine();
                        if(estUnNombre(input)) break;
                        System.err.println("Entrée non valide !");
                    }
                  long id=Long.parseLong(input);
                    controleur.afficher_Mensualité(id);
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }
                System.out.println("Voulez-vous quitter(oui/non)?");
                rep=clavier.nextLine();
            }
            while(!rep.equalsIgnoreCase("oui"));
            System.out.println("Au revoir ^_^");



        }
    public static  void test2() throws Exception{
        String daoClass;
        String serviceClass;
        String controllerClass;


        Properties properties=new Properties();

        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile=ClassLoader.getSystemResourceAsStream("config.properties");


        if(propertiesFile==null) throw new Exception("Fichier config introuvable!");
        else{
            try{
                properties.load(propertiesFile);
                daoClass=properties.getProperty("DAO");
                serviceClass=properties.getProperty("SERVICE");
                controllerClass=properties.getProperty("CONTROLLER");

                propertiesFile.close();
            }
            catch (IOException e){
                throw new Exception("Probleme de chargement des proprietes du fichier config");
            }
            finally {
                properties.clear();
            }
        }
        try {
            Class cDao= Class.forName(daoClass);
            Class cMetier=Class.forName(serviceClass);
            Class cControleur=Class.forName(controllerClass);

            var dao= (IDao<Credit,Long>)cDao.getDeclaredConstructor().newInstance();
            var metier= (IMetier)cMetier.getDeclaredConstructor().newInstance();
            creditControleur= (IControleur) cControleur.getDeclaredConstructor().newInstance();


            Method setDao=cMetier.getMethod("setCreditDao", IDao.class);
            setDao.invoke(metier,dao);

            Method  setMetier=cControleur.getMethod("setCreditMetier",IMetier.class);
            setMetier.invoke(creditControleur,metier);


            creditControleur.afficher_Mensualité(1L);





        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void test3() throws Exception{
        ApplicationContext context= new ClassPathXmlApplicationContext("spring-ioc.xml");
        creditControleur=(IControleur) context.getBean("presentation");
        creditControleur.afficher_Mensualité(1L);

    }

    public  static void test4() throws Exception{
        ApplicationContext context= new AnnotationConfigApplicationContext("dao","service","presentation");
        creditControleur=(IControleur) context.getBean(IControleur.class);
        creditControleur.afficher_Mensualité(1L);

    }


    public static void main(String[] args) throws Exception {
       // test1();
        //test2();
       //test3();
        test4();

    }
 }
