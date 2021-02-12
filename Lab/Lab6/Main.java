package Lab.Lab6;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.nio.file.*;

class Customer {
    String name;
    int age;
    String username;
    Vector<Booking> bookings = new Vector<Booking>();
    static String filePath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Customers.txt";

    Customer(String name, int age, String username) {
        this.name = name;
        this.age = age;
        this.username = username;
    }

    public static synchronized void signUp() {
        String name;
        int age;
        String username;

        String password;

        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter username: ");
        username = scan.nextLine();
        System.out.println("Checking to see if username exists...");
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean usernameExists = false;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.substring(line.indexOf("username:") + 9, line.indexOf(",", line.indexOf("username:")));
                if (line.equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists) {
                System.out.println("Username exists! Please try again.");
            } else {
                System.out.println("Enter name: ");
                name = scan.nextLine();
                System.out.println("Enter age: ");
                age = scan.nextInt();
                System.out.println("Enter password: ");
                password = scan.nextLine();
                password = scan.nextLine();
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
                bufferedReader = new BufferedReader(new FileReader(filePath));
                if (bufferedReader.readLine() != null) {
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(
                        "username:" + username + "," + "name:" + name + "," + "age:" + age + "," + "password:" + password + ",");
                System.out.println("[+] User registered successfully");
                bufferedWriter.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Customer signIn() {
        String username;
        String password;
        String file_username;
        String file_password;
        int file_age = 0;
        String file_name = "";
        boolean correctPassword = false;
        Scanner scan = new Scanner(System.in);
        BufferedReader bufferedReader;
        System.out.println("Enter username: ");
        username = scan.nextLine();
        System.out.println(" Enter password: ");
        password = scan.nextLine();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                file_username = line.substring(line.indexOf("username:") + 9, line.indexOf(",", line.indexOf("username:")));
                file_password = line.substring(line.indexOf("password:") + 9, line.indexOf(",", line.indexOf("password:")));
                if (username.equals(file_username)) {
                    System.out.println("User Found");
                    file_age = Integer
                            .parseInt(line.substring(line.indexOf("age:") + 4, line.indexOf(",", line.indexOf("age:"))));
                    file_name = line.substring(line.indexOf("name:") + 5, line.indexOf(",", line.indexOf("name:")));
                    while (true) {
                        if (password.equals(file_password)) {
                            correctPassword = true;
                            System.out.println("Logging In ........");
                            break;
                        }
                        System.out.println("Please enter correct password!");
                        password = scan.nextLine();
                    }
                }
            }
            bufferedReader.close();
            if (!correctPassword) {
                System.out.println("New User!");
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (correctPassword) {
            return new Customer(file_name, file_age, username);
        } else {
            return null;
        }
    }

    public static Customer getCustomer(String username) {
        int age = 0;
        String name = "";
        String file_username;
        BufferedReader bufferedReader;
        Customer customer = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                file_username = line.substring(line.indexOf("username:") + 9, line.indexOf(",", line.indexOf("username:")));
                if (username.equals(file_username)) {
                    age = Integer.parseInt(line.substring(line.indexOf("age:") + 4, line.indexOf(",", line.indexOf("age:"))));
                    name = line.substring(line.indexOf("name:") + 5, line.indexOf(",", line.indexOf("name:")));
                }
                customer = new Customer(name, age, username);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }
}

class Hotel {
    String name;
    String city;
    int price;
    int totalRooms;
    int vacantRooms;

    public static Vector<Hotel> initHotels() {
        Vector<Hotel> hotels = new Vector<Hotel>();
        BufferedReader bufferedReader;
        String filePath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Hotels.txt";
        String line;
        Hotel hotel;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                hotel = new Hotel();
                hotel.city = line;
                line = bufferedReader.readLine();
                hotel.name = line;
                line = bufferedReader.readLine();
                hotel.price = Integer.parseInt(line);
                line = bufferedReader.readLine();
                hotel.totalRooms = Integer.parseInt(line);
                line = bufferedReader.readLine();
                hotel.vacantRooms = Integer.parseInt(line);
                line = bufferedReader.readLine();

                hotels.add(hotel);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public static synchronized void updateHotelVacancy(String hotelName, int vacancy) {
        String filePath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Hotels.txt";
        String tempPath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\temp.txt";
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            writer = new BufferedWriter(new FileWriter(tempPath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(hotelName)) {
                    writer.write(line);
                    writer.newLine();
                    line = reader.readLine();
                    writer.write(line);
                    writer.newLine();
                    line = reader.readLine();
                    writer.write(line);
                    writer.newLine();
                    line = reader.readLine();
                    writer.write(Integer.toString(vacancy));
                    writer.newLine();
                    line = reader.readLine();
                    writer.write(line);
                    writer.newLine();
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            reader.close();

            Path source = Paths.get(tempPath);
            Path dest = Paths.get(filePath);
            Files.delete(dest);
            Files.move(source, source.resolveSibling("C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Hotels.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Booking {
    String id;
    String username;
    int numOfRooms;
    int numOfPeople;
    Date startDate;
    Date endDate;
    String hotelName;

    public void showBooking() {
        Hotel h = null;
        for (Hotel hotel : Main.hotels) {
            if (hotel.name.equals(hotelName)) {
                h = hotel;
            }
        }
        Long diff = endDate.getTime() - startDate.getTime();
        int days = (diff.intValue() / (1000 * 60 * 60 * 24));
        int price = days * h.price * numOfRooms;

        System.out.println("Booking ID: " + id);
        System.out.println("Hotel: " + hotelName);
        System.out.println("Number of Rooms: " + numOfRooms);
        System.out.println("Number of People: " + numOfPeople);
        System.out.println("Check In Date: " + startDate);
        System.out.println("Check Out Date: " + endDate);
        System.out.println("-------------------------------------------");
        System.out.println("PRICE: " + price);

    }

    public static synchronized Booking setBooking(Hotel hotel, Customer currentUser) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String inputDate;
        boolean error = false;
        Booking booking = new Booking();
        booking.hotelName = hotel.name;
        booking.username = currentUser.username;
        System.out.println("Enter number of rooms: ");
        booking.numOfRooms = scan.nextInt();
        if (hotel.vacantRooms < booking.numOfRooms) {
            System.out.println("Rooms not available");
            return null;
        }
        System.out.println("Enter number of people: ");
        booking.numOfPeople = scan.nextInt();

        try {
            System.out.println("Enter start date (dd-MM-yyyy): ");
            inputDate = scan.nextLine();
            inputDate = scan.nextLine();
            booking.startDate = dateFormat.parse(inputDate);
            System.out.println("Enter end date (dd-MM-yyyy): ");
            inputDate = scan.nextLine();
            booking.endDate = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            error = true;
            System.out.println("Date entered in incorrect format\n");
            e.printStackTrace();
        }
        booking.id = UUID.randomUUID().toString();
        if (error) {
            return null;
        } else {
            BufferedWriter bufferedWriter;
            String filePath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Bookings.txt";
            File file = new File(filePath);
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
                if (file.length() != 0) {
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(booking.id);
                bufferedWriter.newLine();
                bufferedWriter.write(booking.username);
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(booking.numOfRooms));
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(booking.numOfPeople));
                bufferedWriter.newLine();
                bufferedWriter.write(dateFormat.format(booking.startDate));
                bufferedWriter.newLine();
                bufferedWriter.write(dateFormat.format(booking.endDate));
                bufferedWriter.newLine();
                bufferedWriter.write(booking.hotelName);
                bufferedWriter.newLine();
                bufferedWriter.write("-");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Hotel.updateHotelVacancy(booking.hotelName, hotel.totalRooms - booking.numOfRooms);
            return booking;
        }
    }

    public static void initUserBooking(Customer currentUser) {
        BufferedReader bufferedReader;
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String filePath = "C:\\Users\\amogh\\Desktop\\java-MUJ\\Lab\\Lab6\\Bookings.txt";

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            while ((line = bufferedReader.readLine()) != null) {
                Booking booking = new Booking();
                booking.id = line;
                line = bufferedReader.readLine();
                booking.username = line;
                line = bufferedReader.readLine();
                booking.numOfRooms = Integer.parseInt(line);
                line = bufferedReader.readLine();
                booking.numOfPeople = Integer.parseInt(line);
                line = bufferedReader.readLine();
                booking.startDate = dateFormat.parse(line);
                line = bufferedReader.readLine();
                booking.endDate = dateFormat.parse(line);
                line = bufferedReader.readLine();
                booking.hotelName = line;
                if (booking.username.equals(currentUser.username)) {
                    currentUser.bookings.add(booking);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

public class Main {
    static Vector<Hotel> hotels = new Vector<Hotel>();
    static Customer currentUser;

    public static void clearScreen() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Catch");
        }
    }

    public static void showHotels() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ". " + hotels.get(i).city + " - " + hotels.get(i).name);
        }
    }

    public static void bookRooms(Customer currentUser) {
        Scanner scan = new Scanner(System.in);
        hotels = Hotel.initHotels();
        showHotels();
        int choiceInt = scan.nextInt();
        if (choiceInt > hotels.size() || choiceInt < 1) {
            System.out.println("[!] Invalid Input");
            System.exit(0);
        }
        Hotel selectedHotel = hotels.get(choiceInt - 1);
        clearScreen();
        System.out.println("------------------------");
        System.out.println("City: " + selectedHotel.city);
        System.out.println("Name: " + selectedHotel.name);
        System.out.println("Price of a Room (per day): " + selectedHotel.price);
        System.out.println("Total Rooms: " + selectedHotel.totalRooms);
        System.out.println("Vacant Rooms: " + selectedHotel.vacantRooms);
        System.out.println("------------------------");
        System.out.println("Do you want to book rooms? [Y/N]");
        String choice = scan.nextLine();
        choice = scan.nextLine();
        if (!choice.equals("y") && !choice.equals("Y")) {
            return;
        }
        currentUser.bookings.add(Booking.setBooking(selectedHotel, currentUser));
    }

    public static void viewBookings() {
        if (currentUser.bookings.isEmpty()) {
            System.out.println(" No Bookings Found");
            return;
        }
        for (int i = currentUser.bookings.size() - 1; i >= 0; i--) {
            if (i == currentUser.bookings.size() - 1) {
                System.out.println("------------> NEW BOOKING <------------");
                currentUser.bookings.get(i).showBooking();
                System.out.println("______________________________________________");
                continue;
            }

            System.out.println("\n_____________________________________________");
            currentUser.bookings.get(i).showBooking();

        }
    }

    public static void main(String[] args) {
        String choice;
        Scanner scan = new Scanner(System.in);
        hotels = Hotel.initHotels();

        System.out.println("------ Hotel Booking ------");
        System.out.println("1. Sign In\n2. Register User");
        System.out.println("---------------------------");
        choice = scan.nextLine();
        if (choice.equals("2")) {
            Customer.signUp();
            currentUser = Customer.signIn();
        } else if (choice.equals("1")) {
            currentUser = Customer.signIn();
        } else {
            System.out.println("[!] Invalid Input");
            System.exit(0);
        }
        Booking.initUserBooking(currentUser);
        clearScreen();
        int choiceInt;
        while (true) {
            clearScreen();
            System.out.println("--------------------------------");
            System.out.println("1. Book Rooms\n2. View Bookings\n(press '-1' to exit)");
            System.out.println("--------------------------------");
            choiceInt = scan.nextInt();
            if (choiceInt == 1) {
                System.out.println("Select Hotel");
                System.out.println("--------------------------");
                bookRooms(currentUser);
            }

            else if (choiceInt == 2) {
                viewBookings();
            } else if (choiceInt == -1) {
                System.exit(0);
            }
        }
    }
}