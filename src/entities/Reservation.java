package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	
	public Integer duration(){
		long diferenca = checkin.until(checkout, ChronoUnit.DAYS);
		int diferenca_int = (int) diferenca;
		return diferenca_int;
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		
		if (checkin.isBefore(this.checkin) || checkout.isBefore(this.checkout)){
			return "Reservation dates for update must be future dates";
		}
		if (checkout.isBefore(checkin)) {			
			return "Check-out date must be after check-in date";
		}	
			this.checkin = checkin;
			this.checkout = checkout;
			return null;		
	}
	
	@Override	
	public String toString() {
		return "Reservation: Room " 
				+ roomNumber + ", check-in: " 
				+ checkin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
				+ ", check-out: " 
				+ checkout.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", " + duration() + " nights"; 
	}
}

	


