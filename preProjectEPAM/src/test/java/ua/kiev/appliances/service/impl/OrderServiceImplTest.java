package ua.kiev.appliances.service.impl;

import org.junit.Before;
import org.junit.Test;
import ua.kiev.appliances.domain.order.OrderEntity;
import ua.kiev.appliances.repository.OrderRepository;
import ua.kiev.appliances.repository.impl.OrderRepositoryImpl;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    OrderRepository orderRepository;

    @Before
    public void init() {
        orderRepository = new OrderRepositoryImpl();
    }

    @Test
    public void save() {
        orderRepository.save(new OrderEntity(1L, "2", 3D));
        assertTrue(!orderRepository.getAll().isEmpty());
    }

    @Test
    public void delete() {
        OrderEntity orderEntity = orderRepository.getAll().get(0);
        orderRepository.delete(orderEntity);
        assertTrue(orderRepository.getAll().size() == 0);
    }

    @Test
    public void  whileOrderListIsEmptySizeIs0() {
        if(orderRepository.getAll().isEmpty())
            assertEquals(orderRepository.getAll().size(), 0);
    }
}