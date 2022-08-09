package defaultpack;

import data.Database;

public class Main {
    static private Database database; 

    private Main(){
        Main.database = new Database();

    }

    static Database getDatabase() {
        return database;
    }

}
