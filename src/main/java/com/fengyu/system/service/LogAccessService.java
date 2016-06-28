package com.fengyu.system.service;

import com.fengyu.common.service.BaseService;
import com.fengyu.system.dao.LogAccessDao;
import com.fengyu.system.entity.LogAccess;
import com.fengyu.system.entity.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2016/6/20.
 */
@Service(value="logAccessService")
@Transactional
public class LogAccessService extends BaseService {

    @Autowired
    private LogAccessDao logAccessDao;

    public SearchResult findPageList(LogAccess logAccess) {

        SearchResult<LogAccess> result = new SearchResult<>();
        result.setTotalRows(logAccessDao.coutPageList(logAccess));
        result.setRows(logAccessDao.findPageList(logAccess));

        return result ;
    }

}
