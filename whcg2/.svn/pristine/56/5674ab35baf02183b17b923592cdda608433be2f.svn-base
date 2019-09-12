package com.ltsk.whcg.service.impl;

import com.ltsk.whcg.entity.Server;
import com.ltsk.whcg.entity.ServerProcess;
import com.ltsk.whcg.service.ServerService;
import com.ltsk.whcg.utils.MakeUUID;
import com.ltsk.whcg.utils.Result;
import com.ltsk.whcg.utils.ResultUtils;
import com.ltsk.whcg.zhjg.mapper.ServerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerMapper serverMapper;

    @Override
    @Transactional
    public Result register(String fwName, String username) {
        try {
            String[] servername = fwName.split(",");
            Integer register = 0;
            if (servername == null) {
                return ResultUtils.error("请传入服务名");
            }
            for (int i = 0; i < servername.length; i++) {
                register = serverMapper.registerServer(MakeUUID.getUUID(), username, servername[i], "0");
                if (register == 0) {
                    throw new Exception("事务回退");
                }
            }
            if (register > 0) {
                return ResultUtils.success("注册成功");
            } else {
                return ResultUtils.error("注册失败");
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("服务注册失败，请联系管理员");
            return ResultUtils.error("注册失败,请联系管理员");
        }
    }

    @Override
    public Result sh(String state, String id) {
        try {
            Integer sh = serverMapper.sh(state, id);
            if (sh > 0) {
                return ResultUtils.success("审核成功");
            } else {
                return ResultUtils.error("审核失败,请联系管理员");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("服务审核失败，请联系管理员");
            return ResultUtils.error("审核出现未知错误，请联系管理员");
        }
    }

    @Override
    public Result findSh() {
        try {
            List<ServerProcess> sh = serverMapper.findSh();
            return ResultUtils.success(sh);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得服务注册待审核数据失败");
            return ResultUtils.error("服务注册待审核数据失败，请联系管理员");
        }
    }

    @Override
    public Result getServerList(String username) {
        try {
            return ResultUtils.success(serverMapper.getServerList(username));
        } catch (Exception e) {
            log.error("获得虚拟化列表失败");
            e.printStackTrace();
            return ResultUtils.error("获得虚拟化列表失败，请联系管理员");
        }
    }

    @Override
    public Result isOff(String disjunctor, String serverName) {
        try {
            Integer off = serverMapper.isOff(disjunctor, serverName);
            if (off > 0) {
                if ("0".equals(disjunctor)) {
                    return ResultUtils.success("服务开启");
                } else {
                    return ResultUtils.success("服务关闭");
                }
            } else {
                return ResultUtils.error("操作失败");
            }
        } catch (Exception e) {
            log.error("服务开启关闭失败");
            return ResultUtils.error("系统错误");
        }
    }

    //获得所有关闭的服务
    @Override
    public String getOff(String serverName) {
        return serverMapper.getOff(serverName);
    }

    @Override
    public Result getAllServer() {
        return ResultUtils.success(serverMapper.getAllServer());
    }

}
