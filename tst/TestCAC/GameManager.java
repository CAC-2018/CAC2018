/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCAC;

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
        savings = 0;
        score = 0;
        wellB = 0;
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