<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Company Profile</title>
</head>
<body>

                        <c:if test="${comp_code != null}">
                            <form action="modify" method="post">
                        </c:if>
                        <c:if test="${comp_code == null}">
                            <form action="add" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${comp_code != null}">
                                    Edit Company 
                                </c:if>
                                <c:if test="${comp_code == null}">
                                    Add New Company
                                </c:if>
                            </h2>
                        
                     
<form>
		<table>
		<tr>
		<td>Company code</td>
		<td><input type="text" name="comp_code" required value="<c:out value='${company.companyCode}' />"/></td>
		</tr>
		<tr>
		<td>Company Title</td>
		<td><input type="text" name="comp_title" required value="<c:out value='${company.companyTitle}' />"/></td>
		</tr>
		<tr>
		<td>Operations</td>
		<td><input type="text" name="comp_operations" required value="<c:out value='${ccompany.companyOperations}' />"/></td>
		</tr>
		<tr>
		<td>Share Count</td>
		<td><input type="number" name="sharecount" required value="<c:out value='${company.shareCount}' />" /></td>
		</tr>
		<tr>
		<td>Open Share Price</td>
		<td><input type="number" name="open_share_price" required value="<c:out value='${company.openSharePrice}' />"/></td>
		</tr>
		<tr>
		<td>Sector</td>
		<td>
             <select name="sector" id = "sector" required value="<c:out value='${company.sector}' />">
             <option value = "">Select one</option>
               <option value = "agriculture">Agriculture</option>
               <option value = "pharma">Pharmaceutical</option>
               <option value = "finance">Finance</option>
              </select>
             </td>
		</tr>
		<tr>
		<td>Currency</td>
		<td>
		 <select name="currency" id = "currency" required value="<c:out value='${company.currency}' />">
             <option value = "">Select one</option>
               <option value = "usd">USD</option>
               <option value = "inr">INR</option>
               <option value = "eur">EUR</option>
              </select>
              </td>
		</tr>
		<tr>
		<td>Turnover</td>
		<td><input type="number" name="turnover" required value="<c:out value='${company.turnover}' />"/></td>
		</tr>
		<td></td>
		<td><input type="submit" value="Save"/>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>