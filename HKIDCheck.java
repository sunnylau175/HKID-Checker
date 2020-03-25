
public class HKIDCheck {
	
	private char [] letters;
	private int [] code;
	
	public HKIDCheck() {
		letters = new char [27];
		code = new int [27];
		
		letters[0] = ' ';
		letters[1] = 'A';
		letters[2] = 'B';
		letters[3] = 'C';
		letters[4] = 'D';
		letters[5] = 'E';
		letters[6] = 'F';
		letters[7] = 'G';
		letters[8] = 'H';
		letters[9] = 'I';
		letters[10] = 'J';
		letters[11] = 'K';
		letters[12] = 'L';
		letters[13] = 'M';
		letters[14] = 'N';
		letters[15] = 'O';
		letters[16] = 'P';
		letters[17] = 'Q';
		letters[18] = 'R';
		letters[19] = 'S';
		letters[20] = 'T';
		letters[21] = 'U';
		letters[22] = 'V';
		letters[23] = 'W';
		letters[24] = 'X';
		letters[25] = 'Y';
		letters[26] = 'Z';
		
		code[0] = 58;
		code[1] = 10;
		code[2] = 11;
		code[3] = 12;
		code[4] = 13;
		code[5] = 14;
		code[6] = 15;
		code[7] = 16;
		code[8] = 17;
		code[9] = 18;
		code[10] = 19;
		code[11] = 20;
		code[12] = 21;
		code[13] = 22;
		code[14] = 23;
		code[15] = 24;
		code[16] = 25;
		code[17] = 26;
		code[18] = 27;
		code[19] = 28;
		code[20] = 29;
		code[21] = 30;
		code[22] = 31;
		code[23] = 32;
		code[24] = 33;
		code[25] = 34;
		code[26] = 35;
		
		
	}
	
	public char check(String HKID) {
		
		int sum = 0, q = 0;
		int checkDigit = -1;
		//int temp;
		
		HKID = HKID.toUpperCase();
		
		//System.out.print("\n HKID: " + HKID);
		
		if (HKID.length() < 7)
			return ' ';
		
		if (HKID.length() == 7)
			HKID = " " + HKID;
		
		if (findCode(HKID.charAt(0)) != -1)
			sum += findCode(HKID.charAt(0)) * 9;
		else return ' ';
		
		//System.out.print("\n sum = " + sum);
		
		if (findCode(HKID.charAt(1)) != -1)
			sum += findCode(HKID.charAt(1)) * 8;
		else return ' ';
		
		//System.out.print("\n sum = " + sum);
			
		for (int i = 2; i < 8; i++) {
			sum += ((int)Character.getNumericValue(HKID.charAt(i))) * (9 - i);
			//System.out.print("\n charAt = " + HKID.charAt(i));
			//temp = (int)Character.getNumericValue(HKID.charAt(i));
			
			//System.out.println("\n c= " + temp + " i= " + i);
			//System.out.print("\n sum = " + sum);	
		}
				
		q = (int)Math.ceil((double)sum / 11);
		
		//System.out.print("\n q = " + q);
		
		checkDigit = 11 * q - sum;
		
		//System.out.print("\n checkDigit = " + checkDigit);
		
		return checkDigit == 10 ? 'A' : Integer.toString(checkDigit).charAt(0);
		
	}
	
	private int findCode(char c) {
		
		for (int i = 0; i < 27; i++)
			if (letters[i] == c)
				return code[i];
			
		return -1;
		
	}
	

}
