/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCAC;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nikhi
 */
public class GameManager {
    public static String[] jobs;
    public static int[] salaries;
    public static int[][] houses;
    public static int[][] apartments;
    public static int mort = 0;
    public static int homeIns = 0;
    public static int[] deps;
    
    public static int gross;
    public static int net;
    public static int fixed;
    public static int savings;
    public static int score;
    public static int wellB;
    public static int mortRent;
    public static int tax;
    public static Boolean haveHouse;
    
    public static int month;
    public static Question[] questions;
    public static ArrayList<Question> monthly = new ArrayList<Question>();
    public static boolean monthDone;
    
    public static void initJobs(){
        jobs = new String[]{"Office Administration","Driver","Auto Tech","Welder","Lab Technician","Social Worker",
            "Electrician","Teacher","Performing Arts","Construction Foreman","Law Enforcement","Soldier",
            "Dental Hygenist","Professor","Nurse","Sportsperson","Scientist","Engineer","Lawyer","Doctor"};
        salaries = new int[]{40000,40000,45000,45000,50000,50000,55000,60000,60000,60000,65000,65000,70000,
            75000,75000,85000,90000,100000,125000,200000};
        houses = new int[][]{{81000,101500},{81000,101500},{81000,101500,122000},{81000,101500,122000},
            {101500,122000,142000,162500},{101500,122000,142000,162500},{122000,142000,162500},
            {122000,142000,162500,183000},{122000,142000,162500,183000},{122000,142000,162500,183000},
            {142000,162500,183000,203250},{142000,162500,183000,203250},{142000,162500,183000,203250,223500},
            {162500,183000,203250,233500,244000},{162500,183000,203250,233500,244000},
            {183000,203250,223500,244000,264250},{183000,203250,223500,244000,264250},
            {203250,223500,244000,264250,285000,305000},{223500,244000,264250,285000,305000,325000,366000},
            {285000,305000,325000,366000,407000,457000,478000,508000,549000}};
        apartments = new int[][]{{400},{400},{400,500},{400,500},{400,500,600},{400,500,600},{500,600},
            {500,600,700},{500,600,700},{500,600,700},{600,700,800},{600,700,800},{600,700,800},
            {700,800,900},{700,800,900},{800,900,1000,1100},{800,900,1000,1100},{800,900,1000,1100,1200},
            {1000,1100,1200,1300,1400},{1300,1400,1500,1600,1700,1800}};
    }
    
    public static void initQuestions(){
        questions = new Question[]{new Question("You plan on going out to dinner",new String[]{"Not tonight","At a fastfood joint ($5 per person)","At a family restaurant ($12 per person)", "At a fine dining restaurant ($20 per person)"},2, new int[]{0,5,12,20}),
            new Question("Would you like to buy coffee on your way to work?",new String[]{"Not today","Yes ($3)"},1, new int[]{0,3}),
            new Question("Would you like to join your friends for lunch?",new String[]{"Not today", "At a foodtruck ($8)","At a foodtruck ($15)"},2, new int[]{0,8,15}),
            new Question("A movie that you wanted to watch has just released. Do you want to go?",new String[]{"Not today","Buy tickets ($10 per person)", "Buy tickets, soda, and popcorn ($13 per person)"},2, new int[]{0,10,13}),
            new Question("You want to get a haircut",new String[]{"Not today", "Get a haircut ($15)","Get an appointment with a stylist ($50)"},1, new int[]{0,15,50}),
            new Question("Your favorite band is playing and you want to go",new String[]{"Not today","Yes, taking my significant other ($100)"},2.5, new int[]{0,100}),
            new Question("A dear friend is celebrating their birthday. How much will you pay for their gift?",new String[]{"$10","$20","$30","$50"},2.5, new int[]{10,20,30,50}),
            new Question("Buy a Valentine's day gift for your significant other",new String[]{"Not this time","$15","$25","$50"},2.5, new int[]{0,15,25,50}),
            new Question("You are going to a superbowl party. Your contribution is",new String[]{"Miss the party","$5","$10","$25"},2, new int[]{0,5,10,25}),
            new Question("There is a fundraiser at work. You contribute",new String[]{"$5","$15","$30","$50","$75"},1.5, new int[]{5,15,30,50,75}),
            new Question("You plan on going on a road trip. You pay",new String[]{"Not going","$50 per person","$100 per person","$150 per person","$200 per person"},2, new int[]{0,50,100,150,200}),
            new Question("You have a doctor's appointment",new String[]{"$20 co-pay","$50 co-pay and medicine"},0.5, new int[]{20,50}),
            new Question("Buy a gift for Mother's Day",new String[]{"$15","$20","$25","$50","$100"},2.5, new int[]{15,20,25,50,100}),
            new Question("Memorial Day Sale",new String[]{"Buy $50 and get $5 off","Buy $100 and get $15 off","Buy $200 and get $50 off"},1, new int[]{45,85,150}),
            new Question("Buy a gift for Father's Day",new String[]{"$15","$20","$25","$50","$100"},2.5, new int[]{15,20,25,50,100}),
            new Question("Vacation offers have come in the mail",new String[]{"Not thanks","Visit a national park for 6 nights and 5 days ($250 per person)","Holiday in Hawaii for 5 nights and 4 days ($800 per person)","Travel Europe for 6 nights and 5 days ($1200 per person)"},2.5, new int[]{0,250,800,1200}),
            new Question("4th of July Sale",new String[]{"Buy $50 and get $5 off","Buy $100 and get $15 off","Buy $200 and get $50 off"},1, new int[]{45,85,150}),
            new Question("You are going to a 4th of July party. You contribute",new String[]{"$5","$10","$15"},2, new int[]{5,10,15}),
            new Question("Holiday expenses",new String[]{"$100 per person","$500 per person","$1000 per person"},2, new int[]{100,500,1000}),
            new Question("Back to school expenses",new String[]{"$15","$20","$30","$50"},1, new int[]{15,20,30,50}),
            new Question("Labor Day sale",new String[]{"Buy $50 and get $5 off","Buy $100 and get $15 off","Buy $200 and get $50 off"},1, new int[]{45,85,150}),
            new Question("You have a doctor's appointment",new String[]{"$20 co-pay","$50 co-pay and medicine"},0.5, new int[]{20,50}),
            new Question("You are going to a Halloween party. You contribute",new String[]{"$5","$10","$15"},2, new int[]{5,10,15}),
            new Question("A dear friend is celebrating their birthday. How much will you pay for their gift?",new String[]{"$10","$20","$30","$50"},2.5, new int[]{10,20,30,50}),
            new Question("You are going to a Thanksgiving party. You contribute",new String[]{"$25","$50","$75"},2, new int[]{25,50,75}),
            new Question("Black Friday Sale",new String[]{"Buy $100 and get $40 off","Buy $250 and get $100 off","Buy $500 and get $200 off"},1, new int[]{60,150,300}),
            new Question("You are going to a Christmas party. You contribute",new String[]{"$25","$50","$75"},2, new int[]{25,50,75}),
            new Question("Annual membership dues are coming up (gym, church, etc)",new String[]{"$Not a member","$120 per person","$240 per person","$360 per person"},1.5, new int[]{0,120,240,360})
        };
        questions[0].setScalable();
        questions[3].setScalable();
        questions[10].setScalable();
        questions[15].setScalable();
        questions[18].setScalable();
        questions[27].setScalable();
    }
    
