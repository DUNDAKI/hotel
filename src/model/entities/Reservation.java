package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExcptions;


public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn,checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if(!checkOut.after(checkIn)) {
			throw new DomainExcptions("Check-out date must be after check-in date");
			}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		// calcular diferça entre datas
		
		 long diff = checkOut.getTime() - checkIn.getTime();
		return  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		 
	}
	
	public void updateDates(Date checkOut, Date checkIn){
		 
		 Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)){
			//lançar uma excexao
			//qual excecao estanciar
			throw new DomainExcptions("Error in reservation dates for update"
					+ "must be future dates ");
		}				
		if(!checkOut.after(checkIn)) {
			throw new DomainExcptions("Error in reservation dates for update"
						+ " must be future date ");
			}
		this.checkIn = checkIn;
		this.checkOut =  checkOut;
		
		
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", check-in: "
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+" nights";
				
	}
	
	
	

}
