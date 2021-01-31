package service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import service.HelloService;

//使用Dubbo提供的Service注解
//在服务提供者一方配置负载均衡
@Service(interfaceClass = HelloService.class, loadbalance = "random")
@Transactional
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
