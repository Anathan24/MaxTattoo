package com.maxtattoo.pojo.statistic;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class TotalClientWrapper {

    private Integer totalClientsNumber;
    private Integer numberOfMales;
    private Integer numberOfFemales;

}
