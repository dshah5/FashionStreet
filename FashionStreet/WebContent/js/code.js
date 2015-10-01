$('#restButton').click(function(){
    	var cpassword = $('#cpassword').val();
    	var password = $('#password').val();
        $.ajax({
            url : 'rest/reg/check',
            type : 'PUT',
            data : {cpassword: cpassword, password: password},
            success : function(response) {
                alert(response);
            }
        });
    });

$('#searchButton').click(function(){
	var searchText = $('#searchText').val();
    $.ajax({
        url : 'rest/search/do',
        type : 'PUT',
        data : {searchText : searchText},
        success : function(response) {
        	window.location = response;
        }
    });
});