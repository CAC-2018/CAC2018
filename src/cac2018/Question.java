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
public class Question {
    public int index;
    public String prompt;
    public Boolean answered = false;
    public String[] answers;
    public double multiplier;
    public int[] cost;
    public int response;
    public Boolean scalable = false;
    
    public Question(String p, String a[], double m, int c[]){
        prompt = p;
        answers = a;
        multiplier = m;
        cost = c;
    }
    
    public Question(Question q){
        index = q.index;
        prompt = q.prompt;
        answered = q.answered;
        answers = q.answers;
        multiplier = q.multiplier;
        cost = q.cost;
        response = q.response;
        scalable = q.scalable;
    }
    
    public void setResponse(int i, boolean credit){
        response = i;
        answered = true;
        int c;
        int g;
        if (scalable){
            c = cost[i]*(GameManager.dep+1);
            g = (int) Math.round(multiplier*cost[i]*(GameManager.dep+1));
        }
        else{
            c = cost[i];
            g = (int) Math.round(multiplier*cost[i]);
        }
        if (credit){
            GameManager.available -= c;
            GameManager.bills += c;
        }
        else{
            GameManager.savings -= c;
        }
        GameManager.wellB += g;
        GameManager.saved.get(GameManager.month-1).add(new Storage(prompt,answers[i],c,g));
    }
    
    public void setScalable(){
        scalable = true;
    }
}
