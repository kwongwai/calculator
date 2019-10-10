<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<title>Assignment For Calculator</title>
<head>



<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link href="/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

	

	<div class="container">

		<div class="starter-template">
			<h1>Calculator</h1>
			<h2>Please enter your math equation here</h2>
			<input type="text" class="span12" id="num"/><h2><span id="result"></span></h2>
		</div>
		<div align="left" >
						<button type="button" id="calculateBtn" class="btn btn-success">Calculate </button>
						<button type="button" id="clearBtn" class="btn btn-danger">Clear </button>
						
		</div>

	</div>
	<!-- /.container -->
	
	<div id="validation_modal" class="modal hide fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Information</h4>
			</div>
			<div  class="modal-body">
				<!-- <label  id="lb_message" ></label> -->
				<p id="validationMsg"></p>
			</div>
			<div class="modal-footer">
				<button id="ok-button" type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
			</div>
		</div>
	</div>
</div>

	
	<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>  	
	<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script>
$(document).ready(function() {
	
});

$("#ok-button").click(function() {
	document.getElementById('num').value='';
});

$("#calculateBtn").click(function() {
	var uploadForm  = new FormData();
	uploadForm.append("num", document.getElementById('num').value);
	if(document.getElementById('num').value==''){
		$("#validationMsg").html("Please enter the maths equation");
		$('#validation_modal').modal("show");
		return;
	}
	
	$.ajax({
           url :"${pageContext.request.contextPath}/calculate" ,
           data : uploadForm,
           type : "POST",
           enctype: 'multipart/form-data',
           processData: false, 
           contentType:false,
           success: function(response){
        var newJ= $.parseJSON(response);
        
        if(newJ.success=='success'){
        	document.getElementById('result').innerHTML=newJ.message;
        }else{
        	$("#validationMsg").html(newJ.message);
    		$('#validation_modal').modal("show");
    		return;
        }
        	
        },
           error : function(data){
           	
           }
       });
	
 });
 
$("#clearBtn").click(function() {
	document.getElementById('result').innerHTML='';
	document.getElementById('num').value='';
});

</script>

</body>

</html>
