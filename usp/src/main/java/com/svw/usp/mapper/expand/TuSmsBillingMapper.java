package com.svw.usp.mapper.expand;

import com.svw.usp.model.expand.TuSmsSend;

public interface TuSmsBillingMapper {

    int insertSelective(TuSmsSend record);
}