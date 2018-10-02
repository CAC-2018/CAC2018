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
    public String[] jobs;
    public int[] salaries;
    public int[][] houses;
    public int[][] apartments;
    
    public void initJobs(){
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
            {203250,223500,244000,264250,285000,305000},{2235000,244000,264250,285000,305000,325000,366000},
            {285000,305000,325000,366000,407000,457000,478000,508000,549000}};
        apartments = new int[][]{{400},{400},{400,500},{400,500},{400,500,600},{400,500,600},{500,600},
            {500,600,700},{500,600,700},{500,600,700},{600,700,800},{600,700,800},{600,700,800},
            {700,800,900},{700,800,900},{800,900,1000,1100},{800,900,1000,1100},{800,900,1000,1100,1200},
            {1000,1100,1200,1300,1400},{1300,1400,1500,1600,1700,1800}};
    }
}