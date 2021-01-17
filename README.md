# Library Seat Reservation

#### 介绍
图书馆座位预约，SpringBoot + SpringSecurity + MyBatis + MySQL实现。需要结合微信小程序使用，小程序仓库地址：[https://github.com/weingxing/Library-Seat-Reservation-WeChat](https://github.com/weingxing/Library-Seat-Reservation-WeChat)

为了参加校内一个竞赛（为了学分）而开发 ╮(╯▽╰)╭ ，代码写的比较急，有一些不符合编码规范的地方和小bug，
另外还有一个莫名其妙的bug被莫名其妙的解决了（不知道什么原因造成的，改了改突然就正常了，不知道哪里写错了，改回去又出错）。

代码可参考或二次开发，但请勿直接用于二次参赛（任何级别的竞赛）。

已经提交作品完成答辩，等待结果...

结果已出：特等奖（学校组织的比赛，比较水）




> 展示：[https://test.mapletown.xyz](https://test.mapletown.xyz)
>
> 用户名：admin
>
> 密码： 123456
>
> **请不要修改密码**

微信小程序：

<img src='./miniprogram.jpg' width='20%' />

> 需要绑定学号才可正常体验，请自行在后台添加信息。
>
> 签到可以通过向 `/wechat/enter` 发送Get请求来模拟，具体请求参数见 `WeChatController` 类。


#### 开发环境
- IntelliJ IDEA
- MySQL 5.6
- Java 8
- OpenCV 4.3.0


#### 部署说明
涉及到人脸识别的功能，使用虹软的SDK和OpenCV实现，face包下为人脸识别签到模块（本应该单独写，用于模拟考勤机，因为太懒，不想写（复制粘贴）实体类，所以写到了一个项目中），
运行前需要先配置OpenCV环境（具体方法请自行百度），将项目导入编辑器后，要手动导入OpenCV的jar包（也可以自行修改Maven配置文件实现自动导入）。


遇到问题可以直接在项目提issue，会尽可能回复。。。

