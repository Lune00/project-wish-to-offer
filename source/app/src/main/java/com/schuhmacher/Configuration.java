package com.schuhmacher;

public class Configuration {
    public static enum ModePersistance {LocalRoomDataBase, WebAPI}

    ;
    static private ModePersistance modePersistance = ModePersistance.LocalRoomDataBase;

    static public ModePersistance getModePersistance() {
        return modePersistance;
    }
}
