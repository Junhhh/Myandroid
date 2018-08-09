package example.com.calculator.LitePal;

import org.litepal.crud.LitePalSupport;

/**
 * Created by 钱俊华 on 2018/7/31 0031.
 */

public class Book extends LitePalSupport{

    private int id;
    private String name;
    private String author;
    private double price;
    private int pages;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


}
