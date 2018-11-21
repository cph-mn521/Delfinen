/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martin Wulff
 * @Comentator Martin Wulff
 */
public class Record {

    private float time;
    private LocalDateTime date;
    private Member holder;
    private String event;
    private Discipline discipline;
    private int place;

    ///////////////////////      CONSTRUCTOR       /////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor for a record. Returns a new Record object. Represent an entry
     * of an event placement.
     *
     * @param time float. The achieved time for this entry.
     * @param date LocalDateTime. The date the of the record.
     * @param holder Member. The holder of this record.
     * @param event String. The Name of the event the record was achieved in.
     * @param discipline Enum. The discipline this record was achieved in.
     * @param place Integer. The placement the record gave the member at the
     * event.
     */
    public Record(float time, LocalDateTime date, Member holder, String event, Discipline discipline, int place) {
        this.time = time;
        this.date = date;
        this.holder = holder;
        this.event = event;
        this.place = place;
        this.discipline = discipline;
    }

    ///////////////////////      GETTERS       /////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Getter for time.
     *
     * @return float
     */
    public double getTime() {
        return time;
    }

    /**
     * Getter for the date.
     *
     * @return
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * getter for the member holding this record.
     *
     * @return
     */
    public Member getHolder() {
        return holder;
    }

    /**
     * Getter for the event of this record.
     *
     * @return
     */
    public String getEvent() {
        return event;
    }

    /**
     * Getter for the place of this record.
     *
     * @return
     */
    public int getPlace() {
        return place;
    }

    /**
     * getter for discipline field.
     *
     * @return
     */
    public Discipline getDiscpiline() {
        return discipline;
    }

    ///////////////////////      SETTERS       /////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Setter for this objects time field.
     *
     * @param time
     */
    public void setTime(float time) {
        this.time = time;
    }

    /**
     * Setter for the date field.
     *
     * @param date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * setter for the holder field.
     *
     * @param holder
     */
    public void setHolder(Member holder) {
        this.holder = holder;
    }

    /**
     * setter for event field.
     *
     * @param event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * toString
     *
     * @return string
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm");
        LocalDateTime dateTime = date;
        String formattedDateTime = dateTime.format(formatter);
        // Formatting fits with small info box on members page
        return String.format("%-17s %-6s %-18s %-30s %-12s", discipline, String.format("%.5s", time), formattedDateTime,
                event, place + ".");
    }

}
