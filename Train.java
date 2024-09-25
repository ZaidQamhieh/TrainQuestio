public class Train {
    private static Seat[] seats;

    Train() {
        seats = new Seat[88];
        int count = 1;
        for (int i = 0; i < 88; i++) {
            while (count == 3 || count == 4 || count == 89 || count == 90) {
                count++;
            }
            seats[i] = new Seat(count, null);
            count++;
        }
    }

    public  Seat[] getSeats() {
        return seats;
    }

    public boolean reserveSeat(int seat, String name) {
        if (Seat.isValid(seat)) {
            for (int i = 1; i < seats.length; i++) {
                if (seats[i].getSeatNumber() == seat) {
                    if (seats[i].isEmpty()) {
                        seats[i].setPassengerName(name);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteNonEmpty(int seat) {
        if (Seat.isValid(seat)) {
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i].isEmpty()) {
                    seats[i].setPassengerName(null);
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteSeats() {
        for (int i = 0; i < seats.length; i++) {
                seats[i].setPassengerName(null);
        }
    }
    public void printAllSeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.println(seats[i].toString());
        }
    }
}