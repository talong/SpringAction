#笔记内容比较随意，算是第二遍复习带练习，所以虽然是以搭建内容为主，会掺杂一些笔记进来。<br>
1.DI所带来的最大收益：松耦合<br>
2.安装好Maven后，配置setting.xml（关于这里可以参看《Maven实战》2.7.2节，会讲setting.xml全局范围与用户范围的区别）。<br>
  setting.xml中修改localRepository设置本地仓库地址，然后在mirror标签内添加url为http://maven.aliyun.com/nexus/content/groups/public的镜像地址，
  这里使用了阿里的镜像仓库，国内使用这个应该更合适些。<br>
  修改好setting.xml后，在eclipse--Maven--User Setting中选择应用该setting.xml即可。此时关于Maven已经配置好，并可以使用了。<br>
3.在eclipse中创建Maven项目，参看《Maven实战》3.6.2创建Maven项目。<br>
  创建两个Maven模块：book-email和book-perisist，然后创建book-aggregator用于聚合前两个模块，注意聚合模块的pom.xml的packaging必须是pom。聚合中的注意事项参看《Maven实战》8.3聚合。
  此时也注意到book-email和book-perisist的pom.xml文件内容存在相同的依赖，故创建book-parent成为父项目，负责公用依赖，具体的修改参看《Maven实战》8.3继承。

