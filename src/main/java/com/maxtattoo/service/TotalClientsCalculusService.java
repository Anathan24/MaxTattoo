package com.maxtattoo.service;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.pojo.statistic.TotalStatisticWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TotalClientsCalculusService extends GenericService {

    private static final String FEMALE = "Female";
    private static final String MALE = "Male";

    @Autowired
    private ClientRepository clientRepository;

    public void calculateClientsTotalStatistic(TotalStatisticWrapper statistic, Date startDate, Date endDate) {
        statistic.getClientsStatistic().setTotalClientsNumber(clientRepository.countTotalClientsNumber(startDate, endDate, null));
        statistic.getClientsStatistic().setNumberOfMales(clientRepository.countTotalClientsNumber(startDate, endDate, MALE));
        statistic.getClientsStatistic().setNumberOfFemales(clientRepository.countTotalClientsNumber(startDate, endDate, FEMALE));
    }
}