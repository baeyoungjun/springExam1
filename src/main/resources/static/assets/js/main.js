var clicked='';

window.onload = function(){
 	console.log(location.href);


    //클릭 이벤트
    //var clicked='';

    var target=document.getElementById("cardList");
    //target.childNodes[1].childNodes[1].childNodes[1].textContent;

    for(var i =0;i<(target.childNodes.length-1)/2;i++){
        target.childNodes[i*2+1].addEventListener("click",function(event){
            clicked=event.target.getAttribute('value');
            var hide=document.getElementById("firstTab");
            var show=document.getElementById("content");
            show.style.display='';
            hide.style.display='none';
        });
    }
  }
