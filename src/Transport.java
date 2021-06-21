public class Transport {
    private String name;
    private String location;
    private int avgPrice;
    private String all;
    private String type;

    public Transport(String name, String location, int avgPrice, String type){
        this.name = name;
        this.location = location;
        this.avgPrice = avgPrice;
        this.type = type;
    }

    public String getName(){return this.name;}
    public String getLocation(){return this.location;}
    public int getAvgPrice(){return this.avgPrice;}
    public String getType(){return this.type;}

    public String toString(){
        this.all = this.name+", "+this.location+", "+this.avgPrice+", "+this.type;
        return this.all;
    }

}
