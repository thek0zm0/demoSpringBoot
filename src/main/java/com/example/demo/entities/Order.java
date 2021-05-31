package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

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
    private Instant moment;

    // Associações (Usar nome no papel do diagrama)
    // n orders de 1 user
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(){}

    public Order(Long id, Instant moment, User client)
    {
        this.id = id;
        this.moment = moment;
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

    public User getClient()
    {
        return client;
    }

    public void setClient(User client)
    {
        this.client = client;
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
