package culinary;

public class City implements java.io.Serializable {
    private String name;
    private int numOfRestaurant, id;
    public City(int id, String name, int numOfrestaurant){
        this.id = id;
        this.name = name;
        this.numOfRestaurant = numOfrestaurant;
    }


    public City(int id, String name){
        this.id = id;
        this.name = name;
        this.numOfRestaurant = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getNumOfRestaurant(){
        return numOfRestaurant;
    }
    public void setNumOfRestaurant(int numOfRestaurant){
        this.numOfRestaurant = numOfRestaurant;
    }
}
