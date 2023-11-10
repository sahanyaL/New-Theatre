/*Author name : piyumdi sahanya liyanage
IIT ID  : 20221317
UOW ID  : 19561008
Date : 2nd March 2023
Subject : SD II Programming (Course Work)
 */


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Theatre {

    static ArrayList<Ticket> ticketList = new ArrayList<>();
    static Ticket ticketdata;



    public static void main(String[] args) {
        String[] row1 = new String[12];                                 //array1
        String[] row2 = new String[16];                                 //array2
        String[] row3 = new String[20];                                 //array3


        for (int i = 0; i < row1.length; i++) {
            row1[i] = "0";

        }


        for (int i = 0; i < row2.length; i++) {
            row2[i] = "0";

        }

        for (int i = 0; i < row3.length; i++) {
            row3[i] = "0";

        }


        Scanner y = new Scanner(System.in);
        boolean x = true;

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to the new Theater~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        while(x) {
            int option ;

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\nplease select an option");                            //menu
            System.out.println(" ");
            System.out.println(" ");

            System.out.println(" 1) Buy a ticket");                                     //option 1
            System.out.println(" 2) Print seating area");                               //option 2
            System.out.println(" 3) Cancel ticket");                                    //option 3
            System.out.println(" 4) List available seats");                             //option 4
            System.out.println(" 5) Save to file");                                     //option 5
            System.out.println(" 6) Load from file");                                   //option 6
            System.out.println(" 7) Print ticket information and total price");                         //option 7
            System.out.println(" 8) Sort tickets by price");                            //option 8
            System.out.println(" 0) Quit");                                             //option 0

            System.out.println(" ");
            System.out.println(" ");
            try {                                                                       //allows to define a block of code to be tested for errors while it is being executed
                System.out.println("Enter your option:");
                option = y.nextInt();

                switch (option) {
                    case 1:
                        buy_tickets(row1, row2, row3);
                        break;
                    case 2:
                        print_seating_area(row1, row2, row3);
                        break;
                    case 3:
                        cancel_ticket(row1, row2, row3);
                        break;
                    case 4:
                        show_available(row1, row2, row3);
                        break;
                    case 5:
                        save(row1, row2, row3);
                        break;
                    case 6:
                        load(row1, row2, row3);
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:

                        System.out.println("Thank you!!" +
                                "Have a nice day");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        x=false;
                        break;
                    default:
                        System.out.println("Invalid option, please try again");
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid option, please try again");
                y.nextLine();
            }
        }

    }

    public static void buy_tickets(String[] row1, String[] row2, String[] row3) {       //option 1 (buy tickets)

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for buy tickets!~~~~~~~~~~~~~~~~~\n");
        System.out.println();
        int row_no;
        int seat_no;

        Scanner sit = new Scanner(System.in);

        System.out.print("Enter your name: ");                              //input name
        String name = sit.next();                                           // Assign user's name to "name" String variable

        System.out.print("Enter your surname: ");                           //input surname
        String surname = sit.next();                                        // Assign user's surname to "surname" String variable


        System.out.print("Enter your email: ");                              //input email
        String email = sit.next();                                             // Assign user's email to "email" String variable


        person object1 = new person(name,surname,email);



        int price;

        while (true) {

            try {

                System.out.print("\nplease enter the row : ");
                row_no = sit.nextInt();

                if (row_no <= 3 && row_no > 0) {                                    //check whether the row number is equal to or less than 3 and greater than 0
                    System.out.print("please enter the seat : ");
                    seat_no = sit.nextInt();


                    if (row_no == 1 && seat_no < 13 && seat_no > 0) {              //check whether the row number is 1 and seat number is less than 13 and greater than 0

                        if ("1".equals(row1[seat_no - 1])) {

                            System.out.println("This seat has been taken");         ////check whether the seat booked or not

                        } else if ("0".equals(row1[seat_no - 1])) {

                            System.out.print("enter ticket price : ");
                            price = sit.nextInt();

                            row1[seat_no - 1] = "1";


                            ticketdata = new Ticket(row_no, seat_no, price, object1);
                            ticketList.add(ticketdata);//add information to the ticketlist List

                            System.out.println("\n-------------------------------------------------------------------- Purchased successfully! --------------------------------------------------------------------------------");
                            break;


                        }

                    } else if (row_no == 2 && seat_no < 17 && seat_no > 0) {                //check whether the row number is 2 and seat number is less than 17 and greater than 0

                        if ("1".equals(row2[seat_no - 1])) {
                            System.out.println("This seat has been taken");                 //check wheather the seat is booked or not


                        } else if ("0".equals(row2[seat_no - 1])) {


                            System.out.print("enter ticket price : ");
                            price = sit.nextInt();

                            row2[seat_no - 1] = "1";

                            ticketdata = new Ticket(row_no, seat_no, price, object1);
                            ticketList.add(ticketdata);                                      //add information to the ticketlist List

                            System.out.println("\n-------------------------------------------------------------------- Purchased successfully! --------------------------------------------------------------------------------");
                            break;
                        }
                    } else if (row_no == 3 && seat_no < 21 && seat_no > 0) {                   //check wheather the row number is 3 and seat number is less than 21 and greater than 0

                        if ("1".equals(row3[seat_no - 1])) {
                            System.out.println("This seat has been taken");                     //check whether the seat number is booked or not

                        } else if ("0".equals(row3[seat_no - 1])) {


                            System.out.print("enter ticket price : ");
                            price = sit.nextInt();

                            row3[seat_no - 1] = "1";

                            ticketdata = new Ticket(row_no, seat_no, price, object1);
                            ticketList.add(ticketdata);                                            //add information to the ticketlist List

                            System.out.println("\n-------------------------------------------------------------------- Purchased successfully! --------------------------------------------------------------------------------");
                            break;
                        }
                    } else {
                        System.out.println("please enter valid seat number");
                    }

                } else {
                    System.out.println("please enter valid row number");
                }
            }
            catch (Exception ex){
                System.out.println("please enter a valid number: try again...");
                sit.nextLine();
            }

        }


    }

    //-------------------------------------------part4-------------------------------------------------------------------------------------------------------------------
    public static void print_seating_area(String[] row1, String[] row2, String[] row3) {        //option 2 (print seating area

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the print seating area!~~~~~~~~~~~~~~~~~\n");
        System.out.println();
        System.out.println();
        System.out.println("   ************* ");
        System.out.println("   *   STAGE   * ");
        System.out.println("   ************* ");


//------------------------------------------ ROW 1 -----------------------------------------------------------------------------------------------------------------------
        System.out.print("    ");
        for (int i = 0; i < row1.length / 2; i++) {                              //for row 1 first 6 seats (first half)
            if ("0".equals(row1[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row1.length / 2; i < row1.length; i++) {                 //for row 1 second 6 seats (second half)
            if ("0".equals(row1[i])) {
                System.out.print("O");
            } else if ("1".equals(row1[i])) {
                System.out.print("X");
            }
        }System.out.println();


//------------------------------------------ ROW 2 ---------------------------------------------------------------------------------------------------------------
        System.out.print("  ");
        for (int i = 0; i < row2.length / 2; i++) {                              //for row 2 first 8 seats (first half)
            if ("0".equals(row2[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row2.length / 2; i < row2.length; i++) {                 //for row 2 second 8 seats (second half)
            if ("0".equals(row2[i])) {
                System.out.print("O");
            } else if ("1".equals(row2[i])) {
                System.out.print("X");
            }
        }System.out.println();

//------------------------------------------ ROW 3 -------------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < row3.length / 2; i++) {                             //for row 3 first 10 seats (first half)
            if ("0".equals(row3[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row3.length / 2; i < row3.length; i++) {                //for row 3 second 10 seats (second half)
            if ("0".equals(row3[i])) {
                System.out.print("O");
            } else if ("1".equals(row3[i])) {
                System.out.print("X");
            }
        }
        System.out.println("\n");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
// ---------------------------------------------part 5--------------------------------------------------------------------------------------------------

    public static void cancel_ticket(String[] row1, String[] row2, String[] row3) {        //option 3 (cancel ticket)

        int row_no;
        int seat_no;




        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the cancel tickets!~~~~~~~~~~~~~~~~~\n");
        System.out.println();

        Scanner seat = new Scanner(System.in);

        while(true) {
            try {


                System.out.print("enter the row number:");                              //input row number

                row_no = seat.nextInt();

                if (row_no <= 3 && row_no > 0) {                                        //check whether the row number is less than 3 and greater than 0
                    System.out.print("enter the seat number:");                         //input seat number
                    seat_no = seat.nextInt();


                    if (row_no == 1 && seat_no < 13 && seat_no > 0) {                   //check whether the row number is 1 and seat number is less than 13 and gretaer than 0


                        if ("0".equals(row1[seat_no - 1])) {                            //check whether the seat corresponding to the number enetred by the user is equal to 0
                            System.out.println("\nThis seat is not booked!");


                        } else if ("1".equals(row1[seat_no - 1])) {                     //check whether the seat corresponding to the number enetred by the user is equal to 1
                            row1[seat_no - 1] = "0";

                            System.out.println("----------------------------------------------------------------You have successfully canceled a seat---------------------------------------------------------------------");

                            for (int i = 0; i < ticketList.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also
                                if (ticketList.get(i).getRow() == row_no && ticketList.get(i).getSeat() == seat_no) {
                                    ticketList.remove(ticketList.get(i));                                          //remove the ticket information from ticketlist List
                                    break;
                                }
                            }

                        }
                    } else if (row_no == 2 && seat_no < 17 && seat_no > 0) {                   //check whether the row number is equal to 1 and seat number is less than 17 and greater than 0

                        if ("0".equals(row2[seat_no - 1])) {                             //check whether the seat corresponding to the number enetred by the user is equal to 0
                            System.out.println("\nThis seat is not booked!");

                        } else if ("1".equals(row2[seat_no - 1])) {                      //check whether the seat corresponding to the number enetred by the user is equal to 1
                            row2[seat_no - 1] = "0";

                            System.out.println("--------------------------------------------------------------------You have successfully canceled a seat-----------------------------------------------------------------------");

                            for (int i = 0; i < ticketList.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also
                                if (ticketList.get(i).getRow() == row_no && ticketList.get(i).getSeat() == seat_no) {
                                    ticketList.remove(ticketList.get(i));                           //remove the ticket information from the ticketlist List
                                    break;
                                }
                            }

                        }
                    } else if (row_no == 3 && seat_no < 21 && seat_no > 0) {                          //check whether the row number is equal to 3 and seat number is less tha 21 and greater than 0



                        if ("0".equals(row3[seat_no - 1])) {                                     //check whether the seat corresponding to the number enetred by the user is equal to 0
                            System.out.println("\nThis seat is not booked!");

                        } else if ("1".equals(row3[seat_no - 1])) {                                 //check whether the seat corresponding to the number enetred by the user is equal to 1
                            row3[seat_no - 1] = "0";

                            System.out.println("----------------------------------------------------------------You have successfully canceled a seat--------------------------------------------------------------------------------");


                            for (int i = 0; i < ticketList.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also
                                if (ticketList.get(i).getRow() == row_no && ticketList.get(i).getSeat() == seat_no) {
                                    ticketList.remove(ticketList.get(i));                           //remove the ticket information from the ticketlist List
                                    break;
                                }
                            }

                        }
                    } else {
                        System.out.println("please enter a valid seat number");
                        continue;
                    }
                } else {
                    System.out.println("please enter a valid row number");
                    continue;
                }break;
            }
            catch (Exception ex){
                System.out.println("please enter a valid number: try again....");
                seat.nextLine();
            }
        }


    }

    // -----------------------------------------------part 6----------------------------------------------------------------------------------------------------------
    public static void show_available(String[] row1, String[] row2, String[] row3) {                  //option 4(show available seats)

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the show available seats!~~~~~~~~~~~~~~~~~\n");
        System.out.println();
        System.out.println();
        System.out.print("available seats in row 1 : ");                                //show available seats in row 1
        for (int i = 0; i < row1.length; i++) {
            if ("0".equals(row1[i])) {                                                  //check whether the seat number equals to 0.if so then print it.
                System.out.print((i + 1) + (", "));
            } else {
                System.out.print("");                                                   //else print blank
            }
        }
        System.out.println(" ");


        System.out.print("available seats in row 2 : ");                                //show available seats in row 2
        for (int i = 0; i < row2.length; i++) {
            if ("0".equals(row2[i])) {                                                  //check whether the seat number is equals to 0.if so then print it.
                System.out.print((i + 1) + (", "));
            } else {
                System.out.print("");                                                   //else print blank
            }
        }
        System.out.println(" ");


        System.out.print("available seats in row 3 : ");                                //show available seats in row 3
        for (int i = 0; i < row3.length; i++) {
            if ("0".equals(row3[i])) {                                                  //check whether the seat number is equals to 0 so then print it.
                System.out.print((i + 1) + (", "));
            } else {
                System.out.print("");
            }
        }
        System.out.println(" ");                                                        //else print blank

    }

//-------------------------------------------part7------------------------------------------------------------------------------------------------------------------

    public static void save(String[]row1, String[]row2, String[]row3){                          //option 5 (save to a text file)

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the save information!~~~~~~~~~~~~~~~~~\n");

        try{
            FileWriter filewrite = new FileWriter("text.txt");                          //create a new text file.

            filewrite.write("row 1" +" "+ "seats = 12 " + " now available seats " );
            filewrite.write(Arrays.toString(row1));                                             //add row 1 array to the text file.


            filewrite.write("\nrow 2" +" "+ "seats = 16 " +" now available seats " );
            filewrite.write(Arrays.toString(row2));                                             //add row 2 array to the text file


            filewrite.write("\nrow 3" +" "+ "seats = 20 "+" now available seats " );
            filewrite.write(Arrays.toString(row3));                                             //add row 3 array to the text file.


            filewrite.close();
        }
        catch (IOException ex){
            System.out.println();
        }

    }

    //------------------------------------------------part 8-------------------------------------------------------------------------------------------------------------
    public static void load(String[]row1,String[]row2, String[]row3){                   //option 6 (load from file)
        try {                                                                           //allows to define a block of code to be tested for errors while it is being executed
            System.out.print("\n~~~~~~~~~~~~~~~~~This is for the load from file!~~~~~~~~~~~~~~~~~\n");
            try {                                                                       //allows to define a block of code to be tested for errors while it is being executed
                File object1 = new File("text.txt");
                Scanner myReader = new Scanner(object1);
                int count = 1;
                String[] copy_array;
                while (myReader.hasNextLine()) {
                    String data1 = myReader.nextLine();
                    String data2 = data1.substring(data1.indexOf("[") + 1);
                    String[] seats_array = data2.split(", ");
                    if (count == 1) copy_array = row1;
                    else if (count == 2) copy_array = row2;
                    else copy_array = row3;
                    for (int i = 0 ; i < seats_array.length ; i++) {
                        if (seats_array[i].equals("1")) {
                            copy_array[i] = seats_array[i];
                        }
                    }
                    count++;
                }myReader.close();
            } catch (FileNotFoundException e) {                                             //allows to define a block of code to be executed, if an error occurs in the try block
                System.out.println("\nAn error occurred.");
                e.printStackTrace();
                System.out.print("\n");
            }System.out.print("\n");
            System.out.println();
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------"); //load from file border
        } catch (Exception e) {                                                         //allows to define a block of code to be executed, if an error occurs in the try block
            System.out.println("Something went wrong.");
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void show_tickets_info( ){                //option 7 (show tickets info)

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the show tickets information!~~~~~~~~~~~~~~~~~\n");
        System.out.println();
        double total = 0;
        for (Ticket y : ticketList) {
            y.print();                                        // Called to print() method from Ticket class to display ticket's information
            System.out.print("\n");
            total = total + y.getPrice();
        }
        System.out.println("\nTotal ticket price: " + total);
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void sort_tickets() {                                                 //option 8(sort tickets)

        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the sort tickets!~~~~~~~~~~~~~~~~~\n");
        System.out.println();
        int len = ticketList.size();
        Ticket sort;
        for (int i = 0; i < len - 1; i++) {                                                // outer loop
            for (int j = 0; j < len - 1; j++) {                                            // inner nested loop pointing 1 index ahead
                if (ticketList.get(j).getPrice() > ticketList.get(j + 1).getPrice()) {     // checking elements
                    sort = ticketList.get(j);
                    ticketList.set(j, ticketList.get(j + 1));
                    ticketList.set(j + 1, sort);
                }
            }
        }System.out.println("\n");
        System.out.println("Sorted prices:");
        for (Ticket value : ticketList) {
            value.print();
            System.out.println();                                                                                 // printing sorted array elements
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------"); //sort ticket info border

    }
}