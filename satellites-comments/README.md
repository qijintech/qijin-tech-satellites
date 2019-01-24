使用步骤：

1.添加依赖
```xml
<dependency>
    <groupId>tech.qijin.satellites</groupId>
    <artifactId>satellites-comments</artifactId>
    <version>${satellites.version}</version>
</dependency>
```
2.执行`create_table.sql`，创建对应的数据库table

3.sqlMapConfig.xml中添加`Channel`映射。如果已有，则无需添加
```xml
<typeHandlers>
    <typeHandler handler="tech.qijin.util4j.mybatis.handler.EnumValueTypeHandler"
                 javaType="tech.qijin.util4j.trace.pojo.Channel" />
</typeHandlers>
```

4.确保sqlMapConfig.xml中有`PageHelper`插件的配置


5.确保`@SpringBootApplication`中有如下配置
```java
@SpringBootApplication(
        exclude = PageHelperAutoConfiguration.class)
```