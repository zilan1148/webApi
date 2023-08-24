<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 提前将标签引入 -->
<#assign auth="com.lingkang.flynovel.config.tag.AuthTag"?new()>
<@auth contentTxt="isAuthenticated">
新闻内容
</@auth>

<@auth contentTitle="contentTitle">
存在角色 contentTitle
</@auth>

</body>
</html>