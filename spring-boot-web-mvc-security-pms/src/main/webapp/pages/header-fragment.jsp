<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <i class="fas fa-code fa-2x text-warning pb-3 pt-3 pr-2"></i>
   <a class="navbar-brand" href="/home">Portfolio 
  	<c:if test="${auth.isAuthenticated() }">
  		${auth.name }
  	</c:if>
  </a>
  <ul class="navbar-nav">
    <li class="nav-item ">
      <a class="nav-link" href="/home">Home</a>
    </li>
    
     <c:choose>
    	<c:when test="${auth.isAuthenticated() }">
    	
    <security:authorize access="hasAnyAuthority('INVESTOR','BOR')">
   <li class="nav-item ">
      <a class="nav-link" href="/company">Companies</a>
   </li> 
    <li class="nav-item ">
      <a class="nav-link" href="/stocks">Stocks</a>
   </li> 
   <li class="nav-item ">
      <a class="nav-link" href="/commodity">Commodities</a>
   </li>
   </security:authorize>
   
   <security:authorize access="hasAuthority('INVESTOR')">
   	<li class="nav-item ">
	  <a class="nav-link" href="/investor/new">Buy Stocks</a>
	</li> 
	</security:authorize>
	
	<security:authorize access="hasAuthority('BOR')">
    <li class="nav-item ">
      <a class="nav-link" href="/company/new">Create Company</a>
   </li>
    <li class="nav-item ">
      <a class="nav-link" href="/stocks/new">Add Stock Price</a>
   </li>  
    <li class="nav-item ">
      <a class="nav-link" href="/commodity/new">Add New Commodity</a>
   </li> 
    </security:authorize>
    
    <security:authorize access="hasAuthority('SUPERUSER')">
   <li class="nav-item ">
	  <a class="nav-link" href="/register/bor">Register Back Office User</a>
	</li>
	</security:authorize>
	
	<li class="nav-item ">
	   <a class="nav-link" href="/logout">Log Out</a>
	</li>
   </c:when>
    	<c:otherwise>
    	<li class="nav-item ">
		      <a class="nav-link" href="/login">Sign In</a>
		 </li>
		 <li class="nav-item ">
		      <a class="nav-link" href="/register">New Investor?</a>
		 </li>  
		</c:otherwise> 
	</c:choose>
  </ul>
</nav>