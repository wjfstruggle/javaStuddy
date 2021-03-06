package cn.springboot.config.db.database;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sh
 * @Description 在方法上使用，用于指定使用哪个数据源
 * @date Mar 17, 2019 9:04:49 AM
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    /**
     * 数据源名称
     */
    DataSourceEnum value();
}
