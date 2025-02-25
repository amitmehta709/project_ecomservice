package com.scaler.amit.project_ecomservice.models.product;

import com.scaler.amit.project_ecomservice.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
}
