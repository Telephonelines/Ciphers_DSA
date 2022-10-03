// |------------------------------------------------------------------------------------------------
// | NAME: Patryk Kaiser - K00263702                                                            
// | DATE: 24/04/2022                                                                           
// | FUNCTION: 	Class that decodes and encodes characters using a key passed in through constructor.
// |			Including the option to perform a left rotation after each encode / decode.
// |------------------------------------------------------------------------------------------------

public class RotatingCipher extends SubstitutionCipher implements Cipher{

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private String SHIFTED;
	
	public RotatingCipher(String key){
		if (key.length() != 26) {
			throw new ArithmeticException("Key Should Be 26 Characters Long!");
		}
		this.SHIFTED = key;
	}

	public char encode(char ch) {
		int index;
		if (Character.isUpperCase(ch)) {
			index = ALPHABET.indexOf(Character.toLowerCase(ch));
			ch = Character.toUpperCase(this.SHIFTED.charAt(index));
			this.rotate();
			return ch;
		}
		else if (ALPHABET.indexOf(ch) == -1) {
			this.rotate();
			return ch;
		}
		index = ALPHABET.indexOf(ch);
		ch = SHIFTED.charAt(index);
		this.rotate();
		return ch;
	}

	public char decode(char ch) {
		int index;
		if (Character.isUpperCase(ch)) {
			index = SHIFTED.indexOf(Character.toLowerCase(ch));
			this.rotate();
			return Character.toUpperCase(ALPHABET.charAt(index));
		}
		else if (ALPHABET.indexOf(ch) == -1) {
			this.rotate();
			return ch;
		}
		index  = SHIFTED.indexOf(ch);
		this.rotate();
		return ALPHABET.charAt(index);
	}

	private void rotate(){
		char[] original = this.SHIFTED.toCharArray();
		int n = original.length;
		char[] rotated = new char[n];

		// Left rotation by one
		for (int i = 0; i < n; i++) {
			int x = (i + n - 1) % n; // Calculate new index
			rotated[x] = original[i];
		}
		this.SHIFTED = String.valueOf(rotated);
	}
}
