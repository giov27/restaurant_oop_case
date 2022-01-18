package culinary;

import com.company.Storage;

import java.util.List;
import java.util.Scanner;

public class MenuDao {

    static Scanner myObj = new Scanner(System.in);
    static String menuFilePath = "/home/giovanni/dev/java/data/menu.txt";

    public static void menuCrud(){
        int option;

        do {
            System.out.println("Kelola Data Menu:");
            System.out.println("------------");
            System.out.println("1. Menampilkan Daftar Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Update Menu");
            System.out.println("0. Exit");
            System.out.println("");
            System.out.print("Pilih: ");
            option = Integer.parseInt(myObj.nextLine());
            try {
                switch (option) {
                    case 1:
                        for (Menu m:Storage.menus){
                            System.out.println(m.getId()+ " " + m.getName() + " " +
                                    m.getPrice());
                        }
                        break;
                    case 2:
                        addMenu();
                        break;
                    case 3:
                        deleteMenu();
                        break;
                    case 4:
                        updateMenu();
                        break;
                    case 0:
                        Storage.saveDataMenu(menuFilePath);
                        break;
                    default:
                        System.out.println("Your choose is null, choose another!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(option != 0);


    }

    public static void addMenu(){

        String name, save;
        double price;
        int id;

        System.out.println("Tambah data: ");
        for (Menu m : Storage.menus){
            System.out.print(m.getId() + " " + m.getName() + " " + m.getPrice() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id: ");
        id = Integer.parseInt(myObj.nextLine());
        System.out.print("Tuliskan nama: ");
        name = myObj.nextLine();
        System.out.print("Tuliskan harga: ");
        price = Double.parseDouble(myObj.nextLine());
        System.out.print("Save? (Y/N)");
        save = myObj.nextLine();
        if (save.equalsIgnoreCase("y")) {
            Menu menu = new Menu(id,name,price);
            Storage.menus.add(menu);
            System.out.println("Berhasil nambah!");
        }else{
            System.out.println("Gajadi Nambah!");
        }
    }

    public static void deleteMenu(){
        int id, indexDelete;
        List<Menu> menus = Storage.menus;

        indexDelete = -1;
        System.out.println("Delete Menu ");
        for (Menu m : Storage.menus){
            System.out.print(m.getId() + " " + m.getName() + " " + m.getPrice() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id: ");
        id = Integer.parseInt(myObj.nextLine());
        for(Menu m: menus){
            if(m.getId() == id){
                indexDelete = menus.indexOf(m);
                menus.remove(indexDelete);
                System.out.println("Berhasil ngapus");
            }
        }
        if(indexDelete < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }

    public static void updateMenu(){
        int id, indexUpdate;
        String name;
        double harga;
        Menu updateValue;
        List<Menu> menus = Storage.menus;

        indexUpdate = -1;
        System.out.println("Update Menu ");
        for (Menu m : Storage.menus){
            System.out.print(m.getId() + " " + m.getName() + " " + m.getPrice() + "; ");
        }
        System.out.println("");
        System.out.print("Tuliskan id untuk diupdate: ");
        id = Integer.parseInt(myObj.nextLine());
        for(Menu m: menus){
            if(m.getId() == id){
                indexUpdate = menus.indexOf(m);
                System.out.print("Tuliskan nama: ");
                name = myObj.nextLine();
                System.out.print("Tuliskan harga: ");
                harga = Double.parseDouble(myObj.nextLine());
                updateValue = new Menu(id, name, harga);
                menus.set(indexUpdate, updateValue);
                System.out.println("Berhasil ngupdate!");
            }
        }
        if(indexUpdate < 0){
            System.out.println("ID ga ada, masukkan yang ID lain!");
        }
    }
}
