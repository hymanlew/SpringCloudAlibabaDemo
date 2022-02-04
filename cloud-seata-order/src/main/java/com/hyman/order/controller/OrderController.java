package com.hyman.order.controller;

import com.hyman.cloudapi.entity.Department;
import com.hyman.cloudapi.service.DeptService;
import com.hyman.common.feign.IBaseFeign;
import com.hyman.common.msg.Result;
import com.hyman.order.dao.OrderDao;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Seata 默认采用的是 AT 事务模式。
 * - 本地事务用 @Transactional，全局事务用 @GlobalTransactional。
 * - 此时 seata 服务端就是作为全局事务的控制器 TC。
 * - 标注有 GlobalTransactional 注解的方法及服务，就是事务的发起方，也就是 TM。
 * - 而事务发起方远程调用到的服务及方法，就是事务的参与方，作为 RM。
 *
 * AT 模式是基于支持本地 ACID 事务的关系型数据库，Java 应用通过 JDBC 访问数据库：
 * - 一阶段 prepare：在同一个本地事务中，一并提交业务数据更新和相应回滚日志记录，并释放本地锁和连接资源。
 * - 二阶段 commit：马上成功结束，**自动**异步提交，并异步批量清理回滚日志。
 * - 二阶段 rollback：通过一阶段的回滚日志，**自动**异步生成补偿操作，完成数据回滚。
 * - 所有的这些操作，都是在 mysql seata 库中的表中进行操作的。
 *   - lock_table，branch_table，global_table，undo_log。
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderDao orderDao;
    @Resource
    private DeptService deptService;
    @Resource
    private IBaseFeign baseFeign;

    @PostMapping("/add")
    @GlobalTransactional(name = "order-global-transaction", rollbackFor = Exception.class)
    public Department addOrder(@RequestBody Department department){

        boolean add = orderDao.addDept(department);
        if(add){

            boolean dept = deptService.addDept(department);
            if(dept){

                Result<String> city = baseFeign.getCityCode("city");
                if(city.getSuccess()){
                    return orderDao.findById(department.getId());
                }
            }
        }
        return null;
    }

    @GetMapping("/getById/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return orderDao.findById(id);
    }

}
