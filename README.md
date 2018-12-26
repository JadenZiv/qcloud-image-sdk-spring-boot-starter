## 腾讯（智能图像服务）qcloud-image-sdk的spring-boot-starter
### 官方的源代码
1. 查看腾讯sdk [源代码](https://github.com/tencentyun/image-java-sdk-v2.0) 
2. 官方源代码有比较详细的入门 [demo](https://github.com/tencentyun/image-java-sdk-v2.0/blob/master/src/main/java/com/qcloud/image/demo/Demo.java) 
### 集成该项目
**使用maven**
```
<dependency>
   <groupId>cn.jadenziv.source</groupId>
   <artifactId>qcloud-image-sdk-spring-boot-starter</artifactId>
   <version>1.0.0</version>
 </dependency>
```
### 使用方法

1.在**application.yml**简单配置
```
qcloud:
  image:
    secret-id: xxx
    app-id: xxx
    secret-key: xxx
```
2.注入**ImageService**就可以使用
```
@Autowired
private ImageService imageService;
```
3.默认是不开启代理的,需要在yml里配置开启
```
qcloud:
  image:
    secret-id: xxx
    app-id: xxx
    secret-key: xxx
    is-enable-proxy: true
    ip: xxxx
    host: 8080
    type: http
```
4.如果要使用官方sdk的服务，注意官方的返回的是一个json字符串，需要自己解析
```
@Autowired
private Image image;
```
### 注意事项
1. 该项目是跟springboot整合的,所以必须在springboot的环境下才可以使用
2. 将**org.json**的json解析包换成**jackson** 
3. 把官方sdk返回的字符串封装成对象，开发者在进行调用时不用自行封装
### 官方的bug
1. 解决官方sdk导入到springboot项目会报错的bug，该bug是因为和springboot下json包冲突了，官方在其他sdk上有给出[解决方案](https://github.com/qcloudsms/qcloudsms_java/issues/7)
2. 解决官方sdk用byte[] 时报错的[bug](https://github.com/tencentyun/image-java-sdk-v2.0/issues/14) ，腾讯至今还没有回复该bug
