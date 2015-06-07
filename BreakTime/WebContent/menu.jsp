<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

        <div id="header">
        	<h2><a href="#">BreakTime</a></h2>
        </div>
        
        <div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li  class="btn btn-inverse dropdown" id="profile-messages" >
                	<a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                	<i class="icon icon-user"></i>  
                	<span class="text">欢迎Admin</span>
                	<b class="caret"></b></a>
	                <ul class="dropdown-menu">
	                    <li><a href="#"><i class="icon-user"></i> 人员信息</a></li>
	                    <li class="divider"></li>
	                    <li><a href="#"><i class="icon-cog"></i> 密码修改</a></li>
	                    <li class="divider"></li>
	                    <li><a href="login.html"><i class="icon-check"></i> 登录信息</a></li>
	                 </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="logout.action"><i class="icon icon-share-alt"></i> <span class="text">登出</span></a></li>
            </ul>
        </div>

        <!--
        <div id="search">
            <input type="text" placeholder="Search here..." />
            <button type="submit" class="tip-right" title="Search">
            	<i class="icon-search icon-white"></i>
            </button>
        </div>
        -->

        <div id="sidebar">
            <ul>
                <li class="active"><a href="main.jsp"><i class="icon icon-home"></i> <span>首页</span></a></li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-th-list"></i> <span>管理员账户管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="admin_info.jsp">管理员信息查询</a></li>
                        <li><a href="admin_register.jsp">管理员信息录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-th-list"></i> <span>饮品类别管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="type_info.jsp">饮品类别查询</a></li>
                        <li><a href="type_register.jsp">饮品类别录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-file"></i> <span>饮品管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="drink_info.jsp">饮品信息查询</a></li>
                        <li><a href="drink_register.jsp">饮品信息录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-file"></i> <span>订单管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="order_new.jsp">未处理的订单</a></li>
                        <li><a href="order_old.jsp">已处理的订单</a></li>
                    </ul>
                </li>
            </ul>
        </div>
