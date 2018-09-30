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
        houses = new int[][]{};
        apartments = new int[][]{};
    }
}