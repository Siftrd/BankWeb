<%-- 
    Document   : cauhinh
    Created on : Apr 7, 2023, 11:03:29 AM
    Author     : rioxv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("acc") == null) {
        response.sendRedirect("views/login.jsp");
    }
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manage</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
   <style>
            body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 15px;
}
        </style>
    </head>
    <body>
        <div class="header">
            <jsp:include page="../common/header.jsp"></jsp:include>
        </div>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Configuration</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addRatio"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New</span></a>						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Rate (%/Year) </th> 
                            <th>Rate (%/Month) </th> 
                            <th>Period (Month) </th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${Math.round(o.laiXuat*100)/100} % </td>
                                <td>${Math.round((o.laiXuat/12) * 100) / 100} % </td>
                                <td>${o.kyHan} </td>
                                <td>
                                    <a href="loadRate?id=${o.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="delete?id=${o.id}" da  class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                </table>
               
            </div>
            <a href="home"><button type="button" class="btn btn-primary">Back to home</button> </a>

        </div>
        
        <!-- Edit Modal HTML -->
        <div id="addRatio" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add New Ratio</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Rate</label>
                                <input name="laixuat" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Period</label>
                                <input name="kyhan" type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="confirmDelete" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="delete?id="  method="post" >
                        <div class="modal-header">						
                            <h4 class="modal-title">Confirm Delete</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class ="modal-body">
                        <h5>Are you sure ?</h5>
                         
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="No">
                            <input type="submit" class="btn btn-danger" value="Yes">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
    <script> 
         $('[data-toggle="tooltip"]').tooltip();
    </script>
</body>
</html>