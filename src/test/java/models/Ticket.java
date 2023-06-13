package models;

import com.opencsv.bean.CsvBindByName;

public class Ticket {
    @CsvBindByName(column = "num")
    private int num;
    @CsvBindByName(column = "price")
    private float price;

    public Ticket() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
            public Ticket(int num, float price) {
            this.num = num;
            this.price = price;
        }
}
