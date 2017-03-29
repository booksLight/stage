$(document).ready(function() {
	
	$("#invLedger").on("click", function() {		
		$("#mainDiv").load("/admin/order");
	});

	$("#invCatalogue").on("click", function() {	
		$("#mainDiv").load("/admin/productInventory");
	});

	$("#invPortfolio").on("click", function() {
		$("#mainDiv").load("/admin/customers");		
	});

	 var table = $('#ordRepo').DataTable({
		 "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]],	
		 "sAjaxSource": "/admin/repo",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
				  { "mData": "customerOrderId", 
					  render : function(data) {
						  return data		                 
		                } 				 
				  },
		          { "mData": "customerName" },
				  { "mData": "productName" },
				  { "mData": "orderedQty", "class": "text-center"},
				  { "mData": "orderedAmt", "class": "text-center"},
				  { "mData": "stamped" ,
				  "render": function (mData) {
				        var date = new Date(mData);
				        var month = date.getMonth() + 1;
				        return date.getDate() + "/" + (month.length > 1 ? month : "0" + month) + "/" + date.getFullYear()
				       /* + " " +date.getHours()+ ":" +date.getMinutes()+ ":" +date.getSeconds()*/
				        ;
				    }
				  },
				  { "mData": "status" },
				  { "mData": "confirmed" },
				  { "mData": "shipped" }
			],
			 retrieve: true,
			 paging: true
	 });
	
	 $('#ordRepo tbody').on('click', 'td', function () {
        var dtv = table.cell( this ).data();        
        console.log( 'You clicked on '+dtv+'\'s row..' );       
       /* $("#mainDiv").load("/cart/order/book/"+dtv); */
       /* $.post("/cart/order/book/"+dtv );*/
    } );
});

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
