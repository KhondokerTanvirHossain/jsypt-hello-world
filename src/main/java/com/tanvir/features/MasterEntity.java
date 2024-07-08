package com.tanvir.features;

import com.tanvir.core.util.CommonFunctions;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("tenantinfo")
public class MasterEntity {

    @Id
    @Column("oid")
    private String id;
    private String name;
    private String schema;
    private String createdBy;
    private LocalDateTime createdOn;

    @Override
    public String toString() {
        return CommonFunctions.buildGsonBuilder(this);
    }
}
