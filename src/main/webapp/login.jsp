
<!DOCTYPE html>
<html lang="en">
<body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="jquery.serializejson.min.js"></script>
<script>
$(document).ready(function(){
$("#simplepost").click(function(e)
{
var MyForm = $("#ajaxform").serializeJSON();
console.log(MyForm);
$.ajax({
    url:'http://localhost:8080/jersey-shiro-AD/api/v1/logon',
    type:'POST',
    data: JSON.stringify(MyForm),
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    success:function(res){
        alert("it works!");
    },
    error:function(res){
        alert("Bad thing happend! " + res.statusText);
    }
});
 e.preventDefault(); //STOP default action

});
});</script>
</body>
<div id="message"> </div>
<form name="ajaxform" id="ajaxform" method="POST">
Username: <input type="text" name="username" value =""/> <br/>
Password: <input type="password" name="password" value ="" /> <br/>
Google auth code: <input type="text" name="code" value =""/> <br/>
<input type="button" class="btn btn-info" id="simplepost" value="Run Code"></form>
</html>

<span style="text-align: justify;">
</html>