<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Validity Demo Application</title>
   </head>
   <body>
      
    <body>
        <h2>Welcome To Duplicate Detector Application</h2>
        <form action ="displaydata.htm" name="myform" method = "Get">
             
            <LABEL FOR="selection"><b>Please make your selection below:</b><br /></LABEL>
            <br>
            <select name="selection" id="ddtype">
                <option value="Normal">Normal</option>
                <option value="Advanced">Advanced</option>
            </select><br><br>
            <input type="radio" name="userSelection" value="Duplicate" required/>Duplicate<br/>
            <input type="radio" name="userSelection" value="No Duplicates" required/>No Duplicates<br/>
            <input type="radio" name="userSelection" value="Mispell" required/>Misspells<br/>
            <input type="radio" name="userSelection" value="No Mispell" required/>No Misspell<br/>
            <br>
            <input type="Submit" name="Submit" value ="Submit">
        </form>
    </body>
    
   </body>
</html>