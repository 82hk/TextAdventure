package org.sherwoodhs;

import org.sherwoodhs.Situations.Situation;

public class TestSituation implements Situation {

    @Override
    public String getTitle() {
        return "Test";
    }

    @Override
    public String getDescription() {
        return "you are in a testing space";
    }

    @Override
    public String[] getOptions() {
        return new String[] {};
    }

    @Override
    public void perform(String option) {

    }
}
