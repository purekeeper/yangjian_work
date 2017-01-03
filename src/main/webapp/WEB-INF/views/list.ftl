<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title>Free CSS template by ChocoTemplates.com</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all"/>
</head>
<table>
    <tr>
    <#-- <th width="13"><input type="checkbox" class="checkbox"/></th>-->
        <th><h3>标题</h3></th>
        <th><h3>面积</h3></th>
        <th><h3>几室</h3></th>
        <th><h3>几厅</h3></th>
        <th><h3>价格</h3></th>
        <th><h3>所在楼层</h3></th>
        <th><h3>总楼层</h3></th>
        <th><h3>发布者</h3></th>
        <th><h3>详情</h3></th>
    <#-- <th><h3>wlistTotalJobs</h3></th>-->
        <th width="110" class="ac"><h3>Action</h3></th>
    </tr>
<#list houses as house>
    <tr>
        <td>${house.title}</td>
        <td>${house.area}</td>
        <td>${house.rooms}</td>
        <td>${house.halls}</td>
        <td>${house.price}</td>
        <td>${house.floor}</td>
        <td>${house.totalFloor}</td>
        <td>${house.publiser}</td>
        <td>${house.url}</td>
    </tr>
</#list>
</table>
<body>
</body>
</html>