package culinary;

import com.company.Storage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CityDao {
    static Scanner myObj = new Scanner(System.in);
    static String citiesFilePath = "/home/giovanni/dev/java/data/city.txt";

    public static void cityCrud(){
        int option;

        do {
            System.out.println("Kelola Data Kota:");
            System.out.println("------------");
            System.out.println("1. Menampilkan Daftar Kota");
            System.out.println("2. Tambah Kota");
            System.out.println("3. Hapus Kota");
            System.out.println("4. Update Kota");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Pilih: ");
            option = Integer.parseInt(myObj.nextLine());
            try {
                switch (option) {
                    case 1:
                        for (City m: Storage.cities){
                            System.out.println(m.getId()+ " " + m.getName() + " " +
                                    m.getNumOfRestaurant());
                        }
                        break;
                    case 2:
                        addCity();
                        break;
                    case 3:
                        deleteCity();
                        break;
                    case 4:
                        updateCity();
                        break;
                    case 0:
                        Storage.saveDataCities(citiesFilePath);
                        break;
                    default:
                        System.out.println("Your choose is null, choose another!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(option != 0);
    }
    public static void addCity(){
        String name, save;
//        int id;
        int cityMaxId ;


        System.out.println("Tambah data: ");
        for (City c : Storage.cities){
            System.out.print(c.getId() + " " + c.getName() + " " + c.getNumOfRestaurant() + "; ");
        }
        System.out.println("");
        if(Storage.cities.size() == 0){
            cityMaxId = 1;
        }else{
            cityMaxId = (Collections.max(Storage.cities, Comparator.comparing(c -> c.getId()))).getId() + 1 ;
        }
        System.out.print("Tuliskan nama: ");
        name = myObj.nextLine();
        System.out.print("Save? (Y/N)");
        save = myObj.nextLine();
        if (save.equalsIgnoreCase("y")) {
            City city = new City(cityMaxId ,name);
            Storage.cities.add(city);
            System.out.println("Berhasil nambah!");
        }else{
            System.out.println("Gajadi Nambah!");
        }
    }

    public static void deleteCity(){
        int id, indexDelete;
        List<City> cities = Storage.cities;

        indexDelete = -1;
        System.out.println("Delete City ");
        for (City c : Storage.cities){
            System.out.print(c.getId() + " " + c.getName() + " " + c.getNumOfRestaurant() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id: ");
        id = Integer.parseInt(myObj.nextLine());
        for(City c: cities){
            if(c.getId() == id){
                indexDelete = cities.indexOf(c);
                cities.remove(indexDelete);
                System.out.println("Berhasil ngapus");
                break;
            }
        }
        if(indexDelete < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }

    public static void updateCity(){
        int id, numOfRestaurant, indexUpdate;
        String name;
        City updateValue;
        List<City> cities = Storage.cities;

        indexUpdate = -1;
        System.out.println("Update City ");
        for (City c : Storage.cities){
            System.out.print(c.getId() + " " + c.getName() + " " + c.getNumOfRestaurant() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id untuk diupdate: ");
        id = Integer.parseInt(myObj.nextLine());
        for(City c: cities){
            if(c.getId() == id){
                numOfRestaurant = c.getNumOfRestaurant();
                indexUpdate = cities.indexOf(c);
                System.out.print("Tuliskan nama kota: ");
                name = myObj.nextLine();
                updateValue = new City(id, name, numOfRestaurant);
                cities.set(indexUpdate, updateValue);
                System.out.println("Berhasil ngupdate!");
                break;
            }
        }
        if(indexUpdate < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }
}
