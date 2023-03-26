package service;

import Modele.Credit;
import dao.CreditDao;
import dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data @AllArgsConstructor @NoArgsConstructor

@Service("metier")
public class CreditMetier implements IMetier {

    @Autowired
    @Qualifier("dao")
    IDao<Credit,Long> creditDao;


    public Credit calculer_Mensualité(Long idCredit) throws Exception{
        var credit=creditDao.trouverParId(idCredit);


        if(credit==null)
            throw new Exception("L'id du credit est incorrect:: [credit  non trouvé]");
        else{
            double taux= credit.getTaux_mensuel();
                   taux= taux/1200;

            double capitale= credit.getCapital_emprunté();
            int    nbr_Mois= credit.getNbrmois();
            double mensualité=(capitale * taux) / (1-(Math.pow((1+taux), -1 * nbr_Mois))) ;
                   mensualité=Math.round(mensualité*100)/100;

                   credit.setMensualité(mensualité);

                   return credit;


        }

    }
    public IDao<Credit,Long>  setCreditDao(IDao dao){
       return this.creditDao=dao;
    }
}
