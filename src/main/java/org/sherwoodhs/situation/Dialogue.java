package org.sherwoodhs.situation;

import org.sherwoodhs.AdvGame;


/*
    This is where the player starts to notice something is up. They meet a strange character who yells at them for being so close to the edge.
*/
public abstract class Dialogue implements Situation{

    //set in constructor to the correct values instead of overriding getOptions(). Keep this updated as you change the available options.
    private String[] currentOptions;
    private String currentDescription;

    //Use to track what state the conversation is in. You can set values arbitrarily.
    protected int tracker = 0;
    //keeps track of what the player most recently selected, for confirming purposes.
    private String selectedOption;
    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return currentOptions;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Confirm":
                Confirm(selectedOption);
                break;
            case "Cancel":
                setDescription(currentDescription, currentOptions);
                selectedOption = null;
                break;
            default:
                AdvGame.updateFrame(playerStatements(option), new String[]{"Confirm", "Cancel"});
                selectedOption = option;
                break;
        }
    }

    //Place the text for what the player says in the case of each option here.
    protected abstract String playerStatements(String option);

    //equivalent of the perform method for normal situations. Switch case for each option.
    protected abstract void Confirm(String option);


    //use these methods instead of interacting with the variables directly
    protected void setDescription(String description)
    {
        currentDescription = description;
        AdvGame.clearFrame(description);
    }

    protected void resetConversation()
    {
        AdvGame.clearFrame(currentDescription);
    }

    protected void setDescription(String description, String[] options)
    {
        currentOptions = options;
        currentDescription = description;
        AdvGame.clearFrame(currentDescription, currentOptions);
    }
}
