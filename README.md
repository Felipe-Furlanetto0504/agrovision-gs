<div align="center">

# 🌱 AgroVision

### Plataforma de Gestão Inteligente de Fazendas

*Monitoramento de Plantações, Colheitas e Insumos via API REST*

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI_3-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Oracle](https://img.shields.io/badge/Oracle-Database-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white)

<br/>

> **FIAP — Global Solution 2026/1**
> **Tema: 🚀 O Espaço é a Nova Fronteira — Economia Espacial**

</div>

---

## 👥 Equipe

| Nome | RM |
|:---|:---:|
| João Victor Caetano Alves da Silva | RM 562074 |
| João Victor Bueno Castelini da Silva | RM 564115 |
| Ryan Vetoriano | RM 565667 |
| Felipe Furlanetto | RM 562766 |
| Raul Rezende Iemini Aguiar | RM 564002 |

---

## 📌 Links do Projeto

| Recurso | Link |
|:---|:---|
| 🎬 **Vídeo de Apresentação** (até 10 min) | `[ a preencher ]` |
| 🎯 **Video Pitch** (até 3 min) | `[ a preencher ]` |
| 💻 **Repositório GitHub** | `https://github.com/Felipe-Furlanetto0504/agrovision-gs` |

---

## 🌍 Sobre o Projeto

O **AgroVision** é uma API REST completa para gestão de fazendas, desenvolvida com **Java 21 + Spring Boot 3**. A plataforma permite que produtores rurais gerenciem suas plantações, registrem colheitas, controlem o estoque de insumos e acompanhem o histórico de safras — tudo integrado a um app mobile React Native.

### 🔁 Fluxo da Solução

```
👤 Produtor cadastra conta
         │
         ▼
🌱 Registra plantações com status (PLANTADO / PREPARACAO / DESCANSO)
         │
         ▼
🧪 Associa insumos às plantações monitoradas
         │
         ▼
🌾 Registra colheita (safra) quando plantação está PLANTADO
         │
         ▼
📊 Relatórios gerados automaticamente
```

---

## 🏗️ Arquitetura do Projeto

```
agrovision/
├── src/
│   ├── main/
│   │   ├── java/br/com/fiap/agrovision/
│   │   │   ├── AgroVisionApplication.java
│   │   │   ├── config/
│   │   │   │   ├── OpenApiConfig.java          ← Swagger / OpenAPI 3
│   │   │   │   └── SecurityConfig.java         ← Spring Security + JWT + CORS
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── UsuarioController.java
│   │   │   │   ├── PlantacaoController.java
│   │   │   │   ├── SafraController.java
│   │   │   │   ├── InsumoController.java
│   │   │   │   ├── RelatorioController.java
│   │   │   │   └── LogErroController.java
│   │   │   ├── dto/
│   │   │   │   ├── request/                    ← Java Records + Bean Validation
│   │   │   │   └── response/                   ← Java Records
│   │   │   ├── entity/
│   │   │   │   ├── Usuario.java                ← implements UserDetails
│   │   │   │   ├── Plantacao.java              ← enum StatusPlantio
│   │   │   │   ├── Safra.java
│   │   │   │   ├── Insumo.java
│   │   │   │   ├── Relatorio.java
│   │   │   │   └── LogErro.java
│   │   │   ├── exception/
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   └── ConflictException.java
│   │   │   ├── repository/                     ← JpaRepository + queries
│   │   │   ├── security/
│   │   │   │   ├── JwtService.java
│   │   │   │   └── JwtAuthenticationFilter.java
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-prod.properties     ← Oracle (produção)
│   └── test/
│       └── java/br/com/fiap/agrovision/
│           └── UsuarioServiceTest.java
├── Dockerfile
└── pom.xml
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
|:---|:---:|:---|
| **Java** | 21 | Linguagem principal |
| **Spring Boot** | 3.3.0 | Framework base |
| **Spring Web** | — | API REST |
| **Spring Data JPA** | — | Persistência ORM |
| **Spring Security** | — | Autenticação e autorização |
| **Spring HATEOAS** | — | Hypermedia (links nos responses) |
| **Spring Validation** | — | Validação de dados de entrada |
| **JJWT** | 0.12.5 | Geração e validação de tokens JWT |
| **Lombok** | — | Redução de boilerplate |
| **Spring Boot DevTools** | — | Produtividade em desenvolvimento |
| **Springdoc OpenAPI** | 2.5.0 | Documentação Swagger UI |
| **Oracle Database** | — | Banco de produção (FIAP) |
| **Docker** | — | Containerização para deploy |

---

## 🗄️ Modelo de Dados

### Diagrama de Relacionamentos

```
Usuario (1) ──────────────── (N) Plantacao
                                     │
                         ┌───────────┼───────────┐
                         │           │           │
                    (N) Safra   (N) Insumo   (N) Relatorio
```

### Tabelas Oracle

| Tabela | Descrição |
|:---|:---|
| `TB_USER_GS` | Usuários da fazenda |
| `TB_PLANTACOES_GS` | Plantações monitoradas |
| `TB_SAFRA_GS` | Registros de colheita |
| `TB_INSUMO_GS` | Estoque de insumos por plantação |
| `TB_RELATORIO_GS` | Relatórios gerados automaticamente |
| `TB_LOG_ERRO_GS` | Log de erros do sistema |

### Status de Plantação

| Status | Descrição |
|:---:|:---|
| 🟢 `PLANTADO` | Plantação ativa — permite registro de colheita |
| 🟡 `PREPARACAO` | Solo em preparação |
| ⚫ `DESCANSO` | Área em descanso |

---

## 🔒 Segurança

A API utiliza **Spring Security + JWT (Bearer Token)**. Todas as rotas são protegidas, exceto:

**Endpoints públicos (sem autenticação):**
- `POST /api/auth/login`
- `POST /api/usuarios`
- `/swagger-ui/**` e `/api-docs/**`

**Como autenticar:**
1. Cadastre-se via `POST /api/usuarios`
2. Faça login via `POST /api/auth/login`
3. Use o token retornado no header de todas as requisições:
```
Authorization: Bearer <seu_token>
```

---

## 📡 Endpoints da API

### 🔐 Autenticação
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `POST` | `/api/auth/login` | Login com CPF e senha — retorna JWT | 🔓 Público |

### 👤 Usuários
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `POST` | `/api/usuarios` | Cadastrar usuário | 🔓 Público |
| `GET` | `/api/usuarios` | Listar todos | 🔒 JWT |
| `GET` | `/api/usuarios/{id}` | Buscar por ID | 🔒 JWT |
| `PUT` | `/api/usuarios/{id}` | Atualizar | 🔒 JWT |
| `DELETE` | `/api/usuarios/{id}` | Deletar | 🔒 JWT |

### 🌱 Plantações
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `POST` | `/api/plantacoes` | Cadastrar plantação | 🔒 JWT |
| `GET` | `/api/plantacoes` | Listar todas | 🔒 JWT |
| `GET` | `/api/plantacoes/{id}` | Buscar por ID | 🔒 JWT |
| `GET` | `/api/plantacoes/usuario/{id}` | Listar por usuário | 🔒 JWT |
| `PUT` | `/api/plantacoes/{id}` | Atualizar | 🔒 JWT |
| `PATCH` | `/api/plantacoes/{id}/status` | Alterar status | 🔒 JWT |
| `DELETE` | `/api/plantacoes/{id}` | Deletar | 🔒 JWT |

### 🌾 Safras (Colheitas)
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `POST` | `/api/safras` | Registrar colheita | 🔒 JWT |
| `GET` | `/api/safras` | Listar todas | 🔒 JWT |
| `GET` | `/api/safras/{id}` | Buscar por ID | 🔒 JWT |
| `GET` | `/api/safras/plantacao/{id}` | Listar por plantação | 🔒 JWT |
| `GET` | `/api/safras/plantacao/{id}/total` | Total colhido por plantação | 🔒 JWT |
| `PUT` | `/api/safras/{id}` | Atualizar | 🔒 JWT |
| `DELETE` | `/api/safras/{id}` | Deletar | 🔒 JWT |

### 🧪 Insumos
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `POST` | `/api/insumos` | Cadastrar insumo | 🔒 JWT |
| `GET` | `/api/insumos` | Listar todos | 🔒 JWT |
| `GET` | `/api/insumos/{id}` | Buscar por ID | 🔒 JWT |
| `GET` | `/api/insumos/plantacao/{id}` | Listar por plantação | 🔒 JWT |
| `PUT` | `/api/insumos/{id}` | Atualizar | 🔒 JWT |
| `DELETE` | `/api/insumos/{id}` | Deletar | 🔒 JWT |

### 📊 Relatórios
| Método | Endpoint | Descrição | Auth |
|:---:|:---|:---|:---:|
| `GET` | `/api/relatorios` | Listar todos | 🔒 JWT |
| `GET` | `/api/relatorios/{id}` | Buscar por ID | 🔒 JWT |
| `DELETE` | `/api/relatorios/{id}` | Deletar | 🔒 JWT |

---

## ▶️ Como Executar Localmente

### Pré-requisitos

- Java 21+
- Maven 3.8+
- Docker (opcional)

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/agrovision.git
cd agrovision

# 2. Execute a aplicação
./mvnw spring-boot:run

# 3. Acesse a documentação Swagger
http://localhost:8080/swagger-ui.html
```

### Executar com Docker

```bash
# Build da imagem
docker build -t agrovision .

# Executar container
docker run -p 8080:8080 agrovision
```

### Executar os testes

```bash
./mvnw test
```

---

## 🧪 Exemplos de Uso

### 1. Cadastrar usuário
```bash
curl -X POST https://agrovision-gs-fewn.onrender.com/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "cpf": 12345678901,
    "nome": "João Silva",
    "senha": "senha123",
    "nomeFazenda": "Fazenda São João"
  }'
```

### 2. Fazer login e obter token
```bash
curl -X POST https://agrovision-gs-fewn.onrender.com/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"cpf": 12345678901, "senha": "senha123"}'
```

### 3. Cadastrar plantação
```bash
curl -X POST https://agrovision-gs-fewn.onrender.com/api/plantacoes \
  -H "Authorization: Bearer <TOKEN>" \
  -H "Content-Type: application/json" \
  -d '{
    "usuarioId": 1,
    "tipoPlantio": "Soja",
    "areaPlantio": 150,
    "dataPlantio": "2026-03-01",
    "localPlantio": "Setor Norte",
    "status": "PLANTADO"
  }'
```

### 4. Registrar colheita
```bash
curl -X POST https://agrovision-gs-fewn.onrender.com/api/safras \
  -H "Authorization: Bearer <TOKEN>" \
  -H "Content-Type: application/json" \
  -d '{
    "plantacaoId": 1,
    "dataColheita": "2026-06-01",
    "qtdColhida": 450.50
  }'
```

---

## 🚀 Deploy em Produção

A API está hospedada no **Render** com banco de dados **Oracle** da FIAP.

> ⚠️ O plano gratuito do Render hiberna o servidor após 15 minutos de inatividade. A primeira requisição pode demorar até 50 segundos para "acordar" o servidor.

---

<div align="center">

Desenvolvido com 💚 pela equipe AgroVision

**FIAP — Java Advanced | Global Solution 2026/1**

</div>
