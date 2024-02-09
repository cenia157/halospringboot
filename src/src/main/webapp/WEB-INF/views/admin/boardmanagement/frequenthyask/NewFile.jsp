<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
    <title>CKEditor Example</title>
</head>
<body>
    <form action="SaveToDBServlet" method="get">
        <textarea name="editor"></textarea>
        <button type="submit">Save to DB</button>
    </form>

    <script>
        CKEDITOR.replace('editor');
    </script>
</body>
</html>
