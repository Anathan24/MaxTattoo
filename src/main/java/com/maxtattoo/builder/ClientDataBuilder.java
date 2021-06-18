package com.maxtattoo.builder;

import com.maxtattoo.builder.interfaces.GenericBuilder;
import com.maxtattoo.database.entity.SittingNeedle;
import com.maxtattoo.database.entity.SittingPaint;
import com.maxtattoo.database.repository.*;
import com.maxtattoo.model.*;
import com.maxtattoo.transformer.EntityModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDataBuilder implements GenericBuilder {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SittingRepository sittingRepository;
    @Autowired
    private PaintRepository paintRepository;
    @Autowired
    private SittingPaintRepository sittingPaintRepository;
    @Autowired
    private NeedleRepository needleRepository;
    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;

    @Autowired
    private EntityModelTransformer entityModelTransformer;

    public ClientModel buildAllClientClientById(Long clientId){
        var client = clientRepository.findClientById(clientId);
        ClientModel clientModel = entityModelTransformer.clientEntityIntoModelTransformer(client);

        var orders = orderRepository.findAllOrdersByClientId(clientModel.getClientId());
        List<OrderModel> ordersModel = entityModelTransformer.orderEntityIntoModelTransformer(orders);

        for(OrderModel orderModel: ordersModel) {
            var sittings = sittingRepository.findAllSittingByOrderId(orderModel.getOrderId());
            List<SittingModel> sittingsModel = entityModelTransformer.sittingEntityIntoModelTransformer(sittings);
            for(SittingModel sittingModel: sittingsModel){
//                var sittingPaints = sittingPaintRepository.findSittingPaintBySittingId(sittingModel.getSittingId());
//                for(SittingPaint sittingPaint: sittingPaints){
//                    var paints = paintRepository.findPaintById(sittingPaint.getPaintId());
//                    List<PaintModel> paintsModel = entityModelTransformer.paintEntityIntoModelTransformer(paints);
//                    sittingModel.setPaints(paintsModel);
//                }
//                var sittingNeedles = sittingNeedleRepository.findSittingNeedleBySittingId(sittingModel.getSittingId());
//                for(SittingNeedle sittingNeedle: sittingNeedles){
//                    var needles = needleRepository.findAllNeedlesBySittingId(sittingModel.getSittingId());
//                    List<NeedleModel> needlesModel = entityModelTransformer.needleEntityIntoModelTransformer(needles);
//                    sittingModel.setNeedles(needlesModel);
//                }
            }
            orderModel.setSittings(sittingsModel);
        }

        clientModel.setOrders(ordersModel);
        return clientModel;
    }
}
