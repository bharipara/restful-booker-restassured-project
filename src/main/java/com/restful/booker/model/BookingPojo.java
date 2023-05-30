package com.restful.booker.model;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    private Bookingdates bookingdates;
    private String additionalneeds;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }



    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
 public static  class Bookingdates{
        private String checkin;
        private String checkout;

     public String getCheckin() {
         return checkin;
     }

     public void setCheckin(String checkin) {
         this.checkin = checkin;
     }

     public String getCheckout() {
         return checkout;
     }

     public void setCheckout(String checkout) {
         this.checkout = checkout;
     }
 }

}

