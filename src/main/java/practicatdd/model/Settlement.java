package practicatdd.model;

import practicatdd.exceptions.InvalidSettlementException;

public class Settlement {

    private String name;
    private int level;
    private boolean isCapital;

    private Settlement(String name, int level, boolean isCapital) {
        this.name = name;
        this.level = level;
        this.isCapital = isCapital;
    }

    public static Settlement getNewInstance(String name, int level, boolean isCapital) throws InvalidSettlementException {

        // el nombre es nulo o vacio?
        if (name == null || name.isBlank()) {
            throw new InvalidSettlementException("Name is null or empty");
        }

        // el nombre tiene mas de 30 caracteres?
        if (name.length() > 30) {
            throw new InvalidSettlementException("Name is over 30 characters");
        }

        // el nivel es valido?
        if (level < 0) {
            throw new InvalidSettlementException("Settlement level must be between 0 and 5");
        }

        // el asentamiendo menor es valido?
       if(isCapital == false && level > 3) {
           throw new InvalidSettlementException("Minor settlement level must be between 0 and 3");
       }

        // el asentamiendo capital es valido?
        if(isCapital && level > 5) {
            throw new InvalidSettlementException("Capital settlement level must be between 0 and 5");
        }

        return new Settlement(name, level, isCapital);
    }

    public boolean isCapital() {
        return isCapital;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
