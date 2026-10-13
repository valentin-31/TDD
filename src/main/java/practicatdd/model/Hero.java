package practicatdd.model;

import practicatdd.exceptions.InvalidClanRatException;
import practicatdd.exceptions.InvalidHeroException;

import java.util.List;
import java.util.UUID;

public class Hero {

    private UUID uuid;
    private String name;
    private int level;
    private List<String> skills;

    private Hero(UUID uuid, String nombre, int level, List<String> habilidades) {
        this.uuid = uuid;
        this.name = nombre;
        this.level = level;
        this.skills = habilidades;
    }

    public static Hero getNewInstance(UUID uuid, String nombre, int level, List<String> habilidades) throws InvalidHeroException {

        // validar el UUID
        if (uuid == null) {
            throw new InvalidHeroException("UUID is null");
        }

        // validar el nombre
        if (nombre == null || nombre.isBlank()) {
            throw new InvalidHeroException("Name is null or empty");
        }

        // validar el nivel
        if (level < 1 || level > 40) {
            throw new InvalidHeroException("Level is out of range. Must be between 1 and 40.");
        }

        // validar las habilidades
        if (habilidades == null) {
            throw new InvalidHeroException("Skills is null");
        }

        // validar habilidades repetidas
        if (habilidadesRepetidas(habilidades)) {
            throw new InvalidHeroException("Skills cannot be repeated");
        }

        return new Hero(uuid, nombre, level, habilidades);
    }

    private static boolean habilidadesRepetidas(List<String> habilidades) {
        for (int i = 0; i < habilidades.size(); i++) {
            for (int j = i + 1; j < habilidades.size(); j++) {
                if (habilidades.get(i).equals(habilidades.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkillList() {
        return skills;
    }

    public UUID getUUID() {
        return uuid;
    }
}
