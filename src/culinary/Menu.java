package culinary;

public class Menu implements java.io.Serializable {
    private String name;
    private double price;
    private int id;

    /**
     *
     * @param id
     * @param name
     * @param price
     */
    public Menu (int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){ this.name = name;}

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){ this.price = price;}
}
