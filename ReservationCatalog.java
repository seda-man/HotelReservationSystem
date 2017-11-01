//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ReservationCatalog.java
//  @ Date : 10/27/2017
//  @ Author : 
//
//


import java.util.HashMap;

public class ReservationCatalog {
	private HashMap<Integer, Reservation> reservations = new HashMap<>();

	public void cancelReservation(int reservationID) {
		reservations.remove(reservationID);
	}
	
	private int generateID() {
		return reservations.size() + 1;
	}
	
	public int getNumberOfRelatedReservations(RoomDescription roomDesc, String timeInterval) {
		int numberOfRooms = 0;
		for(int i = 1; i < reservations.size() + 1; i++){
			Reservation res = reservations.get(i);
			if (res.check(roomDesc, timeInterval)) {
				numberOfRooms++;
			}
		}
		return numberOfRooms;
	}
	
	public Reservation getReservation(int reservationID) {
		return reservationID <= reservations.size() ? reservations.get(reservationID) : null;
	}
	
	private void load() {
	
	}
	
	public int makeReservation(RoomDescription desc, String timeInterval) {
		int reservationID = generateID();
		Reservation newReservation = new Reservation(reservationID, timeInterval, desc);
		reservations.put(reservationID, newReservation);
		return reservationID;
	}
	
	public void removeReservation(Reservation res) {
	
	}

	public HashMap<Integer, Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(HashMap<Integer, Reservation> reservations) {
		this.reservations = reservations;
	}

}