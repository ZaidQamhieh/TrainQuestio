public class Seat {
    private int seatNumber;
    private String passengerName;

    public Seat(int seatNumber, String passengerName) {
        this.seatNumber = seatNumber;
        this.passengerName = null;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public boolean isEmpty() {
        if (passengerName == null) {
            return true;
        }else return false;
    }

    public static boolean isValid(int seat) {
        if (seat < 93 && (seat != 90 && seat != 89) && (seat != 4 && seat != 3)) {
            return true;
        }
        return false;
    }

    public static int getRow(int seat) {
        if (isValid(seat)) {
            if (seat % 2 == 0) {
                if (seat % 4 == 0) {
                    return 1;
                } else return 3;
            } else {
                if ((seat - 1) % 4 == 0) {
                    return 4;
                } else return 2;
            }
        }
        return -1;
    }

    public static int getColumn(int seat) {
        if (isValid(seat)) {
            int row = getRow(seat);
            switch (row) {
                case 1:
                    return (seat / 4);
                case 2:
                    return ((seat + 1) / 4);
                case 3:
                    return (((seat - 2) / 4) + 1);
                case 4:
                    return (((seat - 1) / 4) + 1);
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber=" + seatNumber +
                ", passengerName='" + passengerName + ", row=" + getRow(seatNumber) + ", column=" + getColumn(seatNumber) + '\'' +
                '}';
    }
}
