<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>静夜思</h1>
<p>${author}</p>
<#list test as value >
    <p>${value.first}${value.second}</p>
</#list>
</body>
</html>