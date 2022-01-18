package culinary;

import com.company.Storage;

import java.util.*;

public class RestaurantDao {
    static Scanner myObj = new Scanner(System.in);
    static String restaurantsFilePath = "/home/giovanni/dev/java/data/restaurant.txt";

    public static void restaurantCrud(){
        int option;

        do {
            System.out.println("Kelola Data Restaurant:");
            System.out.println("------------");
            System.out.println("1. Menampilkan Daftar Restaurant");
            System.out.println("2. Tambah Restaurant");
            System.out.println("3. Hapus Restaurant");
            System.out.println("4. Update Restaurant");
            System.out.println("5. Update Menu Restaurant");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Pilih: ");
            option = Integer.parseInt(myObj.nextLine());
            try {
                switch (option) {
                    case 1:
                        System.out.println("Nama Resto" + "   " + "Menu"
                                + "  " + "Alamat"  + "  " + "Kota   ");
                        for (Restaurant r:Storage.restaurants){
                            System.out.print(r.getId()+ ". " + r.getName() + "  " );
                            for(Menu m : r.getMenus()){
                                if(r.getMenus().indexOf(m) == 0){
                                    System.out.print(m.getName() + "   ");
                                    System.out.print(r.getAddress() + "  " + r.getCity().getName() + " ");
                                    System.out.println(" ");
                                }else {
                                    System.out.println("            " +
                                            m.getName() + " ");
                                }
                            }
                            System.out.println("\n ------------------------------------- ");
                        }

                        break;
                    case 2:
                        addRestaurant();
                        break;
                    case 3:
                        deleteRestaurant();
                        break;
                    case 4:
                        updateRestaurant();
                        break;
                    case 5:
                        updateMenuRestaurant();
                        break;
                    case 0:
                        Storage.saveDataRestaurants(restaurantsFilePath);
                        break;
                    default:
                        System.out.println("Your choose is null, choose another!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(option != 0);
    }

    public static void addRestaurant(){
        String name, address, save;
        int cityId, menuId, restaurantMaxId, menuCount, menuIndex;
        City city = null;

        List<Menu> menusImport = new ArrayList<>();

        if(Storage.restaurants.size() == 0){
            restaurantMaxId = 1;
        }else{
            restaurantMaxId = (Collections.max(Storage.restaurants, Comparator.comparing(r -> r.getId()))).getId() + 1 ;
        }

        System.out.println("Tambah data: ");
        System.out.println("");
        System.out.print("Tuliskan nama restaurant: ");
        name = myObj.nextLine();
        System.out.print("Tuliskan alamat restaurant: ");
        address = myObj.nextLine();
        for (City c : Storage.cities){
            System.out.print(c.getId() + " " + c.getName() + "; ");
        }
        System.out.println("");
        System.out.print("Pilih kota restaurant (berdasarkan id kota): ");
        cityId = Integer.parseInt(myObj.nextLine());
        for (City c : Storage.cities){
            if (c.getId() == cityId){
                c.setNumOfRestaurant(c.getNumOfRestaurant()+1);
                System.out.println("Ok!");
                city = c;
            }
        }

        for (Menu m : Storage.menus){
            System.out.print(m.getId() + " " + m.getName() + "; ");
        }
        System.out.println("");
        System.out.print("Jumlah Menu: ");
        menuCount = Integer.parseInt(myObj.nextLine());
        for(int i =0; i < menuCount; i++){
            System.out.print("Pilih menu (berdasarkan id menu): ");
            menuId = Integer.parseInt(myObj.nextLine());
            for (Menu m : Storage.menus){
                if(m.getId() == menuId){
                    System.out.println("Ok!");
                    menusImport.add(m);
                    break;
                }
            }
        }
        System.out.print("Save? (Y/N)");
        save = myObj.nextLine();
        if (save.equalsIgnoreCase("y")) {
            Restaurant restaurant = new Restaurant(restaurantMaxId, name, address,
                    city, menusImport);
            Storage.restaurants.add(restaurant);
            System.out.println("Berhasil nambah!");
        }else{
            System.out.println("Gajadi Nambah!");
        }
    }


    public static void deleteRestaurant(){
        int id, indexDelete, cityId;
        List<Restaurant> restaurants = Storage.restaurants;

        indexDelete = -1;
        System.out.println("Delete Restaurant ");
        for (Restaurant r:Storage.restaurants){
            System.out.print(r.getId()+ " " + r.getName() + " ; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id: ");
        id = Integer.parseInt(myObj.nextLine());
        for(Restaurant r: restaurants){
            if(r.getId() == id){
                cityId = r.getCity().getId();
                for (City c : Storage.cities) {
                    if (c.getId() == cityId) {
                        c.setNumOfRestaurant(c.getNumOfRestaurant() - 1);
                    }
                }
                indexDelete = restaurants.indexOf(r);
                restaurants.remove(r);
                System.out.println("Berhasil ngapus");
                break;
           }
        }
        if(indexDelete < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }

    public static void updateRestaurant(){
        String name, address, save;
        int cityId, menuId, menuCount, indexUpdate, id, cityIdSubstract;
        City city = null;
        List<Menu> menusImport = new ArrayList<>();

        indexUpdate = -1;
        System.out.println("Update Restaurant ");
        for (Restaurant r:Storage.restaurants){
            System.out.print(r.getId()+ " " + r.getName() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id untuk diupdate: ");
        id = Integer.parseInt(myObj.nextLine());
        for(Restaurant r: Storage.restaurants){
            if(r.getId() == id){
                cityIdSubstract = r.getCity().getId();
                indexUpdate = Storage.restaurants.indexOf(r);
                System.out.print("Tuliskan nama update restaurant: ");
                name = myObj.nextLine();
                System.out.print("Tuliskan alamat restaurant: ");
                address = myObj.nextLine();
                for (City c : Storage.cities){
                    System.out.print(c.getId() + " " + c.getName() + "; ");
                }
                System.out.println("");
                System.out.print("Pilih kota restaurant (berdasarkan id kota): ");
                cityId = Integer.parseInt(myObj.nextLine());
                for (City c : Storage.cities){
                    if(c.getId() == cityIdSubstract){
                        c.setNumOfRestaurant(c.getNumOfRestaurant() - 1);
                    }
                    if (c.getId() == cityId) {
                        c.setNumOfRestaurant(c.getNumOfRestaurant() + 1);
                        System.out.println("Ok!");
                        city = c;
                    }
                }

                for (Menu m : Storage.menus){
                    System.out.print(m.getId() + " " + m.getName() + "; ");
                }
                System.out.println("");
                System.out.print("Jumlah Menu: ");
                menuCount = Integer.parseInt(myObj.nextLine());
                for(int i =0; i < menuCount; i++){
                    System.out.print("Pilih menu (berdasarkan id menu): ");
                    menuId = Integer.parseInt(myObj.nextLine());
                    for (Menu m : Storage.menus){
                        if(m.getId() == menuId){
                            System.out.println("Ok!");
                            menusImport.add(m);
                            break;
                        }
                    }
                }
                System.out.print("Save? (Y/N)");
                save = myObj.nextLine();
                if (save.equalsIgnoreCase("y")) {
                    Restaurant restaurant = new Restaurant(id, name, address,
                            city, menusImport);
                    Storage.restaurants.set(indexUpdate, restaurant);

                    System.out.println("Berhasil ngupdate!");
                }else{
                    System.out.println("Gajadi ngupdate!");
                }
                break;
            }
        }
        if(indexUpdate < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }

    public static void updateMenuRestaurant(){
        Menu newMenu;
        String  name, save;
        int id, menuMaxId;
        double price;

        for (Restaurant r:Storage.restaurants){
            System.out.print(r.getId()+ " " + r.getName() + " ");
            for(Menu m : r.getMenus()){
                System.out.print(m.getName() + ", ");
            }
            System.out.println("; ");
        }

        System.out.println("");
        System.out.print("Tuliskan id untuk diupdate: ");
        id = Integer.parseInt(myObj.nextLine());
        for(Restaurant r : Storage.restaurants){
            if(r.getId() == id){
                if(Storage.menus.size() == 0){
                    menuMaxId = 1;
                }else{
                    menuMaxId = (Collections.max(Storage.menus, Comparator.comparing(m -> m.getId()))).getId() + 1 ;
                }
                System.out.print("Tuliskan nama: ");
                name = myObj.nextLine();
                System.out.print("Tuliskan harga: ");
                price = Double.parseDouble(myObj.nextLine());
                System.out.print("Save? (Y/N)");
                save = myObj.nextLine();
                if (save.equalsIgnoreCase("y")) {
                    newMenu = new Menu(menuMaxId,name,price);
                    r.addMenu(newMenu);
                    System.out.println("Berhasil Update!");
                }else{
                    System.out.println("Gajadi Nambah!");
                }
            }
        }

    }
}

