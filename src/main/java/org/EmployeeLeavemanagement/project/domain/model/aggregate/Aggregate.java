package org.EmployeeLeavemanagement.project.domain.model.aggregate;

import org.seedstack.business.domain.BaseAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aggregate extends BaseAggregateRoot<String> {
    @Id
    private String id;

    private Aggregate() {
        // required by persistence implementation
    }

    public Aggregate(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
