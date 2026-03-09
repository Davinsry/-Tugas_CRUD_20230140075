# 🪪 KTP Management System

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23F7DF1E.svg?style=for-the-badge&logo=javascript&logoColor=black)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)

A full-stack web application for managing KTP (Kartu Tanda Penduduk) data, built with Spring Boot, MySQL, and jQuery Ajax.

## ✨ Features
- **Create**: Add new KTP records with validation.
- **Read**: View all KTP records in a modern, responsive table.
- **Update**: Edit existing KTP records.
- **Delete**: Remove KTP records with confirmation.
- **AJAX Driven**: All operations occur without page refreshes.
- **Modern UI**: Premium look with Outfit typography and smooth transitions.

## Tech Stack
- **Backend**: Java 25, Spring Boot 4.0.3, Spring Data JPA, MySQL Connector.
- **Frontend**: HTML5, Vanilla CSS, JavaScript (jQuery 3.6.0).
- **Database**: MySQL 8+ (running on port 3308).

## API Documentation

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/ktp` | Add a new KTP record |
| GET | `/ktp` | Get all KTP records |
| GET | `/ktp/{id}` | Get a KTP record by ID |
| PUT | `/ktp/{id}` | Update an existing KTP record |
| DELETE | `/ktp/{id}` | Delete a KTP record |

### Data Model
```json
{
  "nomorKtp": "1234567890123456",
  "namaLengkap": "John Doe",
  "alamat": "Jalan Merdeka No. 1",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "LAKI-LAKI"
}
```

## Screenshots

### 1. Main Dashboard & Data Entry
![KTP List](ktp_list.png)

### 2. Editing Data
![Edit Form](ktp_edit_form.png)

### 3. Updated Data
![Updated List](ktp_updated_list.png)

## How to Run

1. **Database Setup**:
   - Create a database named `deploy_3`.
   - Update `src/main/resources/application.properties` with your MySQL credentials.
2. **Launch Backend**:
   - Run `.\mvnw spring-boot:run` in the project root.
3. **Access Frontend**:
   - Open your browser and navigate to `http://localhost:8080`.
