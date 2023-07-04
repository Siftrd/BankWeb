<%-- 
    Document   : Edit
    Created on : May 26, 2022, 6:42:16 PM
    Author     : rioxv
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<!-- Edit Modal HTML -->
        <div id="editProduct">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="edit" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Rate</h4>
                            <button type="button" onclick="location.href='cauhinh';" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>ID </label>
                                <input type="text" name="id" value="${detail.id}" class="form-control" readonly="readonly" required>
                            </div>
                            <div class="form-group">
                                <label>Rate</label>
                                <input type="text" name="laixuat" value="${detail.laiXuat}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Period</label>
                                <input type="text" name="kyhan" value="${detail.kyHan}" class="form-control" required>
                            </div>
                        
 		
                        </div>
                        <div class="modal-footer">
                            <input type="button" onclick="location.href='cauhinh';" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>
