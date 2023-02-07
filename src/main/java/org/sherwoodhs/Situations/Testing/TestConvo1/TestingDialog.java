package org.sherwoodhs.Situations.Testing.TestConvo1;


import org.sherwoodhs.Situations.Situation;

public class TestingDialog implements Situation {

    // desc
    private static Situation dialog = new TestingDialog();
    private TestingDialog() {

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
