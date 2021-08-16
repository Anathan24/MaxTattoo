package com.maxtattoo.bean.statistic;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class TotalClientWrapper {

    private Integer totalClientsNumber;
    private Integer numberOfMales;
    private Integer numberOfFemales;

}
