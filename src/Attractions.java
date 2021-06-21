public class Attractions {
    private String name;
    private double rating;
    private String type;
    private String location;
    private String all;

    public Attractions(String name, double rating, String type, String location){
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.location = location;
    }

    public String getName(){return this.name;}
    public double getRating(){return this.rating;}
    public String getType(){return this.type;}
    public String getLocation(){return this.location;}

    public String toString(){
        this.all = this.name+", "+this.rating+", "+this.type+", "+this.location;
        return this.all;
    }
}