<%@ page contentType="text/html;charset=utf-8" %>
<jsp:useBean id="user" class="cn.ldj.mybean.data.User" scope="session" />

<div class="row">
            <div class="col-md-10 col-md-offset-1">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.jsp">手机销售网
	                            <%
									if(user.getLogname() != null) {
								%>
								用户
								<jsp:getProperty property="logname" name="user"/>
								已登录
								<%}%>
							</a>
                        </div>
                        <div>
                            <ul class="nav navbar-nav">
                                <%
                                	if(user.getLogname() == null) { 
                                %>
								<li>
                                    <a href="register.jsp">
                                        <span class="glyphicon glyphicon-user"></span> 注册</a>
                                </li>
                                <li>
                                    <a href="login.jsp">
                                        <span class="glyphicon glyphicon-log-in"></span> 登录</a>
                                </li>
                                <li>
                                    <a href="LookMobileServlet">
                                        <span class="glyphicon glyphicon-phone"></span>浏览手机</a>
                                </li>
                                <li>
                                    <a href="searMobile.jsp">
                                        <span class="glyphicon glyphicon-search"></span>查询手机</a>
                                </li>
                                <%
                                }else { 
                                %>
                                <li>
                                    <a href="LookMobileServlet">
                                        <span class="glyphicon glyphicon-phone"></span>浏览手机</a>
                                </li>
                                <li>
                                    <a href="searMobile.jsp">
                                        <span class="glyphicon glyphicon-search"></span>查询手机</a>
                                </li>
                                <li>
                                    <a href="lookShoppingCar.jsp">
                                        <span class="glyphicon glyphicon-shopping-cart"></span>查看购物车</a>
                                </li>
                                <li>
                                    <a href="lookOrderForm.jsp">
                                        <span class="glyphicon glyphicon-th-list"></span>查看订单</a>
                                </li>
                                <li>
                                    <a href="GetInfoServlet">
                                        <span class="glyphicon glyphicon-edit"></span>修改注册信息</a>
                                </li>
                                <li>
                                    <a href="modifyPassword.jsp">
                                        <span class="glyphicon glyphicon-cog"></span>修改密码</a>
                                </li>
                                <li>
                                    <a href="ExitServlet">
                                        <span class="glyphicon glyphicon-log-out"></span>退出</a>
                                </li>
                                <%} %>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

