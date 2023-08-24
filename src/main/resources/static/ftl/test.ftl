<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试生成静态文件</title>
</head>

<body>
<h1>静夜思</h1>
<p>${author!}</P>
<#if (test?size)!=0>
    <#list test as item>
        <p>${item.first!}${item.second!}</p></br>
    </#list>
</#if>
</body>

</html>