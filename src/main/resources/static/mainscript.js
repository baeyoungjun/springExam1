window.onload = function(){
 	console.log(location.href);
  }

function funcSubmit(){
	var id = document.getElementById('floatingInput');
	var idArr = id.value.split(/[@|.]/);
	var pw = document.getElementById('floatingPassword').value;
	
	if(id.value.includes('@')==false)
		alert(id.validationMessage);
	else if(id.value.split(/[@|.]/)[id.value.split(/[@|.]/).length-1]!='com'
		   || (id.value.split(/[@|.]/)[id.value.split(/[@|.]/).length-2]!='co' && id.value.split(/[@|.]/)[id.value.split(/[@|.]/).length-1]!='kr')
		   || idArr.length!=3)
		alert('이메일 형식을 다시 확인해주세요.');
	else if(id.value=='shchae822@naver.com' && pw=='1234')
		window.open('main.html');
}