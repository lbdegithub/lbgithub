## 民E通对接

### 首页

### 

​     用户、社区对接   用户携带部门信息

1. 事件（平安巡防、消防巡检、你盯我办）

   后端提供接口，APP端推送事件、初始状态、处理中、完结状态

   问题：

   事件类型统一：后端提供

2. 活动

   后端后台创建，提供接口给APP端展示，参与人员调用后台接口添加  考虑社区范围

   设计：除以上还需要调用APP端接口推送活动钉钉消息

   问题：

   活动详情中满意度如何统计

   活动详情中民众反馈如何统计 不要

   活动详情中参与人员是否需要展示 不要

3. 通知公告

   后端创建，提供接口给APP端，确认未读、已读  是由app端封装钉钉接口提供给后端

   设计：除以上还需要调用APP端接口推送活动钉钉消息

​       问题：公告属于推送类的，是否需要APP端提供接口，后端直接推送公告



### 微治理

1.消防物资

--后端提供接口，APP推送物资信息

--后端提供接口，APP推送汇总信息

APP提供接口，后端通过微站信息过滤调用并缓存  选详细楼栋信息

问题：

救灾次数哪里提供  静态维护

消防力量哪里提供  静态维护



消防微站

--后端提供接口，APP推送微站信息

--后端提供接口，APP推送汇总信息

APP提供接口，后端调用并缓存



平安大巡防

巡防次数统计需要APP端提供接口

巡逻事件：后端统计

事件类型需要商定

问题：

按月统计时下面曲线图如何展示



积分

积分按照整个户不是按照人

积分增减接口由后端提供，APP只是产生事件  后端提供积分过程接口给APP端调用展示

积分趋势接口由后端提供

问题：



减分榜是否统计积分兑换

事件对应扣分规则维护由后端维护



### 智安小区

隐患预警

推送预警给消控室的人消息  只是提醒  还是要到8900确认

APP只是提供通用性推送消息接口



### 民e通

你盯我办

问题：

--状态只有已处理、未处理，无处理中

服务事项统计中的事件是否都是来自你盯我办，是

事件类型确认：以APP为准



平安学堂

APP端提供统计接口



志愿帮扶

问题：

帮扶团队对接



积分商城

问题：

--活动、积分统计由APP端提供接口

后端跟农行对接积分商城接口  农行提供接口



信息发布

后端维护，提供接口给APP端调用展示



物业平台由农行提供

后端需要提供访客接口给农行

5100：

用户信息添加身份证信息，提供接口给APP端，匹配成功后将APP端userid保存

将组织部门同步给APP端，APP端自己做匹配关系

角色权限是否默认需要创建很多默认角色

垃圾分类、电动车违章：中枢

小区警情：从镇街获取












