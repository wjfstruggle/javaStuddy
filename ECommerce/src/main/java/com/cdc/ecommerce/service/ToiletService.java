package com.cdc.ecommerce.service;

import com.cdc.ecommerce.model.Toilet;
import org.springframework.stereotype.Repository;

@Repository
public interface ToiletService {
    public boolean addToilet(Toilet toilet);
}
