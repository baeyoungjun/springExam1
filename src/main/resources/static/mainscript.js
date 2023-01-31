
var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.6.3.min.js';
document.getElementsByTagName('head')[0].appendChild(script);

var clicked='';

window.onload = function(){
 	console.log(location.href);
    }

function funcSubmit() {
	var id = document.getElementById('floatingInput').value;
	var idArr = id.split(/[@|.]/);
	var pw = document.getElementById('floatingPassword').value;
	if(id.includes('@')==false)
		alert(id.validationMessage);
	else if(idArr[idArr.length-1]!='com'
		   || (idArr[idArr.length-2]!='co' && idArr[idArr.length-1]!='kr' && idArr[idArr.length-1]!='com')
		   || idArr.length!=3)
		alert('이메일 형식을 다시 확인해주세요.');
	$.ajax({
	    type: 'post',
	    url: '/api/login',
	    headers: {
	        "Content-Type": "application/json"
	    },
	    dataType: 'json',
	    data: JSON.stringify({
            "userId":id,
            "userPw":pw
        }),
        success: function(result) {
            location.replace("/main");
        },
        error: function(request, status, error) {
            console.log(error);
        }
	});
}