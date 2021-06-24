package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicViewRepositoryTest {

    private final long viewId = 1;

    @Autowired
    private ClientViewRepository clientViewRepository;
    @Autowired
    private NeedleViewRepository needleViewRepository;
    @Autowired
    private OrderViewRepository orderViewRepository;
    @Autowired
    private PaintViewRepository paintViewRepository;
    @Autowired
    private SittingViewRepository sittingViewRepository;

    @Test
    public void clientViewRepositoryTest(){
        ClientView clientView = clientViewRepository.findClientViewById(viewId);
        Assert.assertNotNull("ClientViewRepository returns null", clientView);
    }

    @Test
    public void needleViewRepositoryTest(){
        NeedleView needleView = needleViewRepository.findNeedleViewById(viewId);
        Assert.assertNotNull("NeedleViewRepository returns null", needleView);
    }

    @Test
    public void orderViewRepositoryTest(){
        OrderView orderView = orderViewRepository.findOrderViewById(viewId);
        Assert.assertNotNull("OrderViewRepository returns null", orderView);
    }

    @Test
    public void paintViewRepositoryTest(){
        PaintView paintView = paintViewRepository.findPaintViewById(viewId);
        Assert.assertNotNull("PaintViewRepository returns null", paintView);
    }

    @Test
    public void sittingViewRepositoryTest(){
        SittingView sittingView = sittingViewRepository.findSittingViewById(viewId);
        Assert.assertNotNull("SittingViewRepository returns null", sittingView);
    }
}
