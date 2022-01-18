package com.company;

import culinary.CityDao;
import culinary.MenuDao;
import culinary.RestaurantDao;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        RunApp runApp = new RunApp();
        runApp.showMenu();
    }

    private static class RunApp{
        MenuDao menuDao;
        String menuFilePath = "/home/giovanni/dev/java/data/menu.txt";
        String citiesFilePath = "/home/giovanni/dev/java/data/city.txt";
        String restaurantsFilePath = "/home/giovanni/dev/java/data/restaurant.txt";
        public RunApp(){
            this.menuDao = new MenuDao();
            Storage.loadDataMenu(menuFilePath);
            Storage.loadDataCities(citiesFilePath);
            Storage.loadDataRestaurants(restaurantsFilePath);
        }

        void showMenu() throws SQLException {
            Scanner myObj = new Scanner(System.in);

            int option;
            do {
                System.out.println("Kelola Data:");
                System.out.println("------------");
                System.out.println("1. Data Restaurant");
                System.out.println("2. Data Menu");
                System.out.println("3. Data Kota");
                System.out.println("0. Exit");
                System.out.println("");
                System.out.print("Pilih: ");
                option = Integer.parseInt(myObj.nextLine());
                try {
                    switch (option) {
                        case 1:
                            RestaurantDao.restaurantCrud();
                            break;
                        case 2:
                            MenuDao.menuCrud();
                            break;
                        case 3:
                            CityDao.cityCrud();
                            break;
                        case 0:
                            System.out.println("Thanks for using our database");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Your choose is null, choose another!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }while(option != 0);


        }

    }
}
