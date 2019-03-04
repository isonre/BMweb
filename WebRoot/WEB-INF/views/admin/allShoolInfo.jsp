<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>广西高校联合招生网报名系统  管理后台</title>

    <link href="/BMweb/resources/css/bootstrap.min.css" rel="stylesheet">
 	<link href="/BMweb/resources/css/dashboard.css" rel="stylesheet">
	
	<script src="/BMweb/resources/js/jquery.2.js" type="text/javascript"></script>

  </head>

  <body>
    <h2 class="sub-header">学校信息 <small> <a class="btn btn-default " href="/BMweb/admin/ShoolInfoIdex" role="button"><font color="#CC6600" size="4px;"> + </font>添加</a></small></h2>
            <table class="table table-striped">
              <thead>
                <tr>
               	  <th>id</th>
                  <th>种类</th>
                  <th>名称</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              
              <c:forEach var="shool" items="${shoolList}">
              <tr id="userinfo-item-${shool.s_id}">
              <td>${shool.s_id }</td>
              <td>${shool.category }</td>
              <td>${shool.s_name }</td>
               <td><a id="bt-cfm-del-comment" href="javascript:;" onclick="deleteShoolInfo('#userinfo-item-${shool.s_id}','${shool.s_id}');">删除</a></td>
              </tr>
              </c:forEach>

              </tbody>
            </table> 
            
		<script type="text/javascript">  														   
 			function deleteShoolInfo(odject,id){
            id = parseInt(id);
            $("#bt-cfm-del-comment").click(function(){
                    data="s_id="+id;
                    $.post(
                        "ajax/deleteShoolInfo",
                        data,
                        function(result){
                            if(result=="success"){
                                $(odject).remove();
                            }
                        },
                        "text");    
                });
            $('#cfrm-del').modal({
             keyboard: false,
             backdrop:"static"
            });
        };	
        													   
</script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="/BMweb/resources/js/bootstrap.min.js"></script>
  </body>
</html>
