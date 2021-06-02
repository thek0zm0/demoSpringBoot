package com.example.demo.services.exceptions;

public class DatabaseException extends RuntimeException
{
    private static final long serialVersionUID = 5902801071464955588L;

    public DatabaseException(String msg)
    {
        super(msg);
    }
}
