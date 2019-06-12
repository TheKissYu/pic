/**
 * 余昊泽的工具 用者自取
 */

/**
 * 
 * select html的部分  id和lay-filter保持一致
 <form class="layui-form layui-form-pane" action="">
 <div class="layui-form-item">
 <label class="layui-form-label">城市</label>
 <div class="layui-input-block" id="city" lay-filter="city">
 </div>
 </div>
 </form>
 * 
 * */
//{data:[] 数据,valueName:选中时显示那个属性的值,label:[]选项显示那些属性 ,id:所在div的id,values:默认选中的值}
/**
 * 
 * @param obj
 *            {data:[] 数据,valueName:选中时显示那个属性的值,label:[] （选项显示那些属性是一个数组）
 *            ,id:所在div的id,values:默认选中的值}
 * @returns
 */
function select_in(obj) {
	layui.config({
		base : 'layui/lay/modules/'
	}).use([ 'selectPlus', 'jquery' ], function() {
		var $ = layui.$, selectPlus = layui.selectPlus;

	
		var city = selectPlus.render({
			el : '#' + obj.id,
			data : obj.data,
			type : "radio",
			valueName : obj.valueName,
			label : obj.label,
			values : obj.values
		});
	})
}
function select_on(id,callback) {
	layui.config({
		base : 'layui/lay/modules/'
	}).use([ 'selectPlus', 'jquery' ], function() {
		var $ = layui.$, selectPlus = layui.selectPlus;

		selectPlus.on('selectPlus('+id + ')', function(obj) {
			// 单选时
			console.log(obj);
			set_city(obj.checkedData.ctName,obj.checkedData.ctId);
			callback(obj.checkedData);
		});
		
	})
}
var arr = [ {
	type : "优选1",
	isFrist : false,
	list : [ {
		id : 1,
		imgurl : "images/fang1.jpg",
		space : 12,
		name : "虹桥乐亭",
		dringRoom : 3,
		toilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : 12,
		name : "静安豪景",
		dringRoom : 3,
		toilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : 147,
		name : "虹桥乐亭",
		dringRoom : 3,
		roilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : 147,
		name : "虹桥乐亭",
		dringRoom : 3,
		toilet : 2
	} ]
}, {
	type : "优选2",
	isFrist : true,
	list : [ {
		id : 1,
		imgurl : "images/fang1.jpg",
		space : 147,
		name : "静安豪景",
		dringRoom : 3,
		toilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : "147m²",
		name : "静安豪景",
		dringRoom : 3,
		roilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : 147,
		name : "静安豪景",
		dringRoom : 3,
		toilet : 2
	}, {
		id : 1,
		imgurl : "images/fang2.jpg",
		space : 147,
		name : "静安豪景",
		dringRoom : 3,
		toilet : 2
	} ]
} ]
function getarr() {
	return arr;
}

var arr1 = [ {
	type : "1",
	isFrist : false,
	left : {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	},
	list : [ {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1111
	} ]
}, {
	type : "2",
	isFrist : true,
	left : {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	},
	list : [ {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	}, {
		id : 1,
		imgurl : "images/fang1.jpg",
		name : "虹桥乐亭",
		info : "习近平强调，中方重视发展中南中方重视发展中南“同志加兄弟”的特殊关系。双方要坚持做",
		price : 1234
	} ]
} ]

function getarr1() {
	return arr1;
}
function get_house_veu(id) {
	var vm = new Vue({
		el : '#' + id,
		data : {
			list :{},
		}
	});
	return vm;
}
function get_house_veu1(id) {
	var vm = new Vue({
		el : '#' + id,
		data : {
			list :{},
		}
	});
	return vm;
}
function get_house_veu2(id) {
	var vm = new Vue({
		el : '#' + id,
		data : {
			list :{},
		}
	});
	return vm;
}
function getWindowInfo() {
	var info = 0;
	var str = location.search.substr(1);
	if (str.length > 1) {
		info = str.split('=')[1];
	}
	return info;
}

function set_city(ctName,ctId){
	$.ajax({
		type : "post",
		url : "/mgzf/city/setcity",
		data : {
			"ctName" : ctName,
			"ctId" : ctId
		},
		datatype : "json",
		success:function(data){
			if(data.code!=1){
				alert("城市查询失败")
			}
		}
	})
}
function loadselect(callback){
	var first;
	$.ajax({
		type : "get",
		url : "/mgzf/city/getname",
		datatype : "json",
		success:function(data){
			if(data.code == 1){
				
				first = data.data;
				$.ajax({
					type : "get",
					url : "/mgzf/city/list",
					datatype : "json",
					success : function(data) {
						if (data.code == 1) {
							var obj = data.data;
							if (first == null) {
								first = obj[0].ctName;
							}
							select_in({
								data : obj,
								valueName : "ctName",
								label : [ "ctName" ],
								id : "city",
								values : first
							});
							select_on("city",function(data){
								callback(data);
							})
						}
					}
				})
			}
		}
	})
	
}

function get_city_id(){
	var id ;
	$.ajax({
		type : "get",
		url : "/mgzf/city/getid",
		datatype : "json",
		async:false,
		success:function(data){
			id=data.data;
		}
	})
	return id;
}

function getlist(url,obj){
	$.ajax({
		type : "get",
		url : "/mgzf/house"+url,
		datatype : "json",
		success:function(data){
			if(data.code == 1){
				obj.list= data.data
			}
		}
	})
}