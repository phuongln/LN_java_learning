package lab6;

	import java.util.Scanner; 
	 
	public class Translatenumbertotext { 
	    private static int n; 
	  private static Scanner input; 
	 
	    private static int get_num_digits(int n) { 
	        int count = 0; 
	        while (n > 0) { 
	            count++; 
	            n /= 10; 
	        } 
	        return count; 
	    } 
	 
	    private static void translate_powers(int num_powers) { 
	        switch (num_powers) { 
	            case 1: 
	                System.out.printf( "thousand " ); 
	                break; 
	            case 2: 
	                System.out.printf( "million " ); 
	                break; 
	            case 3: 
	                System.out.printf( "billion " ); 
	                break; 
	            default: 
	                System.out.printf( " " ); 
	        } 
	    } 
	 
	    private static void translate_num(int num) { 
	        switch (num) { 
	            case 1: 
	                System.out.printf( "one " ); 
	                break; 
	            case 2: 
	                System.out.printf( "two " ); 
	                break; 
	            case 3: 
	                System.out.printf( "three " ); 
	                break; 
	            case 4: 
	                System.out.printf( "four " ); 
	                break; 
	            case 5: 
	                System.out.printf( "five " ); 
	                break; 
	            case 6: 
	                System.out.printf( "six " ); 
	                break; 
	            case 7: 
	                System.out.printf( "seven " ); 
	                break; 
	            case 8: 
	                System.out.printf( "eight " ); 
	                break; 
	            case 9: 
	                System.out.printf( "nine " ); 
	                break; 
	            case 10: 
	                System.out.printf( "ten " ); 
	                break; 
	            case 11: 
	                System.out.printf( "eleven " ); 
	                break; 
	            case 12: 
	                System.out.printf( "twelve " ); 
	                break; 
	            case 13: 
	                System.out.printf( "thirteen " ); 
	                break; 
	            case 14: 
	                System.out.printf( "fourteen " ); 
	                break; 
	            case 15: 
	                System.out.printf( "fifteen " ); 
	                break; 
	            case 16: 
	                System.out.printf( "sixteen " ); 
	                break; 
	            case 17: 
	                System.out.printf( "seventeen " ); 
	                break; 
	            case 18: 
	                System.out.printf( "eighteen " ); 
	                break; 
	            case 19: 
	                System.out.printf( "nineteen " ); 
	                break; 
	            default: 
	                System.out.printf( " " ); 
	        } 
	    } 
	 
	    private static void translate_tens(int ten) { 
	        switch (ten) { 
	            case 2: 
	                System.out.printf( "twenty " ); 
	                break; 
	            case 3: 
	                System.out.printf( "thirty " ); 
	                break; 
	            case 4: 
	                System.out.printf( "forty " ); 
	                break; 
	            case 5: 
	                System.out.printf( "fifty " ); 
	                break; 
	            case 6: 
	                System.out.printf( "sixty" ); 
	                break; 
	            case 7: 
	                System.out.printf( "seventy " ); 
	                break; 
	            case 8: 
	                System.out.printf( "eighty " ); 
	                break; 
	            case 9: 
	                System.out.printf( "ninety " ); 
	                break; 
	            default: 
	                System.out.printf( " " ); 
	        } 
	    } 
	 
	    public static void main(String[] args) { 
	        input = new Scanner( System.in ); 
	 
	        n = input.nextInt(); 
	        if (n == 0) { 
	            System.out.print( "zero" ); 
	        } 
	        if (n < 0) { 
	            System.out.print( "negative " ); 
	            n *= -1; 
	        } 
	            int num_digits = get_num_digits( n ); 
	            int num_powers = (num_digits % 3 == 0) ? (num_digits / 3) : (num_digits / 3 + 1); 
	            int t; 
	            while (num_powers > 0) { 
	                t = (int) Math.pow( 10, (num_powers - 1) * 3 ); 
	                int m = n / t; 
	                int hundred = m / 100; 
	                if (hundred != 0) { 
	                    translate_num( hundred ); 
	                    System.out.print( "hundred " ); 
	                } 
	                if ((m % 100) < 20) { 
	                    int num = m % 100; 
	                    translate_num( num ); 
	                } else { 
	                    int tens = m % 100 / 10; 
	                    translate_tens( tens ); 
	                    int num = m % 100 % 10; 
	                    translate_num( num ); 
	                } 
	                translate_powers( num_powers - 1 ); 
	                num_powers--; 
	                n %= t; 
	            } 
	 
	        } 
	 
	    }

