package org.sherwoodhs.inventory;

public abstract class Item {
    private String name;
    private String shortDescription;
    private String longDescription;

    public Item(String name, String shortDescription, String longDescription){
        this.name = name;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
