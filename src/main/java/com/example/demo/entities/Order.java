package com.example.demo.entities;

import com.example.demo.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Order é uma palavra reservado do SQL, e por isto, isso pode entrar em conflito.
// Devido a isto iremos utilizar a anotação @Table
@Entity
@Table(name = "tb_order")
public class Order implements Serializable
{
    // Entidades básicas
    private static final long serialVersionUID = 8256151461796770037L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Para mostrar o Json do instant no formato ISO 8601
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    // Associações (Usar nome no papel do diagrama)
    // n orders de 1 user
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    private Integer orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){}

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client)
    {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Instant getMoment()
    {
        return moment;
    }

    public void setMoment(Instant moment)
    {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus()
    {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus)
    {
        if (orderStatus!=null)
        {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient()
    {
        return client;
    }

    public void setClient(User client)
    {
        this.client = client;
    }

    public Set<OrderItem> getItems()
    {
        return items;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

    public Double getTotal()
    {
        Double sum = 0.0;
        for(OrderItem x: items)
        {
            sum += x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
