#笔记内容比较随意，算是第二遍复习带练习，所以虽然是以搭建内容为主，会掺杂一些笔记进来。
1.DI所带来的最大收益：松耦合
2.安装好Maven后，配置setting.xml（关于这里可以参看《Maven实战》2.7.2节，会讲setting.xml全局范围与用户范围的区别）。
  setting.xml中修改&lt;localRepository>F:\0508\repository</localRepository>设置本地仓库地址，然后再mirror标签内添加如下：
  <mirror>
      <id>nexus-aliyun</id>
      <mirrorOf>*</mirrorOf>
      <name>Nexus aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
  </mirror>
  这里使用了阿里的镜像仓库，国内使用这个应该更合适些。
  修改好setting.xml后，在eclipse--Maven--User Setting中选择应用该setting.xml即可。此时关于Maven已经配置好，并可以使用了。
3.在eclipse中创建Maven项目，参看《Maven实战》3.6.2创建Maven项目。
  这里我创建了一个名为spring-action-parent的Maven项目，这是之后其他Maven模块的父模块，创建原因及如何被使用参看《Maven实战》8.3及8.3.1。
  spring-action-parent中的pom.xml文件是我从网上找的，是一个比较完善的web项目依赖，后期可以根据使用情况进行增删。
