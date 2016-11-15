<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Nuevo Pedido | TPO AD</title>
<!-- 	<link href="css/styles.css" rel="stylesheet" type="text/css" /> -->
	  <link href="css/bootstrap.min.css" rel="stylesheet" />
	  <script src="js/jquery-1.9.1.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container">
	
    <div class="row">
      <div class="col-sm-6">
        <h2>Nuevo Pedido</h2>
      </div>
    </div>
    <div class="row">
	  <div class="col-sm-6">
	    <table id="productTable"
	           class="table table-bordered
	                 table-condensed table-striped">
	      <thead>
	        <tr>
	          <th>Product Name</th>
	          <th>Introduction Date</th>
	          <th>URL</th>
	        </tr>
	      </thead>
	    </table>
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-sm-6">
	    <button type="button" id="addButton"
	            class="btn btn-primary"
	            onclick="addClick();">
	      Add Product
	    </button>
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-sm-6">
	    <div class="panel panel-primary">
	      <div class="panel-heading">
	        Product Information
	      </div>
	      <div class="panel-body">
	      </div>
	      <div class="panel-footer">
	      </div>
	   </div>
	  </div>
	</div>
	
	<div class="form-group">
		  <label for="productname">Product Name</label>
		  <input type="text" id="productname"
		         class="form-control" />
		</div>
		<div class="form-group">
		  <label for="introdate">Introduction Date
		  </label>
		  <input type="date" id="introdate"
		         class="form-control" />
		</div>
		<div class="form-group">
		  <label for="url">URL</label>
		  <input type="url" id="url"
		         class="form-control" />
		</div>
		
	<div class="row">
	  <div class="col-xs-12">
	    <button type="button" id="updateButton"
	            class="btn btn-primary"
	            onclick="updateClick();">
	      Add
	   </button>
	  </div>
</div>
	
  </div>

</body>
</html>