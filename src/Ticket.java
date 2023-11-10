public class Ticket {
    private final int row_no;
    private final int seat_no;
    private final person object1;
    private final int price;


    public Ticket(int row_no, int seat_no, int price, person object1) {

        this.row_no = row_no;
        this.seat_no = seat_no;
        this.object1 = object1;
        this.price = price;


    }


    public void print() {
        System.out.print("\nName: " + object1.name);
        System.out.print("\nSurname: " + object1.surname);
        System.out.print("\nEmail: " + object1.email);
        System.out.print("\nRow_no: " + row_no);
        System.out.print("\nSeat_no: " + seat_no);
        System.out.print("\nPrice: " + price);


    }

    public int getRow() {
        return row_no;
    }

    public int getSeat() {
        return seat_no;
    }

    public double getPrice() {
        return price;
    }

}
