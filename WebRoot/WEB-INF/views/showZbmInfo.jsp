<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>主页</title>

<!-- Bootstrap -->
<link href="/BMweb/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div>

		<!-- 顶部 -->
		<div class="page-header"
			style="margin:40px 0px 0px;border-bottom: 2px solid #B40605;">
			<h2 style="width:960px;margin:0px auto;">
				<b>广西高校联合招生网 专科生 报名系统</b>
			</h2>
		</div>

		<div style="background-color:#EEE;height:41px;width:100%;">
			<div
				style="width: 960px;margin: 0px auto;font-size: 16px;line-height: 40px;">
				<span style="color:#B40605;float:left;">用户您好！
					您的身份证号码：${currUser.identity}</span> <span style="float:right;">
					<a href="/BMweb/user/index">系统首页</a>　<a href="/BMweb/user/editpwd/${currUser.identity}">修改密码</a>　<a href="/BMweb/user/index?logout">退出登陆</a></span>
			</div>
		</div>

		<div style="width: 960px;margin: 0px auto;font-size: 14px;">
			<table class="table table-bordered" style="margin-top:20px;">
				<tr>
					<td style="font-weight:bold;"><font color="#0D69D3">信息说明：</font></td>
				</tr>
				<tr>
					<td>（1）报名信息一经提交，用户登录系统后可查看个人基本信息和志愿信息。</br> 
					（2）系统仅支持修改信息,一经提交不可删除。
					</td>
				</tr>
				<table>
					</div>

					<!-- 志愿信息 -->
					<sf:form method="post" id="zbm" modelAttribute="zbm_info" action="/BMweb/bminfo/ZuserInfoIdex">
					<table class="table table-bordered">
						<tr>
							<td style="font-weight:bold;width:340px;"><font color="#0D69D3">志愿信息：</font></td>
							<td><c:if test="${currUser.identity==zbminfo.identity}"><font color="#009933">信息已提交至系统</font></c:if></td>
						</tr>
						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>第一志愿</td>
							<td>${zbminfo.shool.s_name}</td>
						</tr>
						
						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>专业一</td>
							<td>${zbminfo.pro_1.p_name}</td>
						</tr>
						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>专业二</td>
							<td>${zbminfo.pro_2.p_name}</td>
						</tr>
						
 						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>第二志愿</td>
							<td>${zbminfo.shool_1.s_name}</td>
						</tr> 
						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>专业二</td>
							<td>${zbminfo.pro_3.p_name}</td>
						</tr>
						<tr>
							<td style="text-align:right;"><font color="#FF0000"
								size="3px;"> * </font>专业二</td>
							<td>${zbminfo.pro_4.p_name}</td>
						</tr>
					</table>
						
					<c:if test="${currUser.identity==zbminfo.identity}">
						<a href="/BMweb/bminfo/editZbmInfo/${zbminfo.identity}" type="button" class="btn btn-danger center-block"
							style="margin-bottom:30px;width: 100px;">修改</a>
					</c:if>
					
					</sf:form>
					</div>
					<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
					<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
					<!-- Include all compiled plugins (below), or include individual files as needed -->
					<script src="/BMweb/resources/js/bootstrap.min.js"></script>
</body>
</html>