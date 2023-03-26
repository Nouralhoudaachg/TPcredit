package Modele;




public class Credit {
    private Long id;
    private Double capital_emprunté;
    private Integer nbrmois;
    private Double taux_mensuel;
    private String nom_demandeur;
    private Double mensualite;

 //setters
    public void setCapital_emprunté(Double capital_emprunté) {
        this.capital_emprunté = capital_emprunté;
    }

    public void setNbrmois(Integer nbrmois) {
        this.nbrmois = nbrmois;
    }

    public void setTaux_mensuel(Double taux_mensuel) {
        this.taux_mensuel = taux_mensuel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom_demandeur(String nom_demandeur) {
        this.nom_demandeur = nom_demandeur;
    }

    public void setMensualité(Double mensualité) {
        this.mensualite = mensualité;
    }


    //getters


    public Long getId() {
        return id;
    }

    public Double getCapital_emprunté() {
        return capital_emprunté;
    }

    public Integer getNbrmois() {
        return nbrmois;
    }

    public Double getTaux_mensuel() {
        return taux_mensuel;
    }

    public String getNom_demandeur() {
        return nom_demandeur;
    }

    public Double getMensualité() {
        return mensualite;
    }
public Credit(Long id, Double capital_emprunté,Integer nbrmois,Double taux_mensuel,String nom_demandeur ,Double mensualite){
    this.id=id;
    this.capital_emprunté=capital_emprunté;
    this.nbrmois=nbrmois;
    this.taux_mensuel=taux_mensuel;
    this.nom_demandeur=nom_demandeur;
    this.mensualite=mensualite;
}
    //toString()
    @Override
    public String toString() {
        return "*************************************** \n"+
        "=>Credit n " + id + "\n"+
                "=>Nom du demandeur du credit: " + nom_demandeur + "\n" +
                        "-------------------------------------------\n" +
                        "=>Capital emprunté  " + capital_emprunté + "\n" +
                        "=>Nombre de mois   " + nbrmois + "\n" +
                        "=>Taux mensuel  " + taux_mensuel + "\n" +
                        "=>Mensualité  " + mensualite + "\n" +  "*************************************** ";
    }


      //    return n_a_a_creditstr ;





    //equals




}
