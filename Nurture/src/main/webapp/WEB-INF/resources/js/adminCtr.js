
$(document).ready(function() {
	
	$.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
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