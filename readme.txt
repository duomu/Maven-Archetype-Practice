骨架项目生成和使用步骤：
1.对项目demo执行mvn archetype:create-from-project，生成该项目的骨架项目archetype（在target/generated-sources/目录下）
2.对骨架项目archetype进行打包：mvn clean install，打包到本地仓库
3.用idea新建项目，选择新生成的archetype，仓库设为本地仓库，继续设置新项目的maven坐标，完成相关操作
4.执行完以上步骤，耐心等待即可生成和demo一样组织结构的maven普通项目

ps新创建的maven普通项目src/main/resources目录下遗留了骨架项目中的两个配置文件，后续研究如何避免生成这俩文件：
demo-resources/pom.xml
META-INF/maven/demo-metadata.xml


2017-09-08更新：解决生成多余文件的问题
对项目demo执行mvn archetype:create-from-project，生成该项目的骨架项目archetype后，需要修改一下archetype的配置：
将src/main/resources/META-INF/maven/archetype-metadata.xml修改如下，指定要包含的文件路径

<fileSet filtered="true" encoding="UTF-8">
      <directory>src/main/resources</directory>
      <includes>
        <!--此处改写，避免生成不必要的文件-->
        <include>mybatis/**/*.*</include>
        <include>spring/**/*.*</include>
        <include>*.*</include>
        <!--<include>**/*.txt</include>
        <include>**/*.xml</include>
        <include>**/*.properties</include>-->
      </includes>
</fileSet>