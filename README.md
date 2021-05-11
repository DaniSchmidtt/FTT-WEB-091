# Password Wallet

API - JAVA, APACHE TOMCAT E MYSQL

FRONT - BOOTSTRAP, JSP E JAVASCRIPT

## Devs
| Nome | RA |
| ------ | ------ |
| Caio dos reis | 081180043 |
| Danilo Schimidt  | 081180007 |

## Script das tabelas:
CREATE TABLE `password` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `SITE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `remember` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `QUESTION` varchar(200) DEFAULT NULL,
  `ANSWER` varchar(200) DEFAULT NULL,
  `SITE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## Telas:
Pagina inicial e Exluir senhas:
![image](https://user-images.githubusercontent.com/56918423/117881025-21a53d00-b27f-11eb-947c-360461e6b7e9.png)
Adicionar senha:
![image](https://user-images.githubusercontent.com/56918423/117881040-2833b480-b27f-11eb-8db6-33e36a9ddc72.png)
Editar senha:
![image](https://user-images.githubusercontent.com/56918423/117881194-55806280-b27f-11eb-9411-8682bf97093d.png)
Aba Remembers e Excluir Remember:
![image](https://user-images.githubusercontent.com/56918423/117881213-5ca77080-b27f-11eb-9e80-90cc83be3f4b.png)
Adicionar Remember:
![image](https://user-images.githubusercontent.com/56918423/117881262-6b8e2300-b27f-11eb-8725-fa4fe8326214.png)
Editar Remember:
![image](https://user-images.githubusercontent.com/56918423/117881391-94161d00-b27f-11eb-8a76-4341814cbd8b.png)

