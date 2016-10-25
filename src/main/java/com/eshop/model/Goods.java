package com.eshop.model;

/**
 * Created by User on 20.10.2016.
 */
public class Goods {

    private long Id;

    private long Id_company;

    private String Name_company;

//    private long Picture; Try new type;

    private String Description;

    private String Title;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId_company() {
        return Id_company;
    }

    public void setId_company(long id_company) {
        Id_company = id_company;
    }


    public String getName_company() {
        return Name_company;
    }

    public void setName_company(String name_company) {
        Name_company = name_company;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
