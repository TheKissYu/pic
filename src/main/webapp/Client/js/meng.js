function aa(id){
	$.ajax({
		type:"get",
		url :"/mgzf/area/list?id="+id,
		success : function(data) {
			data.data.splice(0, 0, {"arId":0,"arName":"不限","arCtId":0});
			app1.obj = data.data;
		}
	})
}