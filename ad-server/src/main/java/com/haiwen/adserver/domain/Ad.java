package com.haiwen.adserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
public class Ad implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long campaignId;
    private double bidPrice;
    private double price;
    private String title;
    @JsonIgnore
    private String keywords;
    private String brand;
    private String category;
    @Lob
    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;
    @Lob
    @Column(name = "thumbnail", columnDefinition = "MEDIUMTEXT NOT NULL")
    private String thumbnail;
    @Lob
    @Column(name = "detail_url", columnDefinition = "MEDIUMTEXT NOT NULL")
    private String detailUrl;

    @Transient
    private double relevanceScore;
    @Transient
    private double pClick;
    @Transient
    private double rankScore;
    @Transient
    private double qualityScore;
    @Transient
    private double costPerClick;
    @Transient
    private int position;//1: top , 2: bottom
    @Transient
    private String query;

    @JsonProperty("keywords")
    public List<String> getKeywordsList() {
        return new ArrayList<String>(Arrays.asList(keywords.split(",")));
    }

}
