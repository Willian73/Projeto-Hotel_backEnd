<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel</title>
</head>
<body>
   <form action="" method="post">
        <ul>
            <li>
                <label for="nome">Nome:</label>
                <input id="nome" name="nome" type="text">
            </li>
            <li>
                <label for="endereco">Endere�o:</label>
                <input id="endereco" name="endereco" type="text">
            </li>
            <li>
                <label for="contato">Contato:</label>
                <input id="contato" name="contato" type="text">
            </li>
            <li>
                <label for="lista-funcionarios">Lista Funcion�rios:</label>
                <input id="lista-funcionarios" name="lista-funcionarios" type="text">
            </li>
            <li>
                <label for="lista-acomodacoes">Lista acomoda��es:</label>
                <input id="lista-acomodacoes" name="lista-acomodacoes" type="text">
            </li>
         </ul>
        <input type="submit" value="salvar">
    </form>
    
</body>
</html>