<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
    </head>
    <body>
        <c:url var="saveURL" value="person/save" />
       
        <form action="${saveURL}" method="post">
        
        <input type="hidden" name="id" value="<c:out value='${person.id}' />" />
        
            <div class="form-group">
                <label for="">name:</label>
                <input type="text" class="form-control" name="name" />
            </div>
            <div class="form-group">
                <label for="">email:</label>
                <input type="text" class="form-control" name="email" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
