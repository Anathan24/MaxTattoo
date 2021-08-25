package com.maxtattoo.service.statisticmanager;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.GenericService;
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
        Integer totalClients = clientRepository.countTotalClientsNumber(startDate, endDate, null);
        Integer numberOfMales = clientRepository.countTotalClientsNumber(startDate, endDate, MALE);
        Integer numberOfFemales = clientRepository.countTotalClientsNumber(startDate, endDate, FEMALE);

        statistic.getClientsStatistic().setTotalClientsNumber(totalClients);
        statistic.getClientsStatistic().setNumberOfMales(numberOfMales);
        statistic.getClientsStatistic().setNumberOfFemales(numberOfFemales);
    }
}