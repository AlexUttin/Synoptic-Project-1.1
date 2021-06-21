public class Accommodation {
    private String location;
    private double distance;
    private String type;
    private double rating;
    private int ppn;
    private String all;
    private String nameAcom;

    public Accommodation(String nameAcom,String location, double distance, String type, double rating, int ppn){
        this.location = location;
        this.distance = distance;
        this.type = type;
        this.rating = rating;
        this.ppn = ppn;
        this.nameAcom = nameAcom;
    }

    public String getLocation(){return this.location;}
    public double getDistance(){return this.distance;}
    public String getType(){return this.type;}
    public double getRating(){return this.rating;}
    public int getPpn(){return this.ppn;}
    public String getNameAcom(){return this.nameAcom;}

    public String toString(){
        this.all = this.nameAcom+", "+this.location+", "+this.distance+", "+this.type+", "+this.rating+", "+this.ppn;
        return this.all;
    }

}
