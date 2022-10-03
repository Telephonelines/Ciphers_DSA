// |------------------------------------------------------------------------------------------------
// | NAME: Patryk Kaiser - K00263702                                                            	
// | DATE: 24/04/2022                                                                           	
// | FUNCTION: Class that decodes and encodes characters using a key passed in through constructor.	
// |------------------------------------------------------------------------------------------------

public class SubstitutionCipher implements Cipher{
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private String SHIFTED;

	protected SubstitutionCipher(){
	}
	
	public SubstitutionCipher(String key) {
		if (key.length() != 26) {
			throw new ArithmeticException("Key Should Be 26 Characters Long!");
		}
		this.SHIFTED = key;
	}

	public char encode(char ch) {
		int index;
		if (Character.isUpperCase(ch)) {
			index = ALPHABET.indexOf(Character.toLowerCase(ch));
			return Character.toUpperCase(this.SHIFTED.charAt(index));
		}
		else if (ALPHABET.indexOf(ch) == -1) {
			return ch;
		}
		index = ALPHABET.indexOf(ch);
		return SHIFTED.charAt(index);
	}

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
