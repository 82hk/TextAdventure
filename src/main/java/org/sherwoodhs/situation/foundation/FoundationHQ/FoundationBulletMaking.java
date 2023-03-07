package org.sherwoodhs.situation.foundation.FoundationHQ;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationBulletMaking implements Situation {
    @Override
    public String getTitle() {
        return "The Armory";
    }

    @Override
    public String getDescription() {
        return "As you work on the makeshift kiln you add scrap pieces to the furnace, carefully watching as they melt down into liquid metal." +
                "With a pair of tongs, you remove the molten metal from the furnace and pour it into poorly made bullet molds." +
                "Why is the foundation working with such poor equipment you think to yourself but suddenly you hear footsteps approaching behind you\n";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        return new String[0];
    }

    @Override
    public void perform(String option) {

    }
}