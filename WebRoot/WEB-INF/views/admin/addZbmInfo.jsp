<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>��ҳ</title>

<!-- Bootstrap -->
<link href="/BMweb/resources/css/bootstrap.min.css" rel="stylesheet">

<script src="/BMweb/resources/js/jquery.2.js" type="text/javascript"></script>

<script type="text/javascript">
    function getQueryString(name) {//��ȡĳ��url�������Ĳ���
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }
    
    $().ready(function(){ 
   		 //�����֤�ű�����Ϣ�Ѵ��ڣ�����������
   	    if(getQueryString("error")==1){
            $(".error_message1").removeClass("hide");
        }
        //������֤���벻��Ϊ��
        if(getQueryString("error")==2){
            $(".error_message2").removeClass("hide");
        }
         
    });
    
	</script>

</head>
<body>

	<h2 class="sub-header">���ר��־Ը��Ϣ</h2>
	<hr>
	<div class="col-sm-9  col-md-10  main">
		<div class="table-responsive">
			<!-- ������Ϣ -->
			<sf:form method="post" id="zbm" modelAttribute="zbm_info"
				action="/BMweb/admin/addZbmInfoIdex">
				<table class="table table-bordered">
					<tr>
						<td style="font-weight:bold;width:340px;"><font
							color="#0D69D3">־Ը��Ϣ��</font></td>
						<td><a style="color:#a94442;" class="hide error_message2">����д���д�"
								* "�ŵ�ѡ��</a> <a style="color:#a94442;" class="hide error_message1 ">�����֤��־Ը��Ϣ�Ѵ��ڣ�����������</a></td>
					</tr>
					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>���֤��</td>
						<td><input type="text" id="identity" name="identity"></td>
					</tr>
					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>��һ־Ը</td>
						<td><select name="shool1" id="shool">
								<c:forEach var="shool" items="${shools}">
									<option value="${shool.s_id}">${shool.s_name}</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>רҵһ</td>
						<td><select name="pro1" id="pro_1">
								<c:forEach var="professional" items="${professionals}">
									<option value="${professional.pro_id}">${professional.p_name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>רҵ��</td>
						<td><select name="pro2" id="pro_2">
								<c:forEach var="professional" items="${professionals}">
									<option value="${professional.pro_id}">${professional.p_name}</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>�ڶ�־Ը</td>
						<td><select name="shool2" id="shool_1">
								<c:forEach var="shool" items="${shools}">
									<option value="${shool.s_id}">${shool.s_name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>רҵ��</td>
						<td><select name="pro3" id="pro_3">
								<c:forEach var="professional" items="${professionals}">
									<option value="${professional.pro_id}">${professional.p_name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td style="text-align:right;"><font color="#FF0000"
							size="3px;"> * </font>רҵ��</td>
						<td><select name="pro4" id="pro_4">
								<c:forEach var="professional" items="${professionals}">
									<option value="${professional.pro_id}">${professional.p_name}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-danger center-block"
					style="margin-bottom:30px;" onclick="$(zbm).submit();">��������</button>
			</sf:form>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/BMweb/resources/js/bootstrap.min.js"></script>
</body>
</html>