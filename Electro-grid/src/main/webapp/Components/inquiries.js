/**
 * 
 */$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});

//SAVE============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateInquiryForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
var type = ($("#hidInquiryIDSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "InquiryAPI",
 type : type,
 data : $("#formInquiry").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onInquirySaveComplete(response.responseText, status);
 }
 });
});

function onInquirySaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divInquiriesGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 } 
 $("#hidInquiryIDSave").val("");
 $("#formInquiry")[0].reset();
}

// UPDATE==========================================

$(document).on("click", ".btnUpdate", function(event)
{
$("#hidInquiryIDSave").val($(this).data("id"));
 $("#username").val($(this).closest("tr").find('td:eq(0)').text());
 $("#contact").val($(this).closest("tr").find('td:eq(1)').text());
 $("#email").val($(this).closest("tr").find('td:eq(2)').text());
 $("#city").val($(this).closest("tr").find('td:eq(3)').text());
 $("#date").val($(this).closest("tr").find('td:eq(4)').text());
 $("#remark").val($(this).closest("tr").find('td:eq(5)').text());
});


//REMOVE==============================================

$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "InquiryAPI",
 type : "DELETE",
 data : "id=" + $(this).data("id"),
 dataType : "text",
 complete : function(response, status)
 {
 onInquiryDeleteComplete(response.responseText, status);
 }
 });
});


function onInquiryDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divInquirysGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}

// CLIENT-MODEL================================================================
function validateInquiryForm()
{

if ($("#refNo").val().trim() == "")
 {
 return "Insert refNo.";
 }

if ($("#username").val().trim() == "")
 {
 return "Insert username.";
 } 
 

if ($("#contact").val().trim() == "")
 {
 return "Insert contact.";
 }
 if ($("#email").val().trim() == "")
 {
 return "Insert email.";
 }
 if ($("#city").val().trim() == "")
 {
 return "Insert city.";
 }
  if ($("#date").val().trim() == "")
 {
 return "Insert date.";
 }
 if ($("#remark").val().trim() == "")
 {
 return "Insert remark.";
 }

return true;
}




/**
 * 
 *//**
 * 
 *//**
 * 
 *//**
 * 
 *//**
 * 
 */