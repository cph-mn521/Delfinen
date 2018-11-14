/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.time.LocalDateTime;

/**
 *
 * @author Martin Wulff
 */
public class Record {
    private double time;
    private LocalDateTime date;
    private Member holder;
    private String event;
    private Discipline discpiline;

    public Record(double time, LocalDateTime date, Member holder, String event,Discipline discipline){
        this.time       = time;
        this.date       = date;
        this.holder     = holder;
        this.event      = event;
        this.discpiline = discipline;
    }

    public double getTime() {
        return time;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Member getHolder() {
        return holder;
    }

    public String getEvent() {
        return event;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setHolder(Member holder) {
        this.holder = holder;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Discipline getDiscpiline() {
        return discpiline;
    }
    

}
