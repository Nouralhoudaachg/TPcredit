package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.CreditMetier;
import service.IMetier;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Controller
public class CreditControleur  implements  IControleur{

    @Autowired
    @Qualifier("service")

    IMetier creditMetier;
    public IMetier  setCreditMetier(IMetier service){
        return this.creditMetier=service;
    }
    public void afficher_Mensualité(Long idCredit) throws Exception {
        var creditAvecMensualite=creditMetier.calculer_Mensualité(idCredit);
        System.out.println(creditAvecMensualite);
    }

}
