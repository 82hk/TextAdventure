package org.sherwoodhs.Situations.Testing.TestCombat1;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.NPCS.NPC;
import org.sherwoodhs.NPCS.TestEnemy;
import org.sherwoodhs.Situations.Combat;

public class TestCombat1_0 extends Combat {

    protected TestCombat1_0() {
        super(new TestEnemy());
    }

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
}
