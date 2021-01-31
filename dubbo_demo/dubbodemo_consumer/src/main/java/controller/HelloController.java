package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //使用dubbo，到注册中心查找对应的服务
    //在服务消费者一方配置负载均衡策略
    @Reference(check = false, loadbalance = "random")
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name) {
        //远程调用
        return helloService.sayHello(name);
    }
}
