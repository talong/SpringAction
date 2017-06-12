# SpringAction
根据《Spring实战》内容搭建的框架,参考其他数据包括（《Maven实战》《Git权威指南》）<br>

初步确定使用技术如下：<br>
1.Maven负责依赖；<br>
2.核心架构：Spring + SpringMVC + ORM（JPA\Hibernate\Mybits）；<br>
3.profile负责测试、QA、生产环境切换；<br>
4.SpringMVC中试图解析采用JSP、Thymeleaf；<br>
5.所有配置以java方式配置和自动装配为主，尽量减少XML；<br>
6.数据库使用MYSQL，暂不考虑NOSQL；<br>
7.Spring的缓存支持，或者采用Redis用作缓存存储；<br>
8.Spring消息整合RibbitMQ；<br>
9.WebSocket暂不使用；<br>
10.最后切换为SpringBoot；<br>


其他辅助技术：<br>
1.测试：mock
