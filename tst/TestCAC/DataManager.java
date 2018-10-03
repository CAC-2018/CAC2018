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
public class DataManager {
    
    public static String currentUser;
    public static int index;
    public static Boolean house;
    public static int housing;
    public static int deps;
    
    public static Boolean newLog(String user, String pass){
        currentUser = user;
        return true;
    }
    
    public static Boolean login(String user, String pass){
        currentUser = user;
        return true;
    }
    
    public static void initGameData(int ind, Boolean h, int hou, int dep){
        index = ind;
        house = h;
        housing = hou;
        deps = dep;
    }
}
