天眼系统需要的字段：

- ##### IloopContractedCompany天眼的签约企业：（获取企业接口）

  `logoName` varchar(100) DEFAULT NULL COMMENT '自定义logo名称',
  `logoUrl` varchar(512) DEFAULT NULL COMMENT '自定义logo地址',

  `developmentPerson` varchar(20) DEFAULT NULL COMMENT '发展人'。

  

```
`iloopContractedCompanyId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '签约企业ID',
`companyName` varchar(32) NOT NULL COMMENT '企业名称',
`iloopOrganizationId` bigint(20) NOT NULL COMMENT '运营组织ID',
```

> 这三个是业务上需要的，用的最多的字段

  

```
`clientId` varchar(64) DEFAULT NULL COMMENT '企业接入的clientId', 

`clientSecret` varchar(64) DEFAULT NULL COMMENT '企业接入的clientSecret',
```

> 这两个字段是用户认证企业，通过接口对接时的认证参数

​    

```
`reportNode` varchar(64) DEFAULT NULL COMMENT '设置上报节点',

`reportStatus` char(1) DEFAULT '0' COMMENT '匿名上报0：允许，1：不允许',
```

> 用于设置企业的功能属性，主要用于小程序

  

```
`protocolStatus` varchar(10) DEFAULT '0' COMMENT '车辆信息授权协议状态 0:未授权，1：已授权',

`iotTime` int(6) DEFAULT NULL COMMENT 'iot的请求次数(中交兴路的查询次数)',
```

> 记录企业是否授权中较兴路，中交的查询次数

  

  ?  目前天眼是通过企业ID来控制数据权限的，接入用户平台后是否可以废弃。

> 利用企业查询当前用户对应的所有企业ID

  

- ##### 用户表iloopuser（获取用户详情接口）

  `id`

  `userName`（realName）

  > 用户平台都满足

  

  `mobile`

  > （订单评价，业务员，消息推送）是否需要在Token中添加 

  

  `openId`

  > 用于记录用户登录程序的ID（需要优化，用户可能登录多个小程序）

  

- ##### 用户小程序信息表（可以直接迁移到oms中）appletuseinfo

  ？全部迁移（运营平台还需要展示）



------

## 还有一些 pc端和小程序段直接调base的接口。

##### PC端：

/iloop-base/file/upload     `文件上传接口：直接调用oms中的接口`

/iloop-base/userGrid/getTableHead    `获取动态表头接口：迁移到运营平台，待定`
/iloop-base/userGrid/refreshHead   `前段主动刷新表头接口：迁移到运营平台，待定`

/iloop-base/contractedCompany/data    `获取当前用户的签约企业接口：迁移到运营平台`
/iloop-base/contractedCompany/getCompanyInfo     `获取当前用户获取签约企业详情接口：迁移到运营平台`
/iloop-base/organization/detail     `获取运营组织详情接口：迁移到运营平台`

/iloop-base/admin/user/getCustomInfo    `获取企业自定义信息接口：可以舍弃` 

/iloop-base/admin/user/updateCustomInfo     `修改企业自定义接口：可以舍弃`

/iloop-base/admin/user/userRole     `获取角色息接口：可以舍弃`
/iloop-base/admin/user/modifyPassword     `修改密码接口：可以舍弃`

/iloop-base/admin/user/saleManList     `获取业务员接口：用户平台？待定`



##### 小程序端：

**登录接口**：目前是采用授权成功之后，随机生成`token`的方式。同时会记录用户`openId`，如果用户不存在，则新增。

**小程序用户个人信息接口：**记录用户身份的接口，目前对应的表在base中，可以考虑迁移到`oms`中。



....



------

#### 问题：

在运营平台中，承运商是，两个企业之间的关系。目前 在天眼中，是作为一个基础属性。是否把天眼中的承运商移到运营平台的企业管理中？



目前天眼的所有接口，查询和更新操作都是需要获取当前用户对应的企业的id，用来记录，或者筛选数据（数据权限的控制），如果改造之后，接入用户平台，需要怎么**控制数据权限**。



数据字典：数据字典的接口是否要迁移到运营平台？oms中字典表是否要删除？



开放接口还需要测试。

天眼目前的司机没有创建对应的用户。

