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
    private final ArrayList<Member> Debitors;
    private final float Bank;

    /**
     *Constructor for an Accountant. Takes a list of subscriptions and list of members
     *and calculates all required information a book keeper need.
     * @param Budget
     * @param Members
     */
    public Accountant(ArrayList<Subscription> Budget, ArrayList<Member> Members) {
        this.Budget = Budget;
        this.Members = Members;
        this.MissingPayments = Members.size() - Budget.size();
        this.Bank = getBudget();
        this.Debitors = Restance();
    }

    private float getBudget() {
        float runsum = 0;
        for (Subscription subscription : Budget) {
            runsum += subscription.getPrice();
        }
        return runsum;
    }

    public ArrayList<Member> Restance() {
        ArrayList<Member> temp = Members;
        for (Subscription Sub : Budget) {
            if (temp.contains(Sub.getHolder())) {
                temp.remove(Sub.getHolder());
            }
        }
        return temp;

    }

    public int getMissingPayments() {
        return MissingPayments;
    }

    public ArrayList<Member> getDebitors() {
        return Debitors;
    }

    public float getBank() {
        return Bank;
    }

}
