package com.example.CFT_2020.repositories;

import com.example.CFT_2020.entities.General;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GeneralRepo<T extends General> extends CrudRepository<T, Long> {
}
