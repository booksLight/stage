
$(document).ready(function() {
	
		$("#invLedger").on("click", function() {
			$("#mainDiv").load("/cart/admin/orders");
		});
	
		$("#invCatalogue").on("click", function() {
	        $("#mainDiv").load("/cart/admin/productInventory");
	    });
		
		$("#invPortfolio").on("click", function() {
	        $("#mainDiv").load("/cart/admin/customers");
	    });
    
});


  /*
function getProductInventory() {
    document.getElementById("mainDiv").innerHTML='<object type="text/html" data="<c:url value="/admin/productInventory" />" ></object>';
}
*/
/*
{
	"Message": "Number of Post office(s) found: 4",
	"Status": "Success",
	"PostOffice": [{
		"Name": "Ghosi  (Jehanabad)",
		"Description": "",
		"BranchType": "Sub Post Office",
		"DeliveryStatus": "Delivery",
		"Taluk": "Ghoshi",
		"Circle": "Ghoshi",
		"District": "Jehanabad",
		"Division": "Gaya",
		"Region": "Patna HQ",
		"State": "Bihar",
		"Country": "India"
	},*/