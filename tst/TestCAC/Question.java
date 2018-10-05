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
public class Question {
    public int index;
    public String prompt;
    public Boolean answered = false;
    public String[] answers;
    public double multiplier;
    public int[] cost;
    public int response;
    public Boolean scalable;
    
    public Question(String p, String a[], double m, int c[]){
        prompt = p;
        answers = a;
        multiplier = m;
        cost = c;
    }
    
    public void setResponse(int i){
            response = i;
            answered = true;
            GameManager.savings -= cost[i];
            GameManager.wellB += Math.round(multiplier*cost[i]);
    }
    
    public void setScalable(){
        scalable = true;
    }
}
