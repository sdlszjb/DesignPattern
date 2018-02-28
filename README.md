1. 单例模式 singleton 单例/线程安全
2. 工厂方法 factory 产品的生产封装化
3. 抽象工厂 absfactory 多族/多产品/横向扩展容易，纵向扩展困难。
4. 模板方法 template 继承/父类控制基本方法执行顺序，子类实现基本方法
5. 建造者   builder 导演类/组装顺序
6. 代理     proxy 为已实现类增加额外功能
7. 原型     prototype 对象复制/克隆
8. 中介者   mediator 多个对象互相依赖严重/mvc
9. 命令     command 对执行者进行封装/封装操作集合
10. 责任链  chain 诸如流程/处理者自行决定由谁处理
11. 装饰    decorator
12. 策略    strategy 重点在算法的替换/与Command的不同在于，Command重点在于执行对象的解耦。
Example。zip和gzip，命令模式可以有 压缩 解压缩 两个命令，但是具体的执行者可以有两个。
策略模式 可以由zip策略和gzip策略，每种策略均提供类压缩和解压缩的方法。
13. 适配器  wrapper 将一个或多个类包装成一个类
14. 迭代器  iterator
15. 组合    composite
16. 观察者  observer
17. 门面    facade
18. 备忘录  memento
19. 访问者  visitor
20. 状态    
21. 解释器  interpreter
22. 享元    flyweight
23. 桥梁    bridge