package gitHubTeste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber =  sc.nextInt();
		
		System.out.print("Chek-in data (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next()); 
		
		System.out.print("Chek-out data (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next()); 
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out data"
					+ "must be after check-in");
		}else {
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			sc.nextLine();
			System.out.println("Reservation: " + reservation);
			
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Chek-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next()); 
			
			System.out.print("Chek-out data (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next()); 
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)){
				System.out.println("Error in reservation: Check-out data"
						+ "must be after check-in");
			}				
			else if(!checkOut.after(checkIn)) {
					System.out.println("Error in reservation dates for update"
							+ "must be future dates ");
				}else {
					//metodo que atualiza date
					reservation.updateDates(checkOut, checkIn);
					System.out.println("Reservation: " + reservation);
				}
			}
			
		
		
		
		
		sc.close();
	}

}
