package com.cdc.ecommerce.service.impl;

import com.cdc.ecommerce.mapper.ToiletMapper;
import com.cdc.ecommerce.model.Toilet;
import com.cdc.ecommerce.service.ToiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @Author wujf
 * @ClassName ToiletServiceImpl
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service("toiletService")
public class ToiletServiceImpl implements ToiletService {
    @Autowired(required = false)
    private ToiletMapper toiletMapper;
    @Override
    public boolean addToilet(Toilet toilet) {
        if (toilet != null) {
            toilet.setCreateTime(new Date());
            toilet.setModifyTime(new Date());
            toilet.setDeleteStatus(false);
            toilet.setCheckStatus(false);
            toilet.setFixStatus(false);
            toilet.setLikeNumber(null);
            toilet.setScore(null);
            if (toiletMapper.insert(toilet) > 0) {
                return true;
            }
        }
        return false;
    }
}
