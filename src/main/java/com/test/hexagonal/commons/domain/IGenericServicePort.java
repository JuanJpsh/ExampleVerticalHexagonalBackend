package com.test.hexagonal.commons.domain;

public interface IGenericServicePort<Model> {
    Model create(Model element);
    void delete(Long id);
}
