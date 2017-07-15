package com.cookin.data;

import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by anders on 03-03-2016.
 */
public class Data {
    private static Data ourInstance = new Data();

    public Choice choice;
    public Profil user;
    public List<Profil> profils;
    public List<DinnerHost> dinnerHosts;
    public List<Dinner> dinners;
    public List<Banquet> banquets;
    public List<Banquet> hostBanquets;
    public Firebase mFirebase;
    public User theUser;
    public Banquet mBanquet;
    public FragmentManager mFragmentManager;
    public android.support.v7.app.ActionBar mActionBar;

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        choice = new Choice();
        dummyData();
        profils = new ArrayList<>();
        dinnerHosts = new ArrayList<>();
        dinners = new ArrayList<>();
        banquets = new ArrayList<>();
        hostBanquets = new ArrayList<>();


    }

    private void dummyData(){

        mBanquet = new Banquet();
        //mBanquet.setHostId(Profile.getCurrentProfile().getId());
        mBanquet.setTitle("Foodheaven!");
        mBanquet.setDescription("Enjoy food decended from engels them self!");
        mBanquet.setMaxGuest(4);
        mBanquet.setPricetag(43);
        mBanquet.setStartDate(new Date());
        mBanquet.setDeadlineDate(new Date());
        mBanquet.addGuest("10209475785081501");
        mBanquet.addGuest("10209475785081502");
        mBanquet.addGuest("10209475785081503");
        mBanquet.addGuest("10209475785081504");

        dinnerHosts = new ArrayList<>();
        dinners = new ArrayList<>();
        profils = new ArrayList<>();
        user = new Profil(4323460, "Lars Peter", "Jensen", "hej@gmail.com", "Stonergade 5", "Denmark", "http:\\somethingsomething", 3290, (short) 0);

        profils.add(new Profil(4323461,"Anders Bækhøj", "Larsen", "anders2108@gmail.com", "2800 Kgs. Lyngby", "Denmark", "http:\\somethingsomething", 2800, (short) 0));
        profils.add(new Profil(4323462,"Bjarne", "Hansen", "bjerny@gmail.com", "Birkevang 4", "Denmark", "http:\\somethingsomething", 4324, (short) 1));
        profils.add(new Profil(4323463,"Kim", "Larsen", "kimmolarsen@gmail.com", "Kristiania gade 67", "Denmark", "http:\\somethingsomething", 4620, (short) 1));
        profils.add(new Profil(4323464,"Jannie", "Forlystelsespark", "sjovogspas@gmail.com", "grinebidervej 3", "Denmark", "http:\\somethingsomething", 2134, (short) 0));
        profils.add(new Profil(4323465,"Britta", "Nielsen", "kedeligpigen1400@gmail.com", "loftet", "Denmark", "http:\\somethingsomething", 8765, (short) 2));
        profils.add(new Profil(4323466,"Gorm Den", "Gamle", "hsgbfnafpgduabfhdgagfdhnopahfdgn@gmail.com", "Til højre efter havnen", "Denmark", "http:\\somethingsomething", 2825, (short) 0));
        profils.add(new Profil(4323467,"Harald", "Blå-Tand", "bluetooth@gmail.com", "Under en bunke jord", "Denmark", "http:\\somethingsomething", 8241, (short) 0));
        profils.add(new Profil(4323468,"Svend", "Tveskæg", "Oekse@gmail.com", "Oppe i et træ", "Denmark", "http:\\somethingsomething", 4050, (short) 0));
        profils.add(new Profil(4323469,"Knud Den", "Store", "Leftovers@gmail.com", "Over dig", "Denmark", "http:\\somethingsomething", 4720, (short) 0));


        dinnerHosts.add(new DinnerHost(profils.get(0), "Mit Første CookIn", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Home Cookin", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Fest Måltid", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Leger i køkkenet", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Mit Første CookIn", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Home Cookin", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Fest Måltid", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinnerHosts.add(new DinnerHost(profils.get(0), "Leger i køkkenet", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));

        dinners.add(new Dinner(profils.get(1), "Title", "Description", 50.00, 4, (short) 1, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(2), "Kødfri aften", "Description", 45.00, 4, (short) 1, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(3), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(4), "Veganer Gryder", "Description", 50.00, 4, (short) 2, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(5), "Winner Winner Chicken Dinner", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(4), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(6), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(3), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(2), "Title", "Description", 50.00, 4, (short) 1, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(7), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(5), "Title", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));
        dinners.add(new Dinner(profils.get(8), "#Cookin and Chill", "Description", 50.00, 4, (short) 0, new Date(), new Date(), new Date(), profils));

        //String[]mDescription = {"noget lækket mad med noget kylling til de sultene", "Tømmermand Bob laver lige nogle lækre frikadeller rigtig håndvæker style", "Description3", "Description4", "Description5", "Description6", "Description7"};

    }
}
