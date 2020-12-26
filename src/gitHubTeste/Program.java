package gitHubTeste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int n =  sc.nextInt();
		
		System.out.print("Chek-in data (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next()); 
		
		System.out.print("Chek-in data (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next()); 
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out data"
					+ "must be after check-in");
		}else {
			System.out.println("teste");
		}
		
		
		sc.close();
	}

}
