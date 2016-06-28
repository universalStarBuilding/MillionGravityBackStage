package com.fengyu.modules.service.project.msg;

import com.fengyu.modules.dao.project.msg.CrowdfundBasicinfoDao;
import com.fengyu.modules.dao.project.msg.OrderDao;
import com.fengyu.modules.model.CrowdfundBasicinfo;
import com.fengyu.modules.model.Order;
import com.fengyu.modules.webservice.project.vo.HotResponseVo;
import com.fengyu.modules.webservice.project.vo.CrowdfundBasicinfoVo;
import com.fengyu.system.entity.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "launchProjectService")
@Transactional
public class CrowdfundBasicinfoService {

    @Autowired
    private CrowdfundBasicinfoDao launchProjectMapper;

    @Autowired
    private OrderDao orderDao;
    /**
     * 分页：我发起的项目列表
     * @param launchProjectVo
     * @return
     */
    public SearchResult queryBy(CrowdfundBasicinfoVo launchProjectVo){

        SearchResult<CrowdfundBasicinfo> result = new SearchResult<>();
        result.setTotalRows(launchProjectMapper.queryBy(launchProjectVo));
        result.setRows(launchProjectMapper.getListLaunch(launchProjectVo));

        return result ;
    }

    /**
     * 查询热门项目列表
     * @param launchVo
     * @return
     */
    public SearchResult selectHot(CrowdfundBasicinfoVo launchVo){
/*        CrowdfundBasicinfo launch=new CrowdfundBasicinfo();
        launch.setHot(launchVo.getHot());
        launch.setHotNum(launchVo.getHotNum());
        launch.setProjectState(launchVo.getProjectState());
        List<HotResponseVo> list = new LinkedList<>();
        list = launchProjectMapper.selectHot(launchVo);

        for (HotResponseVo vo :list){
            Order order=new Order();
            order.setOrderOwner(launch.getUserId());
            Integer count = orderDao.supportNumber(order);

            vo.setOrderOwner(count);
        }*/

        CrowdfundBasicinfo launch=new CrowdfundBasicinfo();/*
        launch.setHot(launchVo.getHot());
        launch.setHotNum(launchVo.getHotNum());
        launch.setProjectState(launchVo.getProjectState());*/
        List<HotResponseVo> list=launchProjectMapper.selectHot(launchVo);

        for (HotResponseVo vo:list){
            vo.setProjectNo(launch.getProjectNo());
            vo.setProjectName(launch.getProjectName());
            vo.setProjectState(launch.getProjectState());
            vo.setProjectImage(launch.getProjectImage());
            vo.setFundAmt(launch.getFundAmt());
            vo.setFundTotalAmt(launch.getFundTotalAmt());

  /*          Order order=new Order();
            CrowdfundBasicinfo launch=new CrowdfundBasicinfo();
            order.setOrderOwner(launch.getUserId());
            count = orderDao.supportNumber(order);
            vo.setOrderOwner(count);*/
        }
        Order order=new Order();
        order.setOrderOwner(launch.getUserId());
        Integer count=orderDao.supportNumber(order);
        SearchResult<HotResponseVo> result = new SearchResult<>();
        result.setTotalRows(count);
        result.setRows(list);
        return result;
    }
}
