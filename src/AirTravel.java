public class AirTravel {
    private String route;
    private double hours;
    private int price;
    private String all;

    public AirTravel(String route, double hours, int price){
        this.route = route;
        this.hours = hours;
        this.price = price;
    }

    public String getRoute(){return this.route;}
    public double getHours(){return this.hours;}
    public int getPrice(){return this.price;}

    public String toString(){
        this.all = this.route+", "+this.hours+", "+this.price;
        return this.all;
    }
}
