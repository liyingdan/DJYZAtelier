<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--combo--%>
<%--    <form action="/addCombo" enctype="multipart/form-data" method="post">
        coName:<input type="text" name="coName"><br/>
        coPrice:<input type="text" name="coPrice"><br/>
        coPicture:<input type="file" name="smPicture"><br/>
        coType:<input type="text" name="coType"><br/>
        desc:<input type="text" name="coDesc"><br/>
        shootingLocations:<input type="checkbox" name="lname" value="海南"/>海南
        <input type="checkbox" name="lname" value="广东"/>广东
        <p>细节图</p>
        <input type="file" name="files" multiple><br/>
        <input type="submit" value="提交">
    </form>--%>

<%--GuestPhoto--%>
<form action="/addGuestPhoto" enctype="multipart/form-data" method="post">
    <input type="text" name="guTime"/>
    <p>10张客照</p>
    <input type="file" name="files" multiple><br/>
    <input type="submit" value="提交">

</form>

</body>
</html>
