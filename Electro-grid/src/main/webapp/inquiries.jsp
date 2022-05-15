

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inquiry Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.js"></script>
<script src="Components/inquiries.js"></script>
</head>
<body>
<div class="container"><div class="row"><div class="col-6">
<h1>Inquiry Management</h1>
<form id="formInquiry" name="formInquiry">
 RefNo:
 <input id="refNo" name="refNo" type="text"
 class="form-control form-control-sm">
 <br> User Name:
 <input id="username" name="username" type="text"
 class="form-control form-control-sm">
 <br>  Email:
 <input id="email" name="email" type="text"
 class="form-control form-control-sm">
 <br> Contact:
 <input id="contact" name="contact" type="text"
 class="form-control form-control-sm">
 <br> City:
 <input id="city" name="city" type="text"
 class="form-control form-control-sm">
 <br>Date:
 <input id="date" name="date" type="text"
 class="form-control form-control-sm">
 <br>Remark:
 <input id="remark" name="remark" type="text"
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
 <input type="hidden" id="hidInquiryIDSave" name="hidInquiryIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divInquiriesGrid">
 <table border='1'><tr><th>refNo</th><th>user name</th><th>contact</th><th>email</th><th>city</th><th>date</th><th>remark</th><th>Update</th><th>Remove</th></tr><tr><td><input id='hidInquiryIDUpdate' name='hidInquiryIDUpdate' type='hidden' value='4'>008</td><td>def</td><td>0115896456</td><td>def@gmail.com</td><td>Horana</td><td>2024</td><td>done</td><td><input name='btnUpdate'type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='4'></td></tr><tr><td><input id='hidInquiryIDUpdate' name='hidInquiryIDUpdate' type='hidden' value='6'>008</td><td>abc</td><td>0112849072</td><td>abc@gmail.com</td><td>Gampaha</td><td>2022/</td><td>htrhryh</td><td><input name='btnUpdate'type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='6'></td></tr><tr><td><input id='hidInquiryIDUpdate' name='hidInquiryIDUpdate' type='hidden' value='7'>0115</td><td>asd</td><td>0112843072</td><td>asd@gmail.com</td><td>Horana</td><td>2022/04/28</td><td>Done</td><td><input name='btnUpdate'type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='7'></td></tr></table>
</div>
</div> </div> </div>
</body>
</html>