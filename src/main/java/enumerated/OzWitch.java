package enumerated;

import utils.PrintUtil;

/**
 * Created by yuez on 14-1-23.
 * The witches in the land of Oz
 */
public enum OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;

    OzWitch(String s) {
        description = s;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values())
            PrintUtil.print(witch + ": " + witch.getDescription());
    }
}
