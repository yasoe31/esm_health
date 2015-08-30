$(function() {
    console.log( "ready!" );
    
   $('#submit').click(function (){
	   console.log('submiting');
	   
	   var name = $('#name').val();
	   //var employee = {"employee":name};
	   

	   var values = [];
       $("input[name^='mytext']").each(function(i, anInput) {
         //values[i] = $(anInput).val();
    	   values[i] = {"name":$(anInput).val()};
       })
	   
       var completeObj={employee:{name:name},skills:{skill:values}};
	   
	   console.log(name);
	   //console.log(employee);
	   console.log(values);
	   console.log(JSON.stringify(completeObj));
	   
	   $.ajax({
		   	url:'/esm/saveEmployee',
	   		datyType:'json',
	   		type:'POST',
	   		contentType: 'application/json; charset=UTF-8',
	   		data:JSON.stringify(completeObj),
	   		processData: false,
	   		success: function(){
	   			
	   		},
	   		error:function(){
	   			
	   		},	   		
	   });
   });
   
   var wrapper         = $(".skill_field_wrap"); //Fields wrapper
   var add_button      = $(".add_more_skill_button"); //Add button ID
   
   $(add_button).click(function(e){ //on add input button click
       e.preventDefault();
       $(wrapper).append('<div><label>Enter Skill : </label><input type="text" name="mytext[]"/><a href="#" class="remove_field">Remove</a></div>'); //add input box
   });
   
   $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
       e.preventDefault(); $(this).parent('div').remove();
   })
    
   
   $('#btn_search').click(function(){
	   console.log("search button");
	   
	   var search=$('#txt_search').val();
	   console.log(search);
	   
	   $.ajax({
		   url:'/esm/searchEmployeeBySkill',
	   		datyType:'json',
	   		type:'GET',
	   		data:{'skill':search},
	   		contentType: 'application/json; charset=UTF-8',	   		
	   		success: function(data){
	   			
	   			//console.log(data[0].employees[0].name);
	   			//console.log(data[1].employees[0].name);
	   			
	   			for (var i = 0; i < data.length; i++) {
	   				console.log(data[i].employees[0].name);
	   				$('#div_result').append('<label> Employee Name : </label>'+data[i].employees[0].name+"<br/>");
	   			}
	   			
	   			
	   			
	   			//$('#div_result').append("<p> "+data[0].employees[0].name+"</p>");
	   			
	   		},
	   		error:function(){
	   			
	   		},	   		
	   });
   });
});


