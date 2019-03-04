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
    
    $().ready(function(){ //�������error��Ϊ�գ�����ʾ�û��������������
        if(getQueryString("error")==2){
            $(".error_message").removeClass("hide");
        }
    });
    
	</script>
</head>
<body>
	<div>

		<!-- ���� -->
		<div class="page-header"
			style="margin:40px 0px 0px;border-bottom: 2px solid #B40605;">
			<h2 style="width:960px;margin:0px auto;">
				<b>������У���������� ������/ר���� ����ϵͳ �༭���˻�����Ϣ</b>
			</h2>
		</div>

		<div style="background-color:#EEE;height:41px;width:100%;">
			<div
				style="width: 960px;margin: 0px auto;font-size: 16px;line-height: 40px;">
				<span style="color:#B40605;float:left;">�û����ã�
					�������֤���룺${currUser.identity}</span> <span style="float:right;"> <a
					href="/BMweb/user/index">ϵͳ��ҳ</a> <a
					href="/BMweb/user/editpwd/${currUser.identity}">�޸�����</a> <a
					href="/BMweb/user/index?logout">�˳���½</a></span>
			</div>
		</div>

		<div style="width: 960px;margin: 0px auto;font-size: 14px;">
			<table class="table table-bordered" style="margin-top:20px;">
				<tr>
					<td style="font-weight:bold;"><font color="#0D69D3">��д˵����</font></td>
				</tr>
				<tr>
					<td>��1����������д������Ϣ����д��Ϻ������·��ġ�ȷ������ť��</br> ��3����<font color="#FF0000"
						size="3px;"> * </font>��Ϊ�����</br>
					</td>
				</tr>
				<table>
					</div>


					<!-- ������Ϣ -->
					<sf:form method="post" id="Zusr_info" modelAttribute="u_info"
						action="/BMweb/bminfo/updateZuserInfo?update">
						<input name="u_id" type="hidden" value="${uinfo.u_id}">
						<table class="table table-bordered">
							<tr>
								<td style="font-weight:bold;width: 340px;"><font
									color="#0D69D3">������Ϣ��</font></td>
								<td><a style="color:#a94442;" class="hide error_message ">����д���д�" * "�ŵ�ѡ��</a></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>���֤��</td>
								<td>${uinfo.identity }<input name="identity" type="hidden"
									value="${uinfo.identity}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>����</td>
								<td><input type="text" name="name" value="${uinfo.name}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>�Ա�</td>
								<td><select name="sex"><option>��</option>
										<option>Ů</option></select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>��������</td>
								<td><input type="date" name="birthday"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>����</td>
								<td><select name="n_id" id="n_id">
										<c:forEach var="nation" items="${nations}">
											<option value="${nation.n_id}">${nation.n_name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>����</td>
								<td><select name="p_id" id="p_id">
										<c:forEach var="place" items="${places}">
											<option value="${place.p_id}">${place.p_name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>������ò</td>
								<td><select name="political"><option>��Ա</option>
										<option>��Ա</option>
										<option>Ⱥ��</option></select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>��ҵѧУ</td>
								<td><input type="text" name="gradShool"
									value="${uinfo.gradShool}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>��ҵʱ��</td>
								<td><input type="date" name="gradTime"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>��������</td>
								<td><select name="gradCate"><option>��ͨ����</option>
										<option>��������</option>
										<option>��������</option>
										<option>��ר��ҵ��</option></select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>ѧ��</td>
								<td><select name="education"><option>����</option>
										<option>��ר</option></select></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>�߿��ɼ�</td>
								<td><input type="text" name="results"
									value="${uinfo.results}"></td>
							</tr>
						</table>

						<!-- ͨѶ��Ϣ -->
						<table class="table table-bordered">
							<tr>
								<td style="font-weight:bold;"><font color="#0D69D3">ͨѶ��Ϣ��</font></td>
								<td></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>ͨѶ��ַ</td>
								<td><input class="form-control" type="text" name="address"
									value="${uinfo.address}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>���֤��ַ</td>
								<td><input class="form-control" type="text"
									name="homeAddress" value="${uinfo.homeAddress}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>������</td>
								<td><input type="text" name="t_name"
									value="${uinfo.t_name}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>�ʱ�</td>
								<td><input type="text" name="code" value="${uinfo.code}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>��ϵ�绰</td>
								<td><input type="text" name="telephone"
									value="${uinfo.telephone}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>����</td>
								<td><input type="text" name="email" value="${uinfo.email}"></td>
							</tr>
							<tr>
								<td style="text-align:right;"><font color="#FF0000"
									size="3px;"> * </font>QQ</td>
								<td><input type="text" name="qq" value="${uinfo.qq}"></td>
							</tr>
							<tr>
								<td style="text-align:right;">��ע</td>
								<td><textarea class="form-control" name="remarks" rows="3"></textarea></td>
							</tr>
						</table>

						<button type="submit" class="btn btn-danger center-block"
							style="margin-bottom:30px;" onclick="$('#Zusr_info').submit();">����</button>
					</sf:form>
					</div>
					<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
					<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
					<!-- Include all compiled plugins (below), or include individual files as needed -->
					<script src="/BMweb/resources/js/bootstrap.min.js"></script>
</body>
</html>