var clicked='';

window.onload = function(){
 	console.log(location.href);


    //클릭 이벤트
    //var clicked='';

    var target=document.getElementById("cardList");
    //target.childNodes[1].childNodes[1].childNodes[1].textContent;

    for(var i =0;i<(target.childNodes.length-1)/2;i++){
        target.childNodes[i*2+1].addEventListener("click",function(){
            clicked=target.textContent;
            var hide=document.getElementById("firstTab");
            var show=document.getElementById("content");
            show.style.display='';
            hide.style.display='none';
        });
    }
  }

function funcSubmit(){
	var id = document.getElementById('floatingInput');
	var idArr = id.value.split(/[@|.]/);
	var pw = document.getElementById('floatingPassword').value;
	
	if(id.value.includes('@')==false)
		alert(id.validationMessage);
	else if(idArr[idArr.length-1]!='com'
		   || (idArr[idArr.length-2]!='co' && idArr[idArr.length-1]!='kr' && idArr[idArr.length-1]!='com')
		   || idArr.length!=3)
		alert('이메일 형식을 다시 확인해주세요.');
	else if(id.value=='shchae822@naver.com' && pw=='1234')
		window.open('main.html');
	else
	    alert('id와 password를 확인해주세요!');
}