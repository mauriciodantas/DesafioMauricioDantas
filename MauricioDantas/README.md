DesafioMotoComBr:
==============================================================
Author: George Rodrigues, Rodrigo Parede  
Level: Intermediário  
Technologies: JSP, JPA, JSON, Spring, JUnit  
Summary: O `DesafioMotoComBr` é um desafio envolvendo Java EE 6 application utilizando JSP, JPA 2.0 and Spring 4.x.  
Source: <https://github.com/wmotocombr/DesafioMotoComBr/>  

Desafio
-----------

Realizar o cadastro de registros e listagem automática e exclusão dos registros através da estrutura de projeto pré-definida.   
Crie um path para consulta REST da lista de registros e do registro único.   
Implemente o teste unitário das funcionalidades.   
 
Cadastro
-----------

O cadastro deverá conter os campos: 

Nome: (String)   
Email: (String - seria interessante ter ao menos uma validação para o dado)    
Telefone: (String - seria interessante ter ao menos uma validação para o dado)     


Listagem
-----------

A tabela de listagem dos registros deverá conter os campos:

Id:(id do registro no banco)   
Nome: (nome do usuário cadastrado)   
Email: (email do usuário cadastrado)    
Telefone: (telefone do usuário cadastrado)   
REST URL: (caminho para entrega rest/json do registro em específico)    

Requisitos
-----------

Processo de build Maven   
Framework Spring    
Persistência JPA   
Servidor WildFly ou JBoss AS7   
Entregar em repo público (github) com o código fonte   
Compilar na IDE Eclipse (plugin: http://marketplace.eclipse.org/content/jboss-tools)  
Java 7+   

Requisitos Desejáveis
-----------

Teste unitário  
