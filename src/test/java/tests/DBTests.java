package tests;

import dbreadertests.DBReader;
import models.Ticket;

import java.util.List;

public class DBTests {
    public void testTickets (int num, float price){
        List<Ticket> tickets= DBReader.getTicketsFromTable();
    }

}
