# Steam查询助手

> 本插件基于[mirai](https://github.com/mamoe/mirai-console)
>
> [![Release](https://img.shields.io/badge/release-v0.1--pre-green)](https://img.shields.io/badge/release-v0.1--pre-green)





## 概览

**这是一个简单粗暴的steam查询插件，可以允许用户通过mirai指令来查询steam商店游戏的价格和简介**



目前本插件强制查询国区和RMB，查询其他区域和其他币种会在后续加入，现在就有需求的可以直接改源代码。

![image-20210615135858123](i1.png)






## 指令

~~由于.st指令与骰娘机器人冲突，而斜杠会触发tim用户的快速黄豆人表情，这里使用逗号~~

| 指令                | 效果             |
| ------------------- | ---------------- |
| ,steam查询  [游戏名] | 列出当前游戏信息 |
| ，steam查询 [游戏名] | 列出当前游戏信息 |
| ,steam设置货币 [国家区域名] | 设置当前群聊的默认货币（参照国家与区域栏） |

##### 



## 安装

1. 按照[mirai](https://github.com/mamoe/mirai-console)的步骤安装mirai机器人
2. 从[发布页](https://github.com/Pmx990/Mirai-Steam-Plugin/releases/tag/v0.1)下载jar文件
3. 将jar文件置入mirai安装文件夹下的plugins文件夹



## TODO 和 其他

* 加入更多功能，目前暂定的有

  1. 自定义货币单位
  2. 自定义查询区域
  3. 根据要求列出api中其他信息
  4. 实现help指令

* 目前还在研究的功能：

  * 加入历史价格/最低价格对比，由于steam api并不提供此功能，如何解决还在研究中。刚开始的想法是去查询steamdb，但这种行为是被steamdb明令禁止的，所以当前还在寻找更好的解决方案。

* 优化代码，当前很多网址都还是hard coded在代码里的，可以说是trash code中的trash code.~~来只是一时兴起没想这么多~~






### 国家与区域

由于Steam按照区域来划分价格，因此查询游戏价格时按照的是国家/地区简称而非货币简称，下表为一些常用的简称

| 国家   | 简称 |
| ------ | ---- |
| 中国   | CN   |
| 美国   | US   |
| 加拿大 | CA   |

本插件已经内置了一个简单的转换器，可以将一些常用的词汇转换为对应的简称，如：

| 输入   | 转换后 |
| ------ | ------ |
| 港币   | HK     |
| 阿根廷 | AR     |
| JPY    | JP     |

但这个转换器的覆盖范围极其有限，而当用户输入转换器内不包含的内容时，转换器会直接将**用户输入的内容**认作是简称，而错误的结果一般是输出美元。因此当用户想要查询其他地区的价格时，可以在网络上自行寻找所需国家/地区的对应缩写并进行设置。

