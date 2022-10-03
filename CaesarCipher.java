// |--------------------------------------------------------------------------------------------|
// | NAME: Patryk Kaiser - K00263702                                                            |
// | DATE: 24/04/2022                                                                           |
// | FUNCTION: Class that encodes and decodes individual characters using the "Caesar cipher".  |
// |--------------------------------------------------------------------------------------------|

public class CaesarCipher implements Cipher{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SHIFTED = "defghijklmnopqrstuvwxyzabc";

    /**
     *  Constructs a Cipher object.
     */
    public CaesarCipher(){
    }

    /**
     * Encodes a single character.
     *   @param ch the character to be encoded
     *   @return the character three later in the alphabet, with wrap-around
     */
	public char encode(char ch) {
        int index;
        if (Character.isUpperCase(ch)) {
            index = ALPHABET.indexOf(Character.toLowerCase(ch));
            return Character.toUpperCase(SHIFTED.charAt(index));
        }
        else if (ALPHABET.indexOf(ch) == -1) {
            return ch;
        }
	    index = ALPHABET.indexOf(ch);
	    return SHIFTED.charAt(index);
	}
	
    /**
     * Decodes a single character.
     *   @param ch the character to be decoded
     *   @return the character three earlier in the alphabet, with wrap-around
     */
    public char decode(char ch) {
        int index;
        if (Character.isUpperCase(ch)) {
            index = SHIFTED.indexOf(Character.toLowerCase(ch));
            return Character.toUpperCase(ALPHABET.charAt(index));
        }
        else if (ALPHABET.indexOf(ch) == -1) {
            return ch;
        }
        index  = SHIFTED.indexOf(ch);
        return ALPHABET.charAt(index);
	}
}