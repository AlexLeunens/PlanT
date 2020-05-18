/**
 * 
 */

document.getElementById('prev-tab').addEventListener('click', function (event) {
	var prev = $('.nav-pills > .active').prev('a')
    if(prev.length){
      prev.trigger('click');
    }else{
      $('#nav-tab a:last').tab('show');
      }

});
	
document.getElementById('next-tab').addEventListener('click', function (event) {
	var next = $('.nav-pills > .active').next('a');
    if(next.length){
      next.trigger('click');
    }else{
      $('#nav-tab a:first').tab('show');
   
	}

});