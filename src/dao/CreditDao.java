package dao;

import Modele.Credit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Component("dao")
public class CreditDao implements  IDao<Credit, Long> {

   public static Set<Credit> BDCredits(){
       return new HashSet<Credit>(
        Arrays.asList(
                new Credit(1L,300000.0,120,2.5,"Amine",0.0),
                new Credit(2L,850000.0,240,2.5,"Tarek",0.0),
                new Credit(3L,020000.0,030,1.5,"Sarah",0.0),
                new Credit(4L,065000.0,060,2.5,"Tanae",0.0)

        ));

    }





        @Override
    public Credit trouverParId(Long id){
        System.out.println("[DAO- DS volatile] trouver le credit n : "+ id);
        return BDCredits().stream().filter(credit->credit.getId() == id).findFirst().orElse(null);
    }

}
