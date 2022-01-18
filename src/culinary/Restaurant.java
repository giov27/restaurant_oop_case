package culinary;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements java.io.Serializable{
    private String name, address;
    int id;
    private City city;
    private List<Menu> menus = new ArrayList<Menu>();

    public Restaurant(int id, String name, String address, City city, List<Menu> menus){
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.menus = menus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName(){return name;}

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){return address;}

    public void setAddress(String address){
        this.address = address;
    }

    public List<Menu> getMenus(){return menus;}

    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

}
