package com.commerce.buy.infrastructure.search.dto;

public class SearchRequestDto {
    String name;
    String value;
    String joinTable;

    public SearchRequestDto(String name,String value){
        this.name = name;
        this.value = value;
    }

    public SearchRequestDto(String name,String value,String joinTable){
        this.name = name;
        this.value = value;
        this.joinTable = joinTable;
    }

    public String getJoinTable() {
        return joinTable;
    }

    public void setJoinTable(String joinTable) {
        this.joinTable = joinTable;
    }

    public SearchRequestDto(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
