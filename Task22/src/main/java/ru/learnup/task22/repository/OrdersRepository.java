package ru.learnup.task22.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.task22.models.Orders;

import java.sql.Date;
import java.time.ZoneOffset;
import java.util.List;

@Repository
public class OrdersRepository {

    private final NamedParameterJdbcTemplate template;

    private static final String FIND_ALL =
            "select * from orders";

    private static final String FIND_BY_ID =
            "select * from orders where orders.id= :id";

    private static final String SAVE_ORDER =
            "insert into orders (book, quantity, buyers_name, date_order) values (:book, :quantity, :buyers_name, :date_order)";




    public OrdersRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Orders> findAllOrder() {
        return template.query(FIND_ALL,
                new MapSqlParameterSource(), (rs, rn) -> Orders.builder()
                        .id(rs.getInt("id"))
                        .book(rs.getInt("book"))
                        .quantity(rs.getInt("quantity"))
                        .buyersName(rs.getString("buyers_name"))
                        .dataOrder(rs.getDate("date_order").toLocalDate())
                        .build()
        );
    }

    public Orders findByIdOrder(int id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id), (rs, rn) -> Orders.builder()
                                .id(rs.getInt("id"))
                                .book(rs.getInt("book"))
                                .quantity(rs.getInt("quantity"))
                                .buyersName(rs.getString("buyers_name"))
                                .dataOrder(rs.getDate("date_order").toLocalDate())
                                .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Order with id = " + id + " is not found"));
    }

    public void makeOrder(Orders orders) {
        template.update(
                SAVE_ORDER,
                new MapSqlParameterSource()
                        .addValue("book", orders.getBook())
                        .addValue("quantity", orders.getQuantity())
                        .addValue("buyers_name", orders.getBuyersName())
                        .addValue("date_order", new Date(orders.getDataOrder()
                                .atStartOfDay()
                                .toInstant(ZoneOffset.UTC)
                                .toEpochMilli()))
        );
    }

}
