# SpringAction
根据《Spring实战》内容搭建的框架

初步确定使用技术如下：
1.Maven负责依赖；
2.核心架构：Spring + SpringMVC + ORM（JPA\Hibernate\Mybits）；
3.profile负责测试、QA、生产环境切换；
4.SpringMVC中试图解析采用JSP、Thymeleaf；
5.所有配置以java方式配置为主，尽量减少XML；
6.数据库使用MYSQL，暂不考虑NOSQL；
7.Spring的缓存支持，或者采用Redis用作缓存存储；
8.Spring消息整合RibbitMQ；
9.WebSocket暂不使用；
10.最后切换为SpringBoot；


其他辅助技术：
1.测试：
