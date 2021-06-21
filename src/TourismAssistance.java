import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TourismAssistance {
    public ArrayList<Accommodation> AccommodationList;
    public ArrayList<Surrounding> SurroundingList;
    public ArrayList<Attractions> AttractionsList;
    public ArrayList<Transport> TransportList;
    public ArrayList<AirTravel> AirTravelList;
    public ArrayList<String> eventPlanner;
    public ArrayList<Accommodation> AccommodationListLocal;
    public ArrayList<Attractions> AttractionsListFood;
    public ArrayList<Transport> TransportLocal;
    //ArrayLists included here are needed throughout the program but no more is needed after this
    static File surroundingFile = new File("Surrounding.txt");
    static File accommodationFile = new File("Accommodation.txt");
    static File attractionsFile = new File("Attractions.txt");
    static File transportFile = new File("Transport.txt");
    static File airTravelFile = new File("AirTravel.txt");
    //All files that store information
    private String locationName;

    public TourismAssistance(String locationName){
        this.AccommodationList = new ArrayList<>();
        this.SurroundingList = new ArrayList<>();
        this.AttractionsList = new ArrayList<>();
        this.TransportList = new ArrayList<>();
        this.AirTravelList = new ArrayList<>();
        this.eventPlanner = new ArrayList<>();
        this.AttractionsListFood = new ArrayList<>();
        this.AccommodationListLocal = new ArrayList<>();
        this.TransportLocal = new ArrayList<>();
        this.locationName = locationName;
    }

    public void initialiseData() throws FileNotFoundException {//Uses lineScanners and fileScanners to put information into
        //a object which is added to an ArrayList.
        Scanner fileScanner = new Scanner(surroundingFile);//uses Scanner to get the information line by line.
        fileScanner.useDelimiter(System.lineSeparator());
        Scanner lineScanner;
        String line;
        String location,transport;
        double distance;
        while (fileScanner.hasNext()){
            line = fileScanner.next();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            location = lineScanner.next();
            distance = Double.parseDouble(lineScanner.next());
            transport = lineScanner.next();
            this.SurroundingList.add(new Surrounding(location,distance,transport));
        }

        Scanner fileScanner1 = new Scanner(accommodationFile);//uses Scanner to get the information line by line.
        fileScanner1.useDelimiter(System.lineSeparator());
        Scanner lineScanner1;
        String line1;
        String location1,type,nameAcom;
        double distance1,rating;
        int ppn;
        while (fileScanner1.hasNext()){
            line1 = fileScanner1.next();
            lineScanner1 = new Scanner(line1);
            lineScanner1.useDelimiter(",");
            nameAcom = lineScanner1.next();
            location1 = lineScanner1.next();
            distance1 = Double.parseDouble(lineScanner1.next());
            type = lineScanner1.next();
            rating = Double.parseDouble(lineScanner1.next());
            ppn = Integer.parseInt(lineScanner1.next());
            this.AccommodationList.add(new Accommodation(nameAcom,location1,distance1,type,rating,ppn));
        }
        for(int i=0;i<this.AccommodationList.size();i++){//There are a few ArrayLists where the information is already in the "parent"
            //ArrayList but needs to be added to a secondary ArrayList, for example AccommodationListLocal
            if(this.AccommodationList.get(i).getLocation().equals(this.locationName)){
                this.AccommodationListLocal.add(new Accommodation(this.AccommodationList.get(i).getNameAcom(),
                        this.AccommodationList.get(i).getLocation(), this.AccommodationList.get(i).getDistance(),
                        this.AccommodationList.get(i).getType(), this.AccommodationList.get(i).getRating(),
                        this.AccommodationList.get(i).getPpn()));
            }
        }

        Scanner fileScanner2 = new Scanner(attractionsFile);//uses Scanner to get the information line by line.
        fileScanner2.useDelimiter(System.lineSeparator());
        Scanner lineScanner2;
        String line2;
        String name,type1,location2;
        double rating1;
        while (fileScanner2.hasNext()){
            line2 = fileScanner2.next();
            lineScanner2 = new Scanner(line2);
            lineScanner2.useDelimiter(",");
            name = lineScanner2.next();
            rating1 = Double.parseDouble(lineScanner2.next());
            type1 = lineScanner2.next();
            location2 = lineScanner2.next();
            this.AttractionsList.add(new Attractions(name,rating1,type1,location2));
        }
        for(int i=0;i<this.AttractionsList.size();i++){
            if(this.AttractionsList.get(i).getType().equals("Restaurant") || this.AttractionsList.get(i).getType().equals("Takeaway")
                    ||this.AttractionsList.get(i).getType().equals("Cafe")){
                this.AttractionsListFood.add(new Attractions(this.AttractionsList.get(i).getName(), this.AttractionsList.get(i).getRating(),
                        this.AttractionsList.get(i).getType(), this.AttractionsList.get(i).getLocation()));
            }
        }

        Scanner fileScanner3 = new Scanner(transportFile);//uses Scanner to get the information line by line.
        fileScanner3.useDelimiter(System.lineSeparator());
        Scanner lineScanner3;
        String line3;
        String name2,location3;
        String type2;
        int avgPrice;
        while (fileScanner3.hasNext()){
            line3 = fileScanner3.next();
            lineScanner3 = new Scanner(line3);
            lineScanner3.useDelimiter(",");
            name2 = lineScanner3.next();
            location3 = lineScanner3.next();
            avgPrice = Integer.parseInt(lineScanner3.next());
            type2 = lineScanner3.next();
            this.TransportList.add(new Transport(name2,location3,avgPrice,type2));
        }
        for(int i=0;i<this.TransportList.size();i++){
            if(this.TransportList.get(i).getLocation().equals(this.locationName)){
                this.TransportLocal.add(new Transport(this.TransportList.get(i).getName(),this.TransportList.get(i).getLocation(),
                        this.TransportList.get(i).getAvgPrice(),this.TransportList.get(i).getType()));
            }
        }

        Scanner fileScanner4 = new Scanner(airTravelFile);
        fileScanner4.useDelimiter(System.lineSeparator());
        Scanner lineScanner4;
        String line4;
        String name3;
        double hours;
        int price;
        while(fileScanner4.hasNext()){
            line4 = fileScanner4.next();
            lineScanner4 = new Scanner(line4);
            lineScanner4.useDelimiter(",");
            name3 = lineScanner4.next();
            hours = Double.parseDouble(lineScanner4.next());
            price = Integer.parseInt(lineScanner4.next());
            this.AirTravelList.add(new AirTravel(name3,hours,price));
        }
        fileScanner.close();
        fileScanner1.close();
        fileScanner2.close();
        fileScanner3.close();
        fileScanner4.close();
    }

    //A series of Getters for the ArrayLists
    //The boolean variable here is used for tourismPlanner
    //A true boolean will add a number to the start of the information so that it is displayed as a list.
    public void getAccommodation(boolean planner) {
        int i = this.AccommodationList.size();
        int j = 0;
        while (j < i) {
            if (planner) {
                System.out.println(String.valueOf(j+1)+". " + this.AccommodationList.get(j).toString());
                j++;
            } else {
                System.out.println(this.AccommodationList.get(j).toString());
                j++;
            }
        }
    }

    public void getSurrounding(boolean planner){
        int a = SurroundingList.size();
        int b = 0;
        while(b<a){
            if(planner){
                System.out.println(String.valueOf(b+1)+". "+this.SurroundingList.get(b).toString());
                b++;
            }else {
                System.out.println(this.SurroundingList.get(b).toString());
                b++;
            }
        }
    }

    public void getAttraction(boolean planner){
        int c = AttractionsList.size();
        int d = 0;
        while(d<c){
            if(planner){
                System.out.println(String.valueOf(d+1)+". "+AttractionsList.get(d).toString());
                d++;
            }else {
                System.out.println(AttractionsList.get(d).toString());
                d++;
            }
        }
    }

    public void getTransport(boolean planner){
        int e = this.TransportList.size();
        int f = 0;
        while(f<e){
            if(planner) {
                System.out.println(String.valueOf(f+1)+". "+this.TransportList.get(f).toString());
                f++;
            }else{
                System.out.println(this.TransportList.get(f).toString());
            }
        }
    }

    public void getAirTravel(){
        int g = AirTravelList.size();
        int h = 0;
        while(h<g){
            System.out.println(AirTravelList.get(h).toString());
            h++;
        }
    }

    //This is the travelPlanner
    public void travelPlanner(){
        eventPlanner.add("Day 1");//The planner always starts with day 1 and has accommodation on this day as the whole day will
        //likely be taken up with travel
        String tempStore;
        System.out.println("Welcome to the Travel Planner!\nThe Travel Planner will allow you to plan a trip day by day," +
                "Lets choose your accommodation.");
        System.out.println("How many nights will you be staying? ");
        Scanner myObj12 = new Scanner(System.in);
        System.out.println("Please input: ");
        int userChoice12 = Integer.parseInt(myObj12.nextLine());
        accommodationInformation(true);
        System.out.println("Please Select the number of the Accommodation you are staying in. ");
        System.out.println("If you are booking from the "+this.locationName+" only list, please input: 2, " +
                "if you are booking from the general area please input: 1");
        Scanner myObj10 = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice10 = Integer.parseInt(myObj10.nextLine());
        if(userChoice10==1){
            System.out.println("Please Select the number of the Accommodation you are staying in. ");
            Scanner myObj11 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice11 = Integer.parseInt(myObj11.nextLine());
            tempStore = this.AccommodationList.get(userChoice11-1).toString() + " Overall Price: "+
                    String.valueOf((this.AccommodationList.get(userChoice11-1).getPpn()*userChoice12));
            System.out.println(tempStore);
            eventPlanner.add(tempStore);
        }else if(userChoice10==2){//This is an example of where AccommodationListLocal
            System.out.println("Please Select the number of the Accommodation you are staying in. ");
            Scanner myObj13 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice13 = Integer.parseInt(myObj13.nextLine());
            tempStore = this.AccommodationListLocal.get(userChoice13-1).toString()+" Overall Price: "+
                    String.valueOf((this.AccommodationListLocal.get(userChoice13-1).getPpn()*userChoice12));
            System.out.println(tempStore);
            eventPlanner.add(tempStore);
        }
        System.out.println("Day 1 is always taken up with travel so now the planner will help with the other "+
                String.valueOf(userChoice12-1)+" days\nEach day will allow you to choose from Attractions and Transport");
        int dayCount;
        for(int i=0;i<userChoice12-2;i++){
            dayCount = (userChoice12+(-userChoice12+(i+2)));
            System.out.println("Day "+dayCount);//Day count is needed as day 1 and the last day is taken up by travelling back.
            eventPlanner.add("Day "+dayCount);
            System.out.println("Please Choose transport from the list, if you would not like to choose any transport," +
                    " please input: 999");
            plannerTransport(true);
            Scanner myObj14 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice14 = Integer.parseInt(myObj14.nextLine());
            if(userChoice14==999){
                eventPlanner.add("No Transport selected");
                System.out.println("No Transport selected");
            }else{
                String transport;
                transport = this.TransportList.get(userChoice14-1).toString();
                eventPlanner.add(transport);//eventPlanner is the arrayList that stores all the information relating the TourismPlanner
            }
            System.out.println("Now please add an activity from the attractions list");
            attractionInformation(true);
            Scanner myObj15 = new Scanner(System.in);
            System.out.println("If you choose all attractions input 1, if only restaurants 2 and 999 " +
                    "if you would not like to choose anything: ");
            int userChoice15 = Integer.parseInt(myObj15.nextLine());
            if(userChoice15==1){
                Scanner myObj16 = new Scanner(System.in);
                System.out.println("Please Select what attraction you have chosen: ");
                int userChoice16 = Integer.parseInt(myObj16.nextLine());
                String tempAttract = this.AttractionsList.get(userChoice16-1).toString();
                eventPlanner.add(tempAttract);
            } else if (userChoice15 == 999) {
                    eventPlanner.add("No attraction selected");
                    System.out.println("No attraction selected");
            }else{
                Scanner myObj17 = new Scanner(System.in);
                System.out.println("Please Select what restaurant you have chosen: ");
                int userChoice17 = Integer.parseInt(myObj17.nextLine());
                String tempAttract = this.AttractionsListFood.get(userChoice17-1).toString();
                eventPlanner.add(tempAttract);
            }
        }
        for(int i=0;i<eventPlanner.size();i++){
            System.out.println(eventPlanner.get(i));//eventPlanner is only outputted to console, there is potential that it could be output
            //to a file which could be downloaded
        }
    }

    public void plannerTransport(boolean planner){
        System.out.println("Displaying all transports");
        getTransport(planner);
    }

    public void accommodationInformation(boolean planner){//This displays the information about accommodation information
        System.out.println("The information is presented as: Name, Location, Distance, Type, Rating and Price Per Night");
        System.out.println("This is the Accommodation information Menu\nPlease Choose what you would like to do next:\n" +
                "1. Display all Accommodation information\n2. Display only Accommodation in "+this.locationName);
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice1 = Integer.parseInt(myObj1.nextLine());
        if(userChoice1==1){
            System.out.println("Please choose sorting method:\n1. Display in order of rating\n2. Display in order of Price per night");
            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice2 = Integer.parseInt(myObj2.nextLine());
            if(userChoice2==1) {
                Comparator<Accommodation> rating = new Comparator<Accommodation>() {//This is a comparator that compares the rating of
                    //accommodations.
                    @Override
                    public int compare(Accommodation accommodation1, Accommodation accommodation2) {
                        if (accommodation1.getRating() < accommodation2.getRating()) {
                            return 1;
                        } else if (accommodation1.getRating() > accommodation2.getRating()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                };
                Collections.sort(this.AccommodationList, rating);
                getAccommodation(planner);
            }else if(userChoice2==2) {
                //This is another comparator that compares the price per night of accommodations
                Comparator<Accommodation> nightPrice = new Comparator<Accommodation>() {
                    @Override
                    public int compare(Accommodation accommodation3, Accommodation accommodation4) {
                        if (accommodation3.getPpn() < accommodation4.getPpn()) {
                            return 1;
                        } else if (accommodation3.getPpn() > accommodation4.getPpn()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                };
                //the comparator then sorts the this.AccommodationList ArrayList
                Collections.sort(this.AccommodationList, nightPrice);
                getAccommodation(planner);
            }
        }else if(userChoice1==2){
            System.out.println("Please choose sorting method:\n1. Display in order of rating\n2. Display in order of Price per night");
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice3 = Integer.parseInt(myObj3.nextLine());
            if(userChoice3==1){
                Comparator<Accommodation> ratingLocal = new Comparator<Accommodation>() {
                    @Override
                    public int compare(Accommodation accommodation5, Accommodation accommodation6) {
                        if (accommodation5.getRating() < accommodation6.getRating()) {
                            return 1;
                        } else if (accommodation5.getRating() > accommodation6.getRating()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                };
                Collections.sort(this.AccommodationListLocal,ratingLocal);
                for(int i =0; i<this.AccommodationListLocal.size();i++){
                    if(planner){
                        System.out.println(String.valueOf(i+1)+". "+this.AccommodationListLocal.get(i).toString());
                    }else {
                        System.out.println(this.AccommodationListLocal.get(i).toString());
                    }
                }
            }else if(userChoice3==2){
                Comparator<Accommodation> ppnLocal = new Comparator<Accommodation>() {
                    @Override
                    public int compare(Accommodation accommodation7, Accommodation accommodation8) {
                        if (accommodation7.getPpn() < accommodation8.getPpn()) {
                            return 1;
                        } else if (accommodation7.getPpn() > accommodation8.getPpn()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                };
                Collections.sort(this.AccommodationListLocal,ppnLocal);
                for(int i =0; i<this.AccommodationListLocal.size();i++){
                    if(planner){
                        System.out.println(String.valueOf(i+1)+". "+this.AccommodationListLocal.get(i).toString());
                    }else {
                        System.out.println(this.AccommodationListLocal.get(i).toString());
                    }
                }
            }
        }
    }

    public void attractionInformation(boolean planner){
        System.out.println("The information is presented as Name, Rating, Type and Location");
        System.out.println("This is the Attraction information Menu\nPlease Choose what you would like to do next:\n" +
                "1. Display all Attractions\n2. Display only places to get food");
        Scanner myObj4 = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice4 = Integer.parseInt(myObj4.nextLine());
        if(userChoice4 == 1){
            getAttraction(planner);
        }else if(userChoice4 == 2){
            if(planner){
                for(int i = 0; i< this.AttractionsListFood.size(); i++) {
                    System.out.println(String.valueOf(i + 1) + ". " + this.AttractionsListFood.get(i).toString());
                }
            }else{
                for (int i = 0; i < this.AttractionsListFood.size(); i++) {
                    System.out.println(this.AttractionsListFood.get(i).toString());
                }
            }
        }
    }

    public void surroundingInformation(boolean planner){
        System.out.println("The information is displayed as Location, Distance and Transport");
        System.out.println("This is the Surrounding information Menu\nPlease Choose what you would like to do next:" +
                "\n1. Display surrounding town's and cities by distance from "+this.locationName);
        Scanner myObj5 = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice5 = Integer.parseInt(myObj5.nextLine());
        if(userChoice5 == 1){
            Comparator<Surrounding> localDistance = new Comparator<Surrounding>() {
                @Override
                public int compare(Surrounding surrounding1, Surrounding surrounding2) {
                    if (surrounding1.getDistance() > surrounding2.getDistance()) {
                        return 1;
                    } else if (surrounding1.getDistance() < surrounding2.getDistance()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };
            Collections.sort(SurroundingList,localDistance);
            getSurrounding(planner);
        }
    }

    public void transportInformation(boolean planner){
        System.out.println("The information is displayed as Name, Location, Average Price/5 and Type");
        System.out.println("This is the Transport information Menu\nPlease Choose what you would like to do next:" +
                "\n1. Display all transport in the area\n2. Display only transport in "+this.locationName);
        Scanner myObj6 = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice6 = Integer.parseInt(myObj6.nextLine());
        if(userChoice6 == 1){
            System.out.println("1. Display all transports\n2. Display only Taxi's\n3. Display only busses" +
                    "\n4. Display all relevant car information \n5. Display only airports");
            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice7 = Integer.parseInt(myObj7.nextLine());
            if(userChoice7 == 1){
                getTransport(planner);
            }else if(userChoice7 == 2){
                for(int i = 0; i < this.TransportList.size(); i++){
                    if(this.TransportList.get(i).getType().equals("Taxi")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportList.get(i).toString());
                        }else{
                            System.out.println(this.TransportList.get(i).toString());
                        }
                    }
                }
            }else if(userChoice7 == 3){
                for(int i = 0; i < this.TransportList.size(); i++){
                    if(this.TransportList.get(i).getType().equals("Bus")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportList.get(i).toString());
                        }else{
                            System.out.println(this.TransportList.get(i).toString());
                        }
                    }
                }
            }else if(userChoice7 == 4){
                for(int i = 0; i < this.TransportList.size(); i++){
                    if(this.TransportList.get(i).getType().equals("Car")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportList.get(i).toString());
                        }else{
                            System.out.println(this.TransportList.get(i).toString());
                        }
                    }
                }
            }else if(userChoice7 == 5){
                for(int i = 0; i < this.TransportList.size(); i++){
                    if(this.TransportList.get(i).getType().equals("Airport")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportList.get(i).toString());
                        }else{
                            System.out.println(this.TransportList.get(i).toString());
                        }
                    }
                }
            }
        }else if(userChoice6 == 2){
            System.out.println("1. Display all transports\n2. Display only Taxi's\n3. Display only busses" +
                    "\n4. Display all relevant car information \n5. Display only airports");
            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Please Select: ");
            int userChoice8 = Integer.parseInt(myObj8.nextLine());
            if(userChoice8 == 1){
                for(int i = 0; i < this.TransportLocal.size(); i++){
                    if(planner) {
                        System.out.println(String.valueOf(i+1)+". "+this.TransportLocal.get(i).toString());
                    }else {
                        System.out.println(this.TransportLocal.get(i).toString());
                    }
                }
            }else if(userChoice8 == 2){
                for(int i = 0; i < this.TransportLocal.size(); i++){
                    if(this.TransportLocal.get(i).getType().equals("Taxi")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportLocal.get(i).toString());
                        }else {
                            System.out.println(this.TransportLocal.get(i).toString());
                        }
                    }
                }
            }else if(userChoice8 == 3){
                for(int i = 0; i < this.TransportLocal.size(); i++){
                    if(this.TransportLocal.get(i).getType().equals("Bus")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportLocal.get(i).toString());
                        }else {
                            System.out.println(this.TransportLocal.get(i).toString());
                        }
                    }
                }
            }else if(userChoice8 == 4){
                for(int i = 0; i < this.TransportLocal.size(); i++){
                    if(this.TransportLocal.get(i).getType().equals("Car")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportLocal.get(i).toString());
                        }else {
                            System.out.println(this.TransportLocal.get(i).toString());
                        }
                    }
                }
            }else if(userChoice8 == 5){
                for(int i = 0; i < this.TransportLocal.size(); i++){
                    if(this.TransportLocal.get(i).getType().equals("Airport")){
                        if(planner) {
                            System.out.println(String.valueOf(i+1)+". "+this.TransportLocal.get(i).toString());
                        }else {
                            System.out.println(this.TransportLocal.get(i).toString());
                        }
                    }
                }
            }
        }
    }

    public void airTravelInformation(){
        System.out.println("This displays information about general air travel from Europe to "+this.locationName+
                "\n These are return flights where the return is just the reverse");
        getAirTravel();
    }
    public void userChoice(){
        System.out.println("Welcome to The Tourism Assistance Software, Currently the software is setup for "+this.locationName+".");
        System.out.println("Information on how to setup this software is in the README.txt file");
        System.out.println("Please input what you would like to do next:\n1. Review Accommodation information\n" +
                "2. Review Attraction information\n3. Review Surrounding information\n4. Review Transport information\n" +
                "5. Review Air Travel Information \n6. Open Tourism Planner\n7. Close Software");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Select: ");
        int userChoice = Integer.parseInt(myObj.nextLine());
        if(userChoice==1){
            accommodationInformation(false);
        }else if(userChoice==2){
            attractionInformation(false);
        } else if(userChoice==3) {
            surroundingInformation(false);
        } else if(userChoice==4){
            transportInformation(false);
        } else if (userChoice == 5) {
            airTravelInformation();
        }else if(userChoice == 6){
            travelPlanner();
        }else if (userChoice == 7) {
            System.exit(0);
        }
        System.out.println("\nPlease choose what you would like to do next: \n");
        userChoice();
    }
}
