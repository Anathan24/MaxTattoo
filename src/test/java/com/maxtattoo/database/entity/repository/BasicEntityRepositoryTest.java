package com.maxtattoo.database.entity.repository;

import com.maxtattoo.database.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BasicEntityRepositoryTest {

    private final Long entityId = 1L;
    private final static Logger logger = LoggerFactory.getLogger(BasicEntityRepositoryTest.class);

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private NeedleRepository needleRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void clientRepositoryTest(){
        Client client = new Client();
        client.setName("Test");
        client.setSurname("Test");
        clientRepository.save(client);

        Client savedClient = clientRepository.findClientById(client.getClientId());
        logger.info("CLIENT: {}", savedClient);
        Assert.assertNotNull("ClientRepository returns null", savedClient);
    }

    @Test
    public void orderRepositoryTest(){
        Order order = orderRepository.findOrderById(entityId);
        Assert.assertNotNull("OrderRepository returns null", order);
    }

    @Test
    public void sittingRepositoryTest(){
        Sitting sitting = sittingRepository.findSittingById(entityId);
        Assert.assertNotNull("SittingRepository returns null", sitting);
    }

    @Test
    public void paintRepositoryTest(){
        Paint paint = paintRepository.findPaintById(entityId);
        Assert.assertNotNull("PaintRepository returns null", paint);
    }

    @Test
    public void needleRepository(){
        Needle needle = needleRepository.findNeedleById(entityId);
        Assert.assertNotNull("NeedleRepository returns null", needle);
    }

    @Test
    public void sittingPaintRepositoryTest(){
        SittingPaint sittingPaint = sittingPaintRepository.findBySittingPaintId(entityId);
        Assert.assertNotNull("SittingPaintRepository returns null", sittingPaint);
    }

    @Test
    public void sittingNeedleRepositoryTest(){
        SittingNeedle sittingNeedle = sittingNeedleRepository.findSittingNeedleById(entityId);
        Assert.assertNotNull("SittingNeedleRepository returns null", sittingNeedle);
    }

    @Test
    public void statRepositoryTest(){
        State state = stateRepository.findStateById(entityId);
        Assert.assertNotNull("StateRepository returns null", state);
    }

    @Test
    public void orderTypeRepositoryTest(){
        OrderType orderType = orderTypeRepository.findOrderTypeById(entityId);
        Assert.assertNotNull("OrderTypeRepository returns null", orderType);
    }

    @Test
    public void cityRepositoryTest(){
        City city = cityRepository.findCityById(entityId);
        Assert.assertNotNull("CityRepository returns null", city);
    }

    @Test
    public void locationRepositoryTest(){
        Location location = locationRepository.findLocationById(entityId);
        Assert.assertNotNull("LocationRepository returns null", location);
    }
}