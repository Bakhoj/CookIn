package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by anders on 03-03-2016.
 */
public class Data {
    public static Data ourInstance = new Data();

    public Choice choice;
    public Profil user;
    public List<Profil> profils;
    public List<DinnerHost> dinnerHosts;
    public List<Dinner> dinners;


    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        choice = new Choice();
        dummyData();
    }

    private void dummyData(){

        dinnerHosts = new ArrayList<>();
        dinners = new ArrayList<>();
        profils = new ArrayList<>();
        user = new Profil(4323460, "Lars Peter", "Jensen", "hej@gmail.com", "Stonergade 5", "Denmark", "http:\\somethingsomething", 3290, (short) 0);

        profils.add(new Profil(4323461,"Anders Bækhøj", "Larsen", "anders2108@gmail.com", "Lyngvej 13 2TV", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323462,"Bjarne", "Hansen", "bjerny@gmail.com", "Birkevang 4", "Denmark", "http:\\somethingsomething", 2800, (short) 1));
        profils.add(new Profil(4323463,"Kim", "Larsen", "kimmolarsen@gmail.com", "Kristiania gade 67", "Denmark", "http:\\somethingsomething", 2800, (short) 1));
        profils.add(new Profil(4323464,"Jannie", "Forlystelsespark", "sjovogspas@gmail.com", "grinebidervej 3", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323465,"Britta", "Nielsen", "kedeligpigen1400@gmail.com", "loftet", "Denmark", "http:\\somethingsomething", 2800, (short) 2));
        profils.add(new Profil(4323466,"Gorm Den", "Gamle", "hsgbfnafpgduabfhdgagfdhnopahfdgn@gmail.com", "Til højre efter havnen", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323467,"Harald", "Blå-Tand", "bluetooth@gmail.com", "Under en bunke jord", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323468,"Svend", "Tveskæg", "Oekse@gmail.com", "Oppe i et træ", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323469,"Knud Den", "Store", "Leftovers@gmail.com", "Over dig", "Denmark", "http:\\somethingsomething", 2800, (short) 0));


        dinnerHosts.add(new DinnerHost(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));

        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(0), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));

    }
}
