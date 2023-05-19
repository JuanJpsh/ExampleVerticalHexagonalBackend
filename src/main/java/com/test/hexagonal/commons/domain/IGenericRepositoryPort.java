package com.test.hexagonal.commons.domain;

public interface IGenericRepositoryPort<Model> {
    Model save(Model element);
    void delete(Long id);
    boolean existById(Long id);
}
