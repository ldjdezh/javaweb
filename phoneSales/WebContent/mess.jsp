<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>提示信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />
        
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                <% String mess = (String)request.getAttribute("mess"); %>
                    <h2><%=mess %></h2>
                </div>
            </div>
        </div>
    </div>



    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>