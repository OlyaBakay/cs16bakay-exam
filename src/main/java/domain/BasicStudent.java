package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair name_j = new JsonPair("name", new JsonString(name));
        JsonPair surname_j = new JsonPair("surname", new JsonString(surname));
        JsonPair year_j = new JsonPair("year", new JsonNumber(year));
        return new JsonObject(name_j, surname_j, year_j);

    }

}
