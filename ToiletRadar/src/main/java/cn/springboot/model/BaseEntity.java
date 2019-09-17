package cn.springboot.model;

import java.io.Serializable;


/**
 * @param <E>
 * @author sh
 * @Description 实体基类
 * @date Mar 16, 2019 3:25:15 PM
 */
public interface BaseEntity<E extends Serializable> extends Serializable {

    public E getId();

}
