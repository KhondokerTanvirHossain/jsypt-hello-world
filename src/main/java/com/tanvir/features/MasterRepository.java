package com.tanvir.features;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MasterRepository extends R2dbcRepository<MasterEntity, String> {
}
