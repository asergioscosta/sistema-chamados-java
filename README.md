# 🛠 Sistema de Chamados - Backend

[![Status do Projeto](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellowgreen.svg)](https://github.com/asergioscosta/sistema-chamados-java)

## 🎯 Objetivo

Este projeto tem como finalidade gerenciar chamados técnicos, oferecendo controle sobre a criação, edição e acompanhamento de solicitações. Desenvolvido com **Java + Spring Boot**, o sistema busca ser escalável, seguro e facilmente integrável com um frontend moderno.

---

## 🗂️ Estrutura do Projeto

```plaintext
📂 sistema-chamados-java/
└── 📂 backend/
    └── 📂 src/
        └── 📂 main/
            └── 📂 java/
                └── 📂 org/
                    └── 📂 example/
                        └── 📂 sistemachamados/
                            ├── 📂 chamado        # Gestão de chamados
                            ├── 📂 config         # Configurações
                            ├── 📂 enums          # Enumerações
                            ├── 📂 exception      # Tratamento de erros
                            ├── 📂 security       # Autenticação
                            └── 📂 usuario        # Gestão de usuários
```

## 🛠 Tecnologias Utilizadas

### Backend
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)](https://spring.io/projects/spring-security)
[![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)](https://jwt.io/)
[![Lombok](https://img.shields.io/badge/Lombok-000000?style=for-the-badge&logo=lombok&logoColor=white)](https://projectlombok.org/)

### Banco de Dados
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

### Ferramentas
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)

## 🔐 Segurança
### Autenticação e Autorização
- **JWT Authentication** (Json Web Tokens)
- **SecurityFilter** customizado integrado ao SecurityFilterChain

### Controle de Acesso
- `ROLE_ADMIN`: Acesso completo
- `ROLE_TECNICO`: Acesso técnico
- `ROLE_USER`: Acesso básico

### Medidas de Segurança
- 🔒 BCrypt para hash de senhas
- 🛡️ Validação de tokens JWT
- 🔄 Refresh Tokens implementado

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17+ instalado
- Maven 3.8+
- PostgreSQL 14+ (ou Docker)
- PGAdmin 4+ (opcional para gerenciamento do banco)

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/asergioscosta/sistema-chamados-java.git
```

### 2️⃣ Acesse a pasta do projeto
```bash
cd sistema-chamados-java
```

### 3️⃣ Configure o banco de dados

Edite o arquivo 
```bash 
src/main/resources/application.properties
```

### 4️⃣ Execute a aplicação

## 👨‍💻 Desenvolvedor

[![Avatar GitHub](https://avatars.githubusercontent.com/u/102989796?v=4&s=150)](https://github.com/asergioscosta)