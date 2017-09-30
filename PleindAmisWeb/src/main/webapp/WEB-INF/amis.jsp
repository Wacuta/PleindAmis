<%--
  Created by IntelliJ IDEA.
  User: Maxime Guyot
  Date: 21/09/2017
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Title</title>
        <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <h1>Bonjour <c:out value="${user.loginPers}"/></h1>

        <div class="flex-row">

            <!-- form de redaction -->
            <form class="flex-column">
                <h3>Ecris à tes amis</h3>
                <select name="loginAmi" >
                    <option value="${user.loginPers}">Mon mur</option>
                    <c:forEach items="${user.amis}" var="ami">
                    <option value="${ami.loginPers}"><c:out value="${ami.loginPers}"/> </option>
                    </c:forEach>
                </select>

                <textarea name="message" cols="30" rows="10"></textarea>
                <button type="submit" name="action" value="mmAmi">Envoyer</button>

            </form>

            <!-- Mon Mur -->
            <div class="flex-column">
                <h3>Mon Mur</h3>

                <c:forEach items="${user.mmRecus}" var="m">
                <div class="message">
                    <c:out value="${m.textMM}" />
                </div>
                </c:forEach>

            </div>

            <!-- Liste de connecté -->
            <div class="flex-column">
                <h3>Liste de connecté</h3>
                <c:forEach items="${listUser}" var="u">
                    <c:if test="${user.loginPers != u.loginPers}">
                        <form>
                            ${u.loginPers}
                            <input type="hidden" name="loginAmi" value="${u.loginPers}">
                            <button type="submit" name="action" value="addAmi">Add</button>
                            <ul>
                                <c:forEach items="${u.mmRecus}" var="mmR">
                                <li>${mmR.emetteur.loginPers}: ${mmR.textMM}</li>
                                </c:forEach>
                            </ul>
                        </form>
                    </c:if>
                </c:forEach>
            </div>

        </div>

    </body>
</html>
