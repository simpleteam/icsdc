$(document).ready(function json(){
    $.getJSON('/icsdc/organization/getAll', function(data){
	  var items = [];		
	  //$("#employees").empty();
	  $.each(data, function(key, val){
	      items.push('<li id="' + key + '">' + val + '</li>');
	      $("#organizations").append("<option value ='"+ val.id + "'  onclick='getEmployeesByOrganization("+val.id+");'  > " + val.name + "</select>");
	 //     $("#e").append("<input type='button' value='"+val.surname + " " + val.name + " " + val.middleName + " ' style='width: 300px; text-align: left;height: 25px;' />")
	  });
	});
    getEmployeesByOrganization(1);
    getStandsByEmployee(1);
});


function getEmployeesByOrganization(target){
    $.getJSON('/icsdc/employee/getAllByOrganization/'+target, function(data){	
	var items = [];
	$("#employees").empty();
	  $.each(data, function(key, val){
	    items.push('<li id="' + val.id + '">' + val.number + '</li>');
	    $("#employees").append("<option value ='"+ val.id + "'  onclick='getStandsByEmployee("+val.id+");'  > " + val.surname +" "+val.name + " " + val.middleName + "</select>");
	  });
    })
}


function getStandsByEmployee(target){
    $.getJSON('/icsdc/stand/getAllByEmployee/'+target, function(data){	
	var items = [];
	$("#stands").empty();
		$("#stands").append("<tr><td>номер шафки</td><td>альтернативний номер шафки</td></tr>")
	  $.each(data, function(key, val){
	    items.push('<li id="' + val.id + '">' + val.number + '</li>');
	  	$("#stands").append("<tr><td>" + val.number + "</td><td>" + val.alternativeNumber + "</td></tr>");
	  });
    })
}






