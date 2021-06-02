package com.example.demo.services.exceptions;

// Criando exceções personalizadas para a aplicação
// Neste caso, ao passar um ID de algo que não existe no banco, esta exceção será lançada
public class ResourceNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 4243231284730422114L;

    public ResourceNotFoundException(Object id)
    {
        super("Resource not found id: " + id);
    }
}
