package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		if (checkin.isAfter(checkout)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			return;
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);	
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin_ = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout_ = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			

			String error = reservation.updateDates(checkin_, checkout_);
			if (error != null) {
				System.out.println("Error in reservation : " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
			
			
			
			
		}
		
		
		
		
		
		
		sc.close();
	}

}
