<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
    <style type="text/css">
        body {
            font-family: sans-serif;
        }

        .data, .data td {
            border-collapse: collapse;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px;
        }

        .data th {
            font-weight: bold;
            background-color: #5C82FF;
            color: white;

        }
    </style>
</head>
<body>

<h2>Verse Manager</h2>

<form:form method="post" action="add.html" commandName="bibleVerse">

    <table>
        <tr>
            <td><form:label path="verseDay"><spring:message code="label.verseDay"/></form:label></td>
            <td><form:input path="verseDay"/></td>
        </tr>
        <tr>
            <td><form:label path="verseEng"><spring:message code="label.verseEng"/></form:label></td>
            <td><form:textarea cols="32" rows="10" path="verseEng"/></td>
        </tr>
        <tr>
            <td>
                <form:radiobutton path="bibleLanguage" value="kin" label="Kinyarwanda"/>
                <form:radiobutton path="bibleLanguage" value="fra" label="Français"/>
                <form:radiobutton path="bibleLanguage" value="eng" label="English"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.addVerse"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<h3>Daily verseEng</h3>
<c:if test="${!empty verseList}">
    <table class="data">
        <tr>
            <th>Verse</th>
            <th>date for the verseEng</th>
            <th>Language</th>

        </tr>
        <c:forEach items="${verseList}" var="verseEng">
            <tr>
                <td>${verseEng.verseEng}</td>
                <td>${verseEng.verseDay} </td>
                <td>${verseEng.bibleLanguage}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
