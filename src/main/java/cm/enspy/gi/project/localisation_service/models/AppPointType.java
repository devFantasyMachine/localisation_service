package cm.enspy.gi.project.localisation_service.models;

public enum AppPointType {

    CITY("CITY"), MARKET("MARKET"), PLACE("PLACE"), AGENCY("AGENCY"),  
    RESTAURANT("RESTAURANT"), HOTEL("HOTEL");   // ajouter un constructeur pour eviter une erreur lors de l'access 0 la bd
    
    private String value;

    AppPointType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}



