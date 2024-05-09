package edu.java.scrapper.entity;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

@Data
public class Link {

    Long id;

    String value;

    Integer hashsum;

    Date lastUpdateAt;

}
