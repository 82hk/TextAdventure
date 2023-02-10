package org.sherwoodhs.situation.Testing.TestCombat1;


import org.sherwoodhs.NPCS.TestEnemy;
import org.sherwoodhs.situation.Combat;
import org.sherwoodhs.situation.Situation;

public class TestCombat1_0C extends Combat {
    private static Situation combat = new TestCombat1_0C();
    protected TestCombat1_0C() {
        super(new TestEnemy());
    }

    @Override
    public String getSitType(){return "Combat";}

    @Override
    public String getTitle() {
        return "Test combat";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Insult", "Attack"};
    }

    @Override
    public void perform(String option) {
        switch (option)
        {
            case "Insult": {
                //Append description (frame.addLine("Enemy looks sad"))
                enemy.changeHappiness(-1);
                break;
            }
            case "Attack": {
                if (enemy.getHappiness() < -5)
                {
                    //kill
                }
                else
                {
                    //enemy blocks
                }

            }

        }
    }


    public static Situation getInstance(){
        return combat;
    }
}
