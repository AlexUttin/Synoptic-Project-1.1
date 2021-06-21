public class Surrounding {
    private String location;
    private double distance;
    private String transport;
    private String all;

    public Surrounding(String location, double distance, String transport){
        this.location = location;
        this.distance = distance;
        this.transport = transport;
    }

    public String getLocation(){return this.location;}
    public double getDistance(){return this.distance;}
    public String getTransport(){return this.transport;}


    public String toString(){
        this.all = this.location+", "+this.distance+", "+this.transport;
        return this.all;
    }
}
