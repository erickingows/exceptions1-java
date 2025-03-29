package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import mode.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			Integer roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));		
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);			
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin_ = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout_ = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
	
			reservation.updateDates(checkin_, checkout_);
			
			System.out.println("Reservation: " + reservation);
		}
		catch (DomainException e){
			System.out.println("Error in reservation: " + e.getMessage());	
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		
		
		
		sc.close();
	}

}
