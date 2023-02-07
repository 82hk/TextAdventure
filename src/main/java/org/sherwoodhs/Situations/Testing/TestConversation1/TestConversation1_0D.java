package org.sherwoodhs.Situations.Testing.TestConversation1;


import org.sherwoodhs.Situations.Situation;

public class TestConversation1_0D implements Situation {

    // desc
    private static Situation dialog = new TestConversation1_0D();
    private TestConversation1_0D() {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Hello, traveler", "*Yell*"};
        return options;
    }

    @Override
    public void perform(String option) {

    }


    public static Situation getInstance(){
        return dialog;
    }
}
