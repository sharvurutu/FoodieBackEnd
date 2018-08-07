package com.stackroute.restuarantapp.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restuarant {

    @Id
    private Integer res_id;
    private String name;
    private String locality;
    private String city;
    private String cuisines;
    private Integer average_cost_for_two;
    private Integer price_range;
    private String rating_text;
    private String thumb;

    public String getRating_text() {
        return rating_text;
    }

public String getThumb(){
  return thumb;
}
public void setThumb(String thumb){
  this.thumb = thumb;

}

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public Integer getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(Integer average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public Integer getPrice_range() {
        return price_range;
    }

    public void setPrice_range(Integer price_range) {
        this.price_range = price_range;
    }

    public Restuarant() {
    }

    public Restuarant(Integer res_id, String name, String locality, String city, String cuisines, Integer average_cost_for_two, Integer price_range,String rating_text , String thumb) {
        this.res_id = res_id;
        this.name = name;
        this.locality = locality;
        this.city = city;
        this.cuisines = cuisines;
        this.average_cost_for_two = average_cost_for_two;
        this.price_range = price_range;
        this.rating_text = rating_text;
        this.thumb = thumb;
    }
}
