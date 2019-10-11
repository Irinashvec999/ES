package ua.kiev.appliances.repository;

import org.springframework.stereotype.Repository;
import ua.kiev.appliances.domain.order.OrderEntity;

import java.util.List;
@Repository
public interface OrderRepository {
    void save(OrderEntity orderEntity);

    void delete(OrderEntity orderEntity);

    List<OrderEntity> getAll();
}
