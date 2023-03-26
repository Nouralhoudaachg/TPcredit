package service;

import Modele.Credit;

public interface IMetier {
    public Credit calculer_Mensualité(Long idCredit) throws Exception;
}
