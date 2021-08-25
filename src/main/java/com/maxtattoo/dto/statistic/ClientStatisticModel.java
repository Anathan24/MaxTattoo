package com.maxtattoo.dto.statistic;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class ClientStatisticModel implements StatisticObject {

    private Integer totalClientsNumber;
    private Integer numberOfMales;
    private Integer numberOfFemales;

}
