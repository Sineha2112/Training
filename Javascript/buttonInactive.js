const link=document.getElementById("disabled");
link.addEventListener("click",function(event){
	event.preventDefault();
	link.removeEventListener("click");
	});
