<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/css.jsp"%>
<%@ include file="/taglib.jsp"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>Yep! This is hello.jsp</h2>
<p>Annotate <code>HelloController</code> with <code>@Controller</code>,due to declaration indicates like below in <code>spring-mvc.xml</code> : </p>
<pre><code>&lt;context:component-scan base-package="com.kavlez.controller" use-default-filters="false"&gt;
    &lt;context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/&gt;
&lt;/context:component-scan&gt;
</code></pre>
</body>
</html>