<!DOCTYPE html>

<%@ page import="java.net.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String hostname, serverAddress;
    hostname = "error";
    serverAddress = "error";
    try {
        InetAddress inetAddress;
        inetAddress = InetAddress.getLocalHost();
        hostname = inetAddress.getHostName();
        serverAddress = inetAddress.toString();
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }
%>

<html lang="en">

<body>
	${time}
	<br /> InetAddress:
	<strong><%=serverAddress%></strong>
	<br /> InetAddress.hostname:
	<strong><%=hostname%></strong>
</body>

</html>