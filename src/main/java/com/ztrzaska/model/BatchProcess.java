package com.ztrzaska.model;

import com.ztrzaska.model.types.BatchProcessType;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class BatchProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private BatchProcessType type;

    private String crone;
}
