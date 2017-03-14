
$(document).ready(function() {
	alert("Jquery Started ");
  
	
	$.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
	
	
	$("#product-form").submit(function(event) {

		// Prevent the form from submitting via the browser.
		event.preventDefault();
		//addProductViaAjax();

	});
    
});
  

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