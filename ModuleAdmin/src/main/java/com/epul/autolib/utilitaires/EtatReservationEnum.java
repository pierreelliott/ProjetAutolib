package com.epul.autolib.utilitaires;

public enum EtatReservationEnum {
    PENDING("en attente")
    ,CONFIRMED("confirmee")
    //, FINISHED("terminee")
    ;

    private String label;

    EtatReservationEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static EtatReservationEnum parse(String label) {
        switch (label) {
            case "en attente":
                return PENDING;
            case "confirmee":
                return CONFIRMED;
//            case "terminee":
//                return FINISHED;

        }
        return null;
    }
}
