# Hotel Service API

RESTful API приложение для управления информацией об отелях.

## 🚀 Запуск приложения

```bash
mvn spring-boot:run
```
Приложение запускается на порту: **8092**

## 📚 Базовый URL

Все методы имеют общий префикс: `/property-view`

```
http://localhost:8092/property-view
```

---

## 📋 API Методы

### 1. Получение списка всех отелей

**GET** `/hotels`

Возвращает краткую информацию по всем отелям.

**Пример запроса:**
```
GET /property-view/hotels
```

**Пример ответа:**
```json
[
  {
    "id": 1,
    "name": "DoubleTree by Hilton Minsk",
    "description": "The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...",
    "address": "9 Pobediteley Avenue, Minsk, 220004, Belarus",
    "phone": "+375 17 309-80-00"
  }
]
```

---

### 2. Получение информации о конкретном отеле

**GET** `/hotels/{id}`

Возвращает расширенную информацию по указанному отелю.

**Пример запроса:**
```
GET /property-view/hotels/1
```

**Пример ответа:**
```json
{
  "id": 1,
  "name": "DoubleTree by Hilton Minsk",
  "description": "The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...",
  "brand": "Hilton",
  "address": {
    "houseNumber": 9,
    "street": "Pobediteley Avenue",
    "city": "Minsk",
    "country": "Belarus",
    "postCode": "220004"
  },
  "contacts": {
    "phone": "+375 17 309-80-00",
    "email": "doubletreeminsk.info@hilton.com"
  },
  "arrivalTime": {
    "checkIn": "14:00",
    "checkOut": "12:00"
  },
  "amenities": [
    "Free parking",
    "Free WiFi",
    "Non-smoking rooms",
    "Concierge",
    "On-site restaurant",
    "Fitness center",
    "Pet-friendly rooms",
    "Room service",
    "Business center",
    "Meeting rooms"
  ]
}
```

---

### 3. Поиск отелей

**GET** `/search`

Поиск отелей с краткой информацией по указанным параметрам.

**Параметры запроса:**
- `name` - название отеля
- `brand` - бренд
- `city` - город
- `country` - страна
- `amenities` - удобства

**Пример запроса:**
```
GET /property-view/search?city=minsk
```

**Пример ответа:**
Аналогичен ответу из `GET /hotels`

---

### 4. Создание нового отеля

**POST** `/hotels`

Создаёт новый отель.

**Пример запроса:**
```json
{
  "name": "DoubleTree by Hilton Minsk",
  "description": "The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...",
  "brand": "Hilton",
  "address": {
    "houseNumber": 9,
    "street": "Pobediteley Avenue",
    "city": "Minsk",
    "country": "Belarus",
    "postCode": "220004"
  },
  "contacts": {
    "phone": "+375 17 309-80-00",
    "email": "doubletreeminsk.info@hilton.com"
  },
  "arrivalTime": {
    "checkIn": "14:00",
    "checkOut": "12:00"
  }
}
```

*Примечание: поля `description` и `arrivalTime.checkOut` являются опциональными.*

**Пример ответа:**
```json
{
  "id": 1,
  "name": "DoubleTree by Hilton Minsk",
  "description": "The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...",
  "address": "9 Pobediteley Avenue, Minsk, 220004, Belarus",
  "phone": "+375 17 309-80-00"
}
```

---

### 5. Добавление удобств к отелю

**POST** `/hotels/{id}/amenities`

Добавляет список удобств к указанному отелю.

**Пример запроса:**
```
POST /property-view/hotels/1/amenities
```

**Тело запроса:**
```json
[
  "Free parking",
  "Free WiFi",
  "Non-smoking rooms",
  "Concierge",
  "On-site restaurant",
  "Fitness center",
  "Pet-friendly rooms",
  "Room service",
  "Business center",
  "Meeting rooms"
]
```

---

### 6. Получение статистики по отелям

**GET** `/histogram/{param}`

Возвращает количество отелей, сгруппированных по значениям указанного параметра.

**Параметры:**
- `brand` - группировка по бренду
- `city` - группировка по городу
- `country` - группировка по стране
- `amenities` - группировка по удобствам

**Пример запроса:**
```
GET /property-view/histogram/city
```

**Пример ответа:**
```json
{
  "Minsk": 1,
  "Moscow": 2,
  "Mogilev": 1
}
```

**Пример запроса по удобствам:**
```
GET /property-view/histogram/amenities
```

**Пример ответа:**
```json
{
  "Free parking": 1,
  "Free WiFi": 20,
  "Non-smoking rooms": 5,
  "Fitness center": 1
}
```

---

## 🛠 Используемые технологии

- **Maven** - управление зависимостями
- **Java 17+** - язык программирования
- **Spring Boot** - основной фреймворк
- **Spring JPA** - работа с базой данных
- **Liquibase** - миграции базы данных
- **H2** - база данных (по умолчанию)
- **Swagger** - документация API

---

## 🏗 Архитектура

- **Разделение на слои**: контроллеры, сервисы, репозитории
- **Использование паттернов проектирования**
- **Легкое переключение между базами данных** (H2, MySQL, PostgreSQL, MongoDB и др.)

---

## 📖 Документация Swagger

После запуска приложения документация доступна по адресу:
```
http://localhost:8092/property-view/swagger-ui.html
```