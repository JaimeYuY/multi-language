# springboot i18n国际化方案
## 实现思路
1. 使用springboot i18n来实现国际化
2. 如何自定义其他语言

## 国际化演示
1. 下载源代码
2. 启动系统
3. 接口访问，设置Accept-Language头信息，中文:zh-CN，英文：en-US，截图如下：

## 如何添加一个自定义的语言，以德语为例
1. 添加一个message_german.properties语言配置文件，并配置响应码提示信息，如下图
2. 启动系统项目
3. 接口访问，头信息Accept-Language设置为german, 如下图：