    public static void setMonthly(){
        int nums[] = new int[]{};
        monthly.clear();
        monthly.add(questions[0]);
        monthly.add(questions[0]);
        monthly.add(questions[1]);
        monthly.add(questions[1]);
        monthly.add(questions[1]);
        monthly.add(questions[1]);
        monthly.add(questions[2]);
        monthly.add(questions[2]);
        monthly.add(questions[3]);
        monthly.add(questions[4]);
        switch (month){
            case 1: nums = new int[]{5,6};break;
            case 2: nums = new int[]{7,8};break;
            case 3: nums = new int[]{9,10};break;
            case 4: nums = new int[]{11};break;
            case 5: nums = new int[]{12,13};break;
            case 6: nums = new int[]{14,15};break;
            case 7: nums = new int[]{16,17};break;
            case 8: nums = new int[]{18,19};break;
            case 9: nums = new int[]{20,21};break;
            case 10: nums = new int[]{22,23};break;
            case 11: nums = new int[]{24,25};break;
            case 12: nums = new int[]{26,27};break;
        }
        for (int num: nums){
            monthly.add(questions[num]);
        }
        Collections.shuffle(monthly);
    }
    
    public static void initGame(int ind, Boolean h, int hou, int dep){
        gross = Math.round((salaries[ind])/12);
        haveHouse = h;
        net = gross - 1100;
        if (haveHouse){
            mortIns(houses[ind][hou]);
            mortRent = mort;
            net -= mort + homeIns;
        }
        else{
            mortRent = apartments[ind][hou];
            net -= mortRent;
        }
        tax(salaries[ind]);
        net -= tax;
        fixed = gross - net;
        savings = net;
        score = 0;
        wellB = 0;
        month = 1;
    }
    
    public static int tax (int inc){
        switch (inc){
            case 40000: tax = 63;break;
            case 45000: tax = 96;break;
            case 50000: tax = 129;break;
            case 55000: tax = 171;break;
            case 60000: tax = 213;break;
            case 65000: tax = 267;break;
            case 70000: tax = 321;break;
            case 75000: tax = 375;break;
            case 85000: tax = 500;break;
            case 90000: tax = 563;break;
            case 100000: tax = 688;break;
            case 125000: tax = 1104;break;
            case 200000: tax = 2563;break;
            default: tax = 0; break;
        }
        return tax;
    }
    
    public static void mortIns(int house){
        homeIns = Math.round(house*35/100000);
        switch (house){
            case 81000: mort = 400;break;
            case 101500: mort = 500;break;
            case 122000: mort = 600;break;
            case 142000: mort = 700;break;
            case 162500: mort = 800;break;
            case 183000: mort = 900;break;
            case 203250: mort = 1000;break;
            case 223500: mort = 1100;break;
            case 244000: mort = 1200;break;
            case 264250: mort = 1300;break;
            case 285000: mort = 1400;break;
            case 305000: mort = 1500;break;
            case 325000: mort = 1600;break;
            case 366000: mort = 1800;break;
            case 407000: mort = 2000;break;
            case 457000: mort = 2250;break;
            case 478000: mort = 2350;break;
            case 508000: mort = 2500;break;
            case 549000: mort = 2700;break;
            default: mort = 0; break;
        }
    }
    
    public static void calcDeps(int sal){
        if (sal < 50000){
            deps = new int[]{0,1};        
        }
        else if (sal < 65000){
            deps = new int[]{0,1,2};
        }
        else if (sal < 75000){
            deps = new int[]{0,1,2,3,4};
        }
        else {
            deps = new int[]{0,1,2,3,4,5,6};
        }
    }
}