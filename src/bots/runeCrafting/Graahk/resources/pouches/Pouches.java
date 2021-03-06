/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bots.runeCrafting.Graahk.resources.pouches;

import org.powerbot.game.api.methods.Settings;

/**
 * Settings for Pouches, I do not take credit, credit goes to xMunch
 */
public class Pouches {

    public static boolean allEmpty() {
        return Settings.get(486) == 1073741824 && Settings.get(720) == 0;
    }

    public static boolean smallEmpty() {
        return smallCount() == 0 && smallEssType() == null;
    }

    public static boolean medEmpty() {
        return medCount() == 0 && medEssType() == null;
    }

    public static boolean largeEmpty() {
        return largeCount() == 0 && largeEssType() == null;
    }

    public static boolean giantEmpty() {
        return Settings.get(720) < 64 && giantCount() == 0 && giantEssType() == null;
    }

    public static int smallCount() {
        int count = Settings.get(486) - 1073741824;
        if (count >= 4608) {
            count %= 262144;
        }
        if (count >= 48) {
            count %= 512;
        }
        if (count > 3) {
            count %= 8;
        }
        return count;
    }

    public static int medCount() {
        int count = Settings.get(486) - 1073741824;
        if (count >= 4608) {
            count %= 262144;
        }
        if (count > 48) {
            count %= 512;
        }
        return count / 8;
    }

    public static int largeCount() {
        int count = Settings.get(486) - 1073741824;
        if (count >= 4608) {
            count %= 262144;
        }
        return count / 512;
    }

    public static int giantCount() {
        return (Settings.get(486) - 1073741824) / 262144;
    }

    public static String smallEssType() {
        int type = Settings.get(720);
        if (type >= 64) {
            type %= 64;
        }
        if (type >= 16) {
            type %= 16;
        }
        if (type >= 4) {
            if (type < 9) {
                type %= 4;
            } else {
                type %= 9;
            }
        }
        return type == 1 ? " Rune " : type == 2 ? " Pure " : null;
    }

    public static String medEssType() {
        int type = Settings.get(720);
        if (type >= 64) {
            type %= 64;
        }
        if (type >= 16) {
            type %= 16;
        }
        return type >= 4 && type < 9 ? " Rune " : type >= 9 ? " Pure " : null;
    }

    public static String largeEssType() {
        int type = Settings.get(720);
        if (type >= 64) {
            type %= 64;
        }
        return type >= 16 && type < 32 ? " Rune " : type >= 32 ? " Pure " : null;
    }

    public static String giantEssType() {
        return Settings.get(720) >= 64 && Settings.get(720) < 128 ? " Rune " : Settings.get(720) >= 128 ? " Pure " : null;
    }
}
