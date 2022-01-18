package com.company;

import culinary.City;
import culinary.Menu;
import culinary.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Menu> menus = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();

    public static void saveDataMenu(String fileName){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Menu m: menus){
                objectOutputStream.writeObject(m);
            }

            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Menus Data has been saved Succesfully");
        }catch (IOException e){
            System.out.println("No menus data present to save in file " + e.toString());
        }
    }

    public static void loadDataMenu(String fileName){
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for(;; ) {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof Menu) {
                        menus.add((Menu) readObject);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();
            System.out.println("Menus data loaded successfully");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No menus data present to load from file" + e.toString());
        }
    }

    public static void saveDataCities(String fileName){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(City c: cities){
                objectOutputStream.writeObject(c);
            }

            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Cities Data has been saved Succesfully");
        }catch (IOException e){
            System.out.println("No cities data present to save in file " + e.toString());
        }
    }

    public static void loadDataCities(String fileName){
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for(;; ) {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof City) {
                        cities.add((City) readObject);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();
            System.out.println("Cities data loaded successfully");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No cities data present to load from file" + e.toString());
        }
    }

    public static void saveDataRestaurants(String fileName){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Restaurant c: restaurants){
                objectOutputStream.writeObject(c);
            }

            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Restaurants Data has been saved Succesfully");
        }catch (IOException e){
            System.out.println("No restaurants data present to save in file " + e.toString());
        }
    }

    public static void loadDataRestaurants(String fileName){
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for(;; ) {
                try {
                    Object readObject = objectInputStream.readObject();
                    if (readObject instanceof Restaurant) {
                        restaurants.add((Restaurant) readObject);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();
            System.out.println("Restaurants data loaded successfully");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No restaurants data present to load from file" + e.toString());
        }
    }


}
