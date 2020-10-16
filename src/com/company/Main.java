package com.company;

public class Main {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";


    public static void main(String[] args) {


//        String[] before = new String[]{"IN SPACE NOBODY...   ", "CODE"};
//        int[][] rotors = new int[][]{{15, 49, 50, 48, 43, 20}, {20, 20, 28, 0}};
//        String[] after = flapDisplay(before, rotors);

        getShiftedChar('b', 180);
    }


    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {

        String[] result = new String[lines.length];


        for (int z = 0; z < lines.length; z++) {

            char[] startLine = lines[z].toCharArray();
            int[] rotor = rotors[z];

            char[] resultLine = startLine;


            for (int j = 0; j < rotor.length; j++) {

                int currentRotor = rotor[j];
                for (int i = j; i < startLine.length; i++) {
                    char character = resultLine[i];
                    resultLine[i] = getShiftedChar(character, currentRotor);
                }
            }

            result[z] = String.valueOf(resultLine);

        }

        for (String s : result) {
            System.out.println(s);
        }

        return result;
    }


    private static int getDist(char a, char b) {
        a = Character.toUpperCase(a);
        b = Character.toUpperCase(b);

        int dist;
        if (getPositionOfChar(a) > getPositionOfChar(b)) {
            dist = ALPHABET.length() - getPositionOfChar(b) - getPositionOfChar(a);
        } else {
            dist = getPositionOfChar(b) - getPositionOfChar(a);
        }
        return dist;
    }

    private static char getShiftedChar(char init, int rotor) {
        char result = 0;
        int length = ALPHABET.length();
        rotor = rotor - rotor/length * length;

        init = Character.toUpperCase(init);

        if (rotor + getPositionOfChar(init) < ALPHABET.length()) {
            int newPosition = getPositionOfChar(init) + rotor;
            result = ALPHABET.charAt(newPosition);
        } else {
            int newPosition = ALPHABET.length() -(getPositionOfChar(init) + rotor);
            result = ALPHABET.charAt(newPosition);
        }

        return result;
    }

    private static int getPositionOfChar(char init) {
        return ALPHABET.lastIndexOf(init);
    }
}
