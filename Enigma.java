// |--------------------------------------------------------------------------------|
// | NAME: Patryk Kaiser - K00263702                                                |
// | DATE: 24/04/2022                                                               |
// | FUNCTION: 	Class to emulate simplified model of Enigma machine.                |
// |			Three rings. Inner ring rotates after each encode / decode.         |
// |            Outer ring same for all enigmas. Pass in inner and middle.          |
// |            Middle ring rotates after inner ring returns to original position.  |
// |--------------------------------------------------------------------------------|

public class Enigma implements Cipher{
    private static final String outer = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
    private String inner;
    private String middle;
    private final String original;

    public Enigma(String key1, String key2){
        if (key1.length() != 27 || key2.length() != 27)  {
            throw new ArithmeticException("Keys Should Be 27 Characters Long!");
        }
        this.inner = key1.toUpperCase();
        this.middle = key2.toUpperCase();
        this.original = key1.toUpperCase();
    }

    @Override
    public char encode(char ch) {
        int innerChar;
        int outerChar;
        int midChar;

        ch = Character.toUpperCase(ch);
        innerChar = inner.indexOf(ch);
        outerChar = outer.charAt(innerChar);
        midChar = middle.indexOf(outerChar);
        ch = outer.charAt(midChar);

        this.rotate();
        return ch;
    }

    @Override
    public char decode(char ch){
        int innerChar;
        int outerChar;
        int midChar;

        ch = Character.toUpperCase(ch);
        outerChar = outer.indexOf(ch);
        midChar = middle.charAt(outerChar);
        outerChar = outer.indexOf(midChar);
        ch = inner.charAt(outerChar);

        this.rotate();
        return ch;
    }

    private void rotate(){
        char[] original = this.inner.toCharArray();
        int n = original.length;
        char[] rotated = new char[n];

        // Right rotation by one.
        for (int i = n - 2; i >= 0; i--) {
            int x = i + 1;
            rotated[x] = original[i];
        }
        rotated[0] = original[n - 1]; // Last from original goes to start of rotated.
        this.inner = String.valueOf(rotated);

        // Handle turning the middle
        if (this.inner.equals(this.original)) {
            original = this.middle.toCharArray();
            n = original.length;
            rotated = new char[n];

            // Right rotation by one.
            for (int i = n - 2; i >= 0; i--) {
                int x = i + 1;
                rotated[x] = original[i];
            }
            rotated[0] = original[n - 1]; // Last from original goes to start of rotated.
            this.middle = String.valueOf(rotated);
        }
    }
}
