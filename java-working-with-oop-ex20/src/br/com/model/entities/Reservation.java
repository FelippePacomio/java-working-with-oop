package br.com.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private long nights;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long calculateDuration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // Diferença em milissegundos
        this.nights = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte para dias
        return this.nights;
    }

    public static boolean reservationCheck(Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-Out date must be after Check-In date");
        } else {
            return true;
        }
        return false;
    }

    public String listReservation(List<Reservation> reservationList) {
        StringBuilder sb = new StringBuilder();
        for (Reservation i : reservationList) {
            sb.append("\n");
            sb.append("Room ");
            sb.append(i.getRoomNumber());
            sb.append(", Check-in date: ");
            sb.append(sdf.format(i.getCheckIn()));
            sb.append(", Check-Out date: ");
            sb.append(sdf.format(i.getCheckOut()));
            sb.append(", ");
            sb.append(i.calculateDuration());
            sb.append(" nights");
        }
        return sb.toString();
    }

    public static boolean updateReservationByRoomNumber(
            List<Reservation> reservationList,
            int roomNumber,
            Date newCheckIn,
            Date newCheckOut) {

        Date now = new Date();
        if (newCheckIn.before(now) || newCheckOut.before(now)) {
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        } else if (!newCheckOut.after(newCheckIn)) {
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        } else {
            for (Reservation reservation : reservationList) {
                if (reservation.getRoomNumber() == roomNumber) {

                    if (reservationCheck(newCheckIn, newCheckOut)) {
                        reservation.updateDates(newCheckIn, newCheckOut);
                        return true;
                    } else {
                        System.out.println("Error in dates: Check-out date must be after Check-in date.");
                        return false;
                    }
                }
            }

        }
        System.out.println("Reservation not found for room " + roomNumber);
        return false;
    }

    public void updateDates(Date checkIn, Date checkOut) {
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

    @Override
    public String toString() {
        return "Room " + roomNumber
                + ", Check-in: " + sdf.format(checkIn)
                + ", Check-out: " + sdf.format(checkOut)
                + ", Duration: " + calculateDuration() + " nights";
    }

    public long getNights() {
        return nights;
    }

}
