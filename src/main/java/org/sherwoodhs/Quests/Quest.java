package org.sherwoodhs.Quests;

public interface Quest {

    public String getName();

    public String getDescription();

    public void setDescription(String newDescription);

    public boolean isCompleted();

    public void complete();

}
