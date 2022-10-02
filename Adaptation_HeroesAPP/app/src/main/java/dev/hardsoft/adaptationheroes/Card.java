package dev.hardsoft.adaptationheroes;

public class Card {
    private String name;
    private Integer value;
    private String id;


    public Card (String id,String name, Integer value){
        this.id = id;
        this.name = name;
        this.value = value;
    }



    //Getters Setters
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public Integer getValue(){
        return value;
    }
    public void setValue(Integer value){
        this.value = value;

    }
}
