package com.AA_college.student_management_system.model.service;

import java.util.List;

public interface EntityService<S, I> {

    List<S> getAll();

    S findByID(I id);

    S save(S entity);

    void delete(I id);

    S edit(S entity);
}
