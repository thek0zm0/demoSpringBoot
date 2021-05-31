package com.example.demo.entities.enums;

public enum OrderStatus
{
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    // Método static para converter o valor número para tipo enum
    // Static pois funcionará sem precisar instanciar
    public static OrderStatus valueOf(int code)
    {
        // Procurar em todos os OrderStatus o valor correspondente
        for (OrderStatus value: OrderStatus.values())
        {
            if(value.getCode()==code)
            {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Code");
    }
}
