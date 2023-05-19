package com.test.hexagonal.commons.application.port_in;

public interface IGenericServicePort<Model> {
    Model create(Model element);
    void delete(Long id);
}
