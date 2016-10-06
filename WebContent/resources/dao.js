$(document).ready(function json(){
    $.getJSON('/icsdc/employee/getAll', function(data){
	  var items = [];		
	  //$("#employees").empty();
	  $.each(data, function(key, val){
	      items.push('<li id="' + key + '">' + val + '</li>');
	      $("#employees").append("<option value ='"+ val.id + "'  onclick='getStandsByEmployee("+val.id+");'  > " + val.surname +" "+val.name + " " + val.middleName + "</select>");
	 //     $("#e").append("<input type='button' value='"+val.surname + " " + val.name + " " + val.middleName + " ' style='width: 300px; text-align: left;height: 25px;' />")
	  });
	});
    getStandsByEmployee(1);
});


function getStandsByEmployee(target){
    $.getJSON('/icsdc/stand/getAllByEmployee/'+target, function(data){	
	var items = [];
	$("#stands").empty();
	  $.each(data, function(key, val){
	    items.push('<li id="' + val.id + '">' + val.number + '</li>');
	  	$("#stands").append("<option value ="+ val.id + " > " + val.number + "</select>");
	  });
    })
}








