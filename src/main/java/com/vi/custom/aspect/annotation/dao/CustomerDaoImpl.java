package com.vi.custom.aspect.annotation.dao;

import com.vi.custom.aspect.annotation.performance.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Repository
@Slf4j
public class CustomerDaoImpl {

    public CustomerDaoImpl() {
        log.info("Constructor called");
    }

    @TrackTime(headName = "AOP_PERF_CHECK", subHeadName = "FETCH_CUSTOMER_NAME")
    public String fetchCustomerName(int id) {
        log.info("fetching Customer name for id {}", id);
        return "Jorah Mormont";
    }
}
