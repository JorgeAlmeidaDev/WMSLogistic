# 🚀 Sistema WMS (Warehouse Management System) - Java e Spring Boot

Este projeto é uma **simulação de um sistema de gerenciamento de armazém (WMS)**, desenvolvido em **Java** com o **Spring Boot** e banco de dados **MySQL**. Foi criado com o objetivo de praticar conceitos de desenvolvimento backend, bancos de dados relacionais e APIs RESTful.

## 🧩 Funcionalidades principais

✅ Cadastro de produtos  
✅ Cadastro de motoristas  
✅ Cadastro de veículos  
✅ Criação de pedidos e transporte  
✅ Visualização de relatórios e status  
✅ Integração com banco de dados MySQL  
✅ Interface web simples (templates HTML com Thymeleaf)  

## 📂 Estrutura do projeto

src/
├── main/
│ ├── java/com/wms/simulacao/
│ │ ├── controller/ # Controladores das rotas (API REST e páginas)
│ │ ├── entity/ # Entidades do banco de dados
│ │ ├── repository/ # Repositórios (acesso ao MySQL)
│ │ ├── service/ # Regras de negócio
│ │ ├── config/ # Configurações gerais (ex.: Swagger, segurança)
│ │ └── WmsApplication.java # Classe principal do projeto
│ └── resources/
│ ├── application.properties # Configuração do banco de dados
│ ├── templates/ # Páginas HTML
│ └── static/ # Arquivos estáticos (CSS, JS, etc.)
└── test/ # Testes automatizados

## ⚙️ Tecnologias utilizadas

- Java 17+
- Spring Boot 3+
- MySQL
- Thymeleaf
- Maven
- JUnit

## 💻 Como executar localmente

1️⃣ Clone o projeto:  
```bash
git clone https://github.com/JorgeAlmeidaDev/WMSLogistic.git
cd WMSLogistic
2️⃣ Crie um banco de dados MySQL chamado wms_logistic e configure o usuário e senha no arquivo application.properties.

3️⃣ Execute o projeto:

bash
Copiar
Editar
./mvnw spring-boot:run
4️⃣ Acesse no navegador:

arduino
Copiar
Editar
http://localhost:8080
🌟 Contribuindo
Quer contribuir? Veja o arquivo CONTRIBUTING.md para saber como participar!

📜 Licença
Este projeto é apenas para fins de estudo e aprendizado.

💡 Sobre o projeto
Este projeto simula um cenário real de um sistema WMS, ajudando a praticar Java, Spring Boot, MySQL e boas práticas de desenvolvimento de software.

Espero que este projeto ajude você a entender como funciona um sistema de gerenciamento de armazém e a melhorar suas habilidades como desenvolvedor!
