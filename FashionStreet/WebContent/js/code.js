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
	alert("yo");
	var searchText = $('#searchText').val();
    $.ajax({
        url : 'rest/search/do',
        type : 'PUT',
        data : {searchText : searchText},
        success : function(response) {
        	alert(response);
        	//window.location = response;
        }
    });
});

$('#addToCartBtn').click(function(){
	var name = "Puma Sneaker";
	var price = 499.00;
    $.ajax({
        url : 'rest/cart/add',
        type : 'PUT',
        data : {name : "Puma", price : "499"},
        success : function(response) {
        	window.location = response;
        }
    });
});