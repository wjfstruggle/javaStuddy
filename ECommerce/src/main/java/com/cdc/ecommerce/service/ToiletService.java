package com.cdc.ecommerce.service;

import com.cdc.ecommerce.model.Toilet;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ToiletService {
    public boolean addToilet(Toilet toilet);

    public Toilet selectAllToiletById(Long id);

    public boolean deleteToiletById(Long id);

    public PageInfo<Toilet> findToiletByPage(Integer pageNum, String keywords);

    int updateCheckStatus(Long id, byte checkStatus);
}
