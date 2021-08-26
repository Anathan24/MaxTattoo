package com.maxtattoo.service.statisticmanager;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.dto.statistic.TotalStatisticWrapper;
import com.maxtattoo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ClientStatisticCalculusService extends GenericService {

    private static final String FEMALE = "Female";
    private static final String MALE = "Male";

    @Autowired
    private ClientRepository clientRepository;

    public void calculateClientsTotalStatistic(TotalStatisticWrapper statistic, Date startDate, Date endDate) {
        statistic.getClientsStatistic().setTotalClientsNumber(calculateTotalClientsNumber(startDate, endDate));
        statistic.getClientsStatistic().setNumberOfMales(calculateTotalMaleClientsNumber(startDate, endDate));
        statistic.getClientsStatistic().setNumberOfFemales(calculateTotalFemaleClientsNumber(startDate, endDate));
    }

    public Integer calculateTotalClientsNumber(Date startDate, Date endDate) {
        return clientRepository.countTotalClientsNumber(startDate, endDate, null);
    }

    public Integer calculateTotalMaleClientsNumber(Date startDate, Date endDate){
        return clientRepository.countTotalClientsNumber(startDate, endDate, MALE);
    }

    public Integer calculateTotalFemaleClientsNumber(Date startDate, Date endDate){
        return clientRepository.countTotalClientsNumber(startDate, endDate, FEMALE);
    }
}