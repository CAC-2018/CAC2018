/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cac2018;

/**
 *
 * @author nikhi
 */
public class Storage {
    public String question;
    public String answer;
    public int cost;
    public int gain;
    
    public Storage(String q, String a, int c, int g){
        question = q;
        answer = a;
        cost = c;
        gain = g;
    }
}
