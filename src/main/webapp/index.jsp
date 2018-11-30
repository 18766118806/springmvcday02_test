<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#bt").click(function () {
                $.ajax({
                    url: "user/body",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        alert(data.username)
                        alert(data.password)
                    }

                })
            })
        })

    </script>
</head>
<h3>springmvc文件上传</h3>
<form action="user/fileupload" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"/>
    <input type="submit" value="上传">
</form>
<a href="user/modelAndView">modelAndView</a>
<input id="bt" type="button" value="ajax请求">
</body>
</html>
