package a1_2201040110;

import java.util.Arrays;
import java.util.Random;

public class CoffeeTinGame {

    private static final char GREEN = 'G';
    private static final char BLUE = 'B';
    private static final char REMOVED = '-';
    private static final char NULL = '\u0000';
    private static final char[] Beansbag = new char[30];

    static {
        Arrays.fill(Beansbag, 0, 10, GREEN);
        Arrays.fill(Beansbag, 10, 20, BLUE);
        Arrays.fill(Beansbag, 20, 30, REMOVED);
    }

    public static void main(String[] args) {

        char[][] tins = {
                { BLUE, BLUE, BLUE, GREEN, GREEN },
                { BLUE, BLUE, BLUE, GREEN, GREEN, GREEN },
                { GREEN },
                { BLUE },
                { BLUE, GREEN }
        };

        for (int i = 0; i < tins.length; i++) {
            char[] tin = tins[i];

            int greens = 0;
            for (char bean : tin) {
                if (bean == GREEN)
                    greens++;
            }

            final char last = (greens % 2 == 1) ? GREEN : BLUE;

            System.out.printf("%nTIN (%d Gs): %s %n", greens, Arrays.toString(tin));

            char lastBean = tinGame(tin);

            System.out.printf("tin after: %s %n", Arrays.toString(tin));

            if (lastBean == last) {
                System.out.printf("last bean: %c%n", lastBean);
            } else {
                System.out.printf("Oops, wrong last bean: %c (expected: %c)%n", lastBean, last);
            }
        }
    }

    public static char tinGame(char[] tin) {
        while (hasAtLeastTwoBeans(tin)) {

            char[] twoBeans = takeTwo(tin);
            char b1 = twoBeans[0];
            char b2 = twoBeans[1];

            if (b1 == b2) {
                putIn(tin, BLUE);
            } else {
                putIn(tin, GREEN);
            }
        }
        return anyBean(tin);
    }

    public static char takeOne(char[] tin) {
        /*
         * for (int i = 0; i < tin.length; i++) {
         * char bean = tin[i];
         * if (bean != REMOVED) {
         * tin[i] = REMOVED;
         * return bean;
         * }
         * }
         * return NULL;
         */

        int idx = randInt(tin.length);
        char bean = tin[idx];
        tin[idx] = REMOVED;
        return bean;
    }

    public static int randInt(int n) {
        Random rnd = new Random();
        return rnd.nextInt(n);
    }

    public static char getBean(char[] beansBag, char beanType) {
        int idx = randInt(beansBag.length);
        char selectedBean = beansBag[idx];
        
        while (selectedBean == beanType) {
            beansBag[idx] = REMOVED;
            return selectedBean;
        }

        return NULL;
    }

    public static void updateTin(char[] tin, char beanOne, char beanTwo) {
        char newBean = getBean(Beansbag, beanOne == beanTwo ? BLUE : GREEN);
        putIn(tin, newBean);
    }

    private static boolean hasAtLeastTwoBeans(char[] tin) {
        int count = 0;
        for (char bean : tin) {
            if (bean != REMOVED) {
                count++;
            }

            if (count >= 2)
                return true;
        }

        return false;
    }

    private static char[] takeTwo(char[] tin) {
        char first = takeOne(tin);
        char second = takeOne(tin);

        return new char[] { first, second };
    }

    private static void putIn(char[] tin, char bean) {
        for (int i = 0; i < tin.length; i++) {
            if (tin[i] == REMOVED) {
                tin[i] = bean;
                break;
            }
        }
    }

    private static char anyBean(char[] tin) {
        for (char bean : tin) {
            if (bean != REMOVED) {
                return bean;
            }
        }

        return NULL;
    }
}
