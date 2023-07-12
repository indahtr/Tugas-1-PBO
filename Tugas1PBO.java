package IN;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Restaurant> restaurants = new ArrayList<>();
    public static ArrayList<Order> order = new ArrayList<>();
    private static String adminUsername = "admin";
    private static String adminPassword = "password";
    private static String customerUsername = "customer";
    private static String customerPassword = "password";
    
    public static void main(String[] args) throws IOException, InterruptedException{
        
        awal();
        loginMenu(scanner);
    }

    private static void awal() throws IOException, InterruptedException{

        System.out.println(
            "\n\t==============================================================" +
            "\n\t||                 WELCOME TO MY APPLICATION                ||" + 
            "\n\t||                          E-FOOD                          ||" + 
            "\n\t||==========================================================||" + 
            "\n\t||         PANDE KOMANG INDAH TRIROSHANTI(2205551053)       ||" + 
            "\n\t||----------------------------------------------------------||" 
            "\n\t||                  PRESS ENTER TO CONTINUE                 ||" +
            "\n\t=============================================================="
            );
        close();
    }
    public static void close() throws IOException, InterruptedException {
       
        System.in.read();
        System.out.println("\n\tNext...");
        System.out.println("\n\tPress Enter to Continue...");
        System.in.read();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    private static void loginMenu(Scanner scanner) throws IOException, InterruptedException{

        boolean isDone = false;
        while(!isDone){
            System.out.println(
                "\n\t==============================================================" +
                "\n\t||                 Selamat Datang Di Program                ||" +
                "\n\t||                          E-FOOD                          ||" + 
                "\n\t||``````````````````````````````````````````````````````````||" +
                "\n\t||                          LOG IN                          ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| LOGIN SEBAGAI                                            ||" + 
                "\n\t||==========================================================||" + 
                "\n\t||                                                          ||" + 
                "\n\t|| [1]. ADMIN                                               ||" + 
                "\n\t|| [2]. COSTUMER                                            ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| [0]. EXIT PROGRAM                                        ||" + 
                "\n\t||==========================================================||"  
            );
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| ENTER YOUR CHOICE :" 
            );
                
            int choice = scanner.nextInt();
            
            close();
            switch(choice){
                case 1:
                    loginAdmin(scanner);
                    break;
                case 2:
                    loginCustomer(scanner);
                    break;
                default:
                    isDone = true;
                    System.out.println(
                        "\n\t==============================================================" +
                        "\n\t||                 WELCOME TO MY APPLICATION                ||" +
                        "\n\t||                          E-FOOD                          ||" + 
                        "\n\t||``````````````````````````````````````````````````````````||" +
                        "\n\t||                          LOG IN                          ||" + 
                        "\n\t||==========================================================||" + 
                        "\n\t||                         Thank You !                      ||" + 
                        "\n\t||==========================================================||"  
                    );
                    break;
            }
        }
    }
    private static void loginAdmin(Scanner scanner) throws IOException, InterruptedException{

        boolean isLoggedIn = false;
        String username, password;
        while (!isLoggedIn) {
        System.out.print(
            "\n\t||==========================================================||" + 
            "\n\t|| ENTER YOUR USERNAME : "                                   
        );
                        
        username = scanner.next();
            
        System.out.print(
            "\t|| ENTER YOUR PASSWORD : " 
        );
            
        password = scanner.next();
            
        System.out.print(
            "\t||==========================================================||"
        );
        close();
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            isLoggedIn = true;
            System.out.println(
                "\n\t==============================================================" +
                "\n\t||                 WELCOME TO MY APPLICATION                ||" +
                "\n\t||                          E-FOOD                          ||" + 
                "\n\t||``````````````````````````````````````````````````````````||" +
                "\n\t||                          LOG IN                          ||" + 
                "\n\t||==========================================================||" + 
                "\n\t||       YOU HAVE SUCCESSFULLY LOGGED IN AS AN ADMIN        ||" + 
                "\n\t||==========================================================||"  
            ); 
            close();
            adminMenu(scanner);
            }else {
                System.out.println(
                    "\n\t==============================================================" +
                    "\n\t||                 WELCOME TO MY APPLICATION                ||" +
                    "\n\t||                          E-FOOD                          ||" + 
                    "\n\t||``````````````````````````````````````````````````````````||" +
                    "\n\t||                          LOG IN                          ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t||      INVALID USERNAME OR PASSWORD. PLEASE TRY AGAIN      ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t|| [0]. EXIT PROGRAM                                        ||" + 
                    "\n\t||==========================================================||"  
                ); 
                int choice = scanner.nextInt();
                close();
                if(choice == 0) loginMenu(scanner);
            }
        }
    }
    private static void adminMenu(Scanner scanner2) throws IOException, InterruptedException {

        boolean isDone = false;
        while (!isDone) {
            System.out.println(
                "\n\t||==========================================================||" + 
                "\n\t|| ADMIN MENU                                               ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| [1]. VIEW RESTAURANT                                     ||" + 
                "\n\t|| [2]. ADD RESTAURANT                                      ||" + 
                "\n\t|| [3]. REMOVE RESTAURANT                                   ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| [0]. EXIT PROGRAM                                        ||" + 
                "\n\t||==========================================================||"  
            );
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| ENTER YOUR CHOICE :" 
            );
            int choice = scanner2.nextInt();
            close();
            switch (choice) {
                case 1:
                    viewRestaurants();
                    break;
                case 2:
                    addRestaurant(scanner);
                    break;
                case 3:
                    removeRestaurant(scanner);
                    break;
                case 0:
                    isDone = true;
                    System.out.print(
                        "\n\t||==========================================================||" + 
                        "\n\t|| YOU HAVE SUCCESSFULLY LOGGED OUT                         ||" + 
                        "\n\t||==========================================================||"
                    );
                    break;
                default:
                    System.out.print(
                        "\n\t||==========================================================||" + 
                        "\n\t|| INVALID CHOICE. PLEASE TRY AGAIN.                        ||" + 
                        "\n\t||==========================================================||"
                    );
                    break;
            }
        }
    }
    private static void viewRestaurants() throws IOException, InterruptedException {

        if (restaurants.size() == 0) {
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| THERE ARE NO RESTAURANT                                  ||" + 
                "\n\t||==========================================================||"
                );
            close();
        } else {
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| RESTAURANT                                               ||" + 
                "\n\t||==========================================================||" +
                "\n\t|| ID ||       RESTAURANT NAMES                             "  

            ); 
            for (int i = 0; i < restaurants.size(); i++) {
                System.out.print(
                    "\n\t||  " + (i+1) + ".\t" + restaurants.get(i).getName().toUpperCase() + 
                    "\n\t|| \t" + "Menu :" + 
                    "\n\t|| \t" + (1) + ". " + restaurants.get(i).menu.food + ", " + restaurants.get(i).menu.priceFood +
                    "\n\t|| \t" + (2) + ". " + restaurants.get(i).menu.drink + ", " + restaurants.get(i).menu.priceDrink
                );
            }
            System.out.print(
                "\n\t||==========================================================||"
            );
        }
    }
    private static void addRestaurant(Scanner scanner) throws IOException, InterruptedException {

        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE NAME OF RESTAURANT: "
        );
        String name = scanner.next();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE ADDRESS OF RESTAURANT: "
        );
        String address = scanner.next();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE FOOD OF RESTAURANT: "
        );
        String food = scanner.next();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE DRINK OF RESTAURANT: "
        );
        String drink = scanner.next();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE PRICE OF FOOD: Rp."
        );
        int priceFood = scanner.nextInt();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE PRICE OF DRINK: Rp."
        );
        int priceDrink = scanner.nextInt();
        restaurants.add(new Restaurant(name, address, new Menu(food, drink, priceFood, priceDrink)));
            
        System.out.println(
            "\n\t||==========================================================||"+
            "\n\t|| " + name.toUpperCase() + " HAS BEEN ADDED TO THE LIST OF RESTAURANT "+
            "\n\t||==========================================================||"
        );
        close();
    }
    private static void removeRestaurant(Scanner scanner2) throws IOException, InterruptedException {

        viewRestaurants();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER THE NUMBER OF THE RESTAURANT YOU WANT TO REMOVE: "
        );
        int choice = scanner2.nextInt();
            
        if (choice < 1 || choice > restaurants.size()) {
            System.out.print(
                "\n\t||==========================================================||"+
                "\n\t|| INVALID CHOICE. PLEASE TRY AGAIN.                        ||"+
                "\n\t||==========================================================||"
            );
        } else {
            String name = restaurants.get(choice-1).getName();
            restaurants.remove(choice-1);
            System.out.print(
                "\n\t||==========================================================||"+
                "\n\t|| " + name.toUpperCase() + " HAS BEEN REMOVED FROM THE LIST OF THE RESTAURANT."+
                "\n\t||==========================================================||"
            );
        }
        close();
    }
    private static void loginCustomer(Scanner scanner) throws IOException, InterruptedException{

        boolean isLoggedIn = false;
        String username, password;
        while (!isLoggedIn) {
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| ENTER YOUR USERNAME : "                                   
                );
            username = scanner.next();
                
            System.out.print(
                "\t|| ENTER YOUR PASSWORD : " 
            );
            password = scanner.next();
                    
            System.out.print(
                    "\t||==========================================================||"
            );
            close();
            if (username.equals(customerUsername) && password.equals(customerPassword)) {
                isLoggedIn = true;
                System.out.println(
                    "\n\t==============================================================" +
                    "\n\t||                 WELCOME TO MY APPLICATION                ||" +
                    "\n\t||                          E-FOOD                          ||" + 
                    "\n\t||``````````````````````````````````````````````````````````||" +
                    "\n\t||                          LOG IN                          ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t|| YOU HAVE SUCCESSFULLY LOGGED IN AS CUSTOMER              ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t|| [0]. EXIT PROGRAM                                        ||" + 
                    "\n\t||==========================================================||"  
                );
                close();
                customerMenu(scanner);
            } else {
                System.out.println(
                    "\n\t==============================================================" +
                    "\n\t||                 WELCOME TO MY APPLICATION                ||" +
                    "\n\t||                          E-FOOD                          ||" + 
                    "\n\t||``````````````````````````````````````````````````````````||" +
                    "\n\t||                          LOG IN                          ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t|| INVALID USERNAME OR PASSWORD. PLEASE TRY AGAIN           ||" + 
                    "\n\t||==========================================================||" + 
                    "\n\t|| [0]. EXIT PROGRAM                                        ||" + 
                    "\n\t||==========================================================||"  
                );
                int choice = scanner.nextInt();
                close();
                if(choice == 0) loginMenu(scanner);
            }
        }
    }
    private static void customerMenu(Scanner scanner2) throws IOException, InterruptedException {

        boolean isDone = false;
        while (!isDone) {
            System.out.println(
                "\n\t||==========================================================||" + 
                "\n\t|| CUSTOMER MENU                                            ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| [1]. VIEW RESTAURANT                                     ||" + 
                "\n\t|| [2]. MAKE AN ORDER                                       ||" + 
                "\n\t|| [3]. VIEW ORDER                                          ||" + 
                "\n\t|| [4]. TOTAL ORDER                                          ||" + 
                "\n\t||==========================================================||" + 
                "\n\t|| [0]. EXIT PROGRAM                                      ||" + 
                "\n\t||==========================================================||"  
            );
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| ENTER YOUR CHOICE :" 
            );
            int choice = scanner2.nextInt();
            close();
            switch (choice) {
                case 1:
                    viewRestaurants();
                    break;
                case 2:
                    makeAnOrder(scanner);
                    break;
                case 3:
                    viewOrder();
                    break;
                case 4:
                    totalOrder();
                    break;
                case 0:
                    isDone = true;
                    System.out.print(
                        "\n\t||==========================================================||" + 
                        "\n\t|| YOU HAVE SUCCESSFULLY LOGGED OUT                         ||" + 
                        "\n\t||==========================================================||"
                    );
                    break;
                default:
                    System.out.print(
                        "\n\t||==========================================================||" + 
                        "\n\t|| INVALID CHOICE. PLEASE TRY AGAIN.                        ||" + 
                        "\n\t||==========================================================||"
                    );
                    break;
            }
        }
    }
    private static void viewOrder() throws IOException, InterruptedException {

        if(order.size() == 0){
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| THERE ARE NO ORDER                                       ||" + 
                "\n\t||==========================================================||"
            );
            close();
        }else{
            System.out.print(
                "\n\t||==========================================================||" + 
                "\n\t|| ORDER                                                    ||" + 
                "\n\t||==========================================================||" +
                "\n\t|| ID RESTAURANT || ID MENU || QAUANTITY || DISTANCE || TOTAL      "  
            ); 
            for(int i = 0; i < order.size(); i++){
                System.out.println(
                    "\n\t||\t " + order.get(i).id_restaurant + "\t\t" + order.get(i).id_menu + "\t  " +
                    order.get(i).quantity + "\t\t" + (int)order.get(i).distance  + " km " + "\tRp." + order.get(i).total_price
                );
            }
        }
    }
    private static void makeAnOrder(Scanner scanner) throws IOException, InterruptedException {

        viewRestaurants();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER ID OF THE RESTAURANT :"
        );
        int id_restaurant = scanner.nextInt();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER ID OF THE MENU : "
        );
        int id_menu = scanner.nextInt();
        System.out.print(
            "\n\t||==========================================================||"+
            "\n\t|| ENTER QUANTITY FOOD : "
        );
        int quantity = scanner.nextInt();
        order.add(
            new Order(
                id_restaurant, 
                id_menu, 
                quantity, 
                1 + Math.random()*10, 
                id_menu == 1?restaurants.get(id_restaurant-1).menu.priceFood*quantity : restaurants.get(id_restaurant-1).menu.priceDrink*quantity 
            )
        );
        close();
    }
    public static void totalOrder() throws IOException, InterruptedException{

        viewOrder();
        int allPrice = 0;
        for(int i = 0; i < order.size(); i++){
            allPrice += order.get(i).total_price;
        }
        System.out.print(
            "\n\t||Total Order\t\t\t\t\t\tRp." + allPrice
        );
        close();
    }
    
}

class Restaurant{

    String name;
    String address;
    Menu menu;
    int id = 1;
    public Restaurant(String name, String address, Menu menu) {

        this.name = name;
        this.address = address;
        this.menu = menu;
        id++;
    }

    public String getName() {

        return this.name;
    }
}
class Menu{

    String food;
    String drink;
    double priceFood;
    double priceDrink;

    public Menu(String food, String drink, double priceFood, double priceDrink){

        this.food = food;
        this.drink = drink;
        this.priceFood = priceFood;
        this.priceDrink = priceDrink;
    }

    public String getFood(){

        return this.food;
    }

    public String getDrink(){

        return this.drink;
    }

    public double getPriceFood(){

        return this.priceFood;
    }

    public double getPriceDrink(){

        return this.priceDrink;
    }
}
class Order{ 

    int id_restaurant;
    int id_menu;
    int quantity;
    double distance;
    double total_price;

    public Order(int id_restaurant, int id_menu, int quantity, double distance, double total_price){

        this.id_restaurant = id_restaurant;
        this.id_menu = id_menu;
        this.quantity = quantity;
        this.distance = distance;
        this.total_price = total_price;
    }
}