/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class Accountant {

    private final ArrayList<Subscription> Budget;
    private final ArrayList<Member> Members;
    private final int MissingPayments;
    private ArrayList<Member> Debitors;
    private final float Bank;
    private final float ExpectedBank;

    /**
     *Constructor for an Accountant. Takes a list of subscriptions and list of members
     *and calculates all required information a book keeper need.
     * @param Budget        List of all subscriptions to be taken into consideration. Should be for same period of time.
     * @param Members       List of all current members. Used to find debitors and calculate expected revenue.
     */
    public Accountant(ArrayList<Subscription> Budget, ArrayList<Member> Members) {
        this.Budget = Budget;
        this.Members = Members;
        this.MissingPayments = Members.size() - Budget.size();
        this.Bank = calcBudget();
        
        switch (MissingPayments){
            case 0:
                this.ExpectedBank = this.Bank;
                break;
            default:
                this.Debitors = Restance();
                this.ExpectedBank = calcExpectedBank();
        }
    }

    
    
    /**
     * Method for finding how mutch is in the bank at the moment. Simple sum function.
     * @return      Float. Sum of budget.price.
     */
    private float calcBudget() {
        float runsum = 0;
        for (Subscription subscription : Budget) {
            runsum += subscription.getPrice();
        }
        return runsum;
    }

    /**
     * Method for calculating Expected budget, when every member pays their bills.
     * Simple sum function.
     * 
     * @return      Sum of all Debitors supposed subscription.price
     */
    private float calcExpectedBank(){
        float runsum = 0;
        for (Member Debitor : Debitors) {
            runsum += new Subscription(0,Debitor).getPrice();
        }
        return runsum;
    }
    
    
    /**
     * Method for finding all members without a paid subscription
     * @return  ArrayList. contains members without a subscription.
     */
    public ArrayList<Member> Restance() {
        ArrayList<Member> temp = Members;
        for (Subscription Sub : Budget) {
            if (temp.contains(Sub.getHolder())) {
                temp.remove(Sub.getHolder());
            }
        }
        return temp;

    }

    
    
    ///////////////////////      GETTERS AND SETTERS       /////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    
    public int getMissingPayments() {
        return MissingPayments;
    }

    public ArrayList<Member> getDebitors() {
        return Debitors;
    }

    public float getBank() {
        return Bank;
    }
    
        public float getExpectedBank() {
        return ExpectedBank;
    }
}
