# video_metadataService

принимает запросы следующих видов:

POST /video
X-Request-ID: request_id - хедер для трассировки
Content-Type: application/json

{
    "user_id": 123,
    "channel": "telegram",
    "filename": "kakoe to video",            - его настоящее название
    "path": "/{uid}/{unique file name}" - путь (на деле имя) к файлу в хранилище
}

возвращает 201 CREATED и в ответ ID созданной записи в базе:

{
  "id": "1"
}
и выставляет статус PROCESSING

PATCH /video/{user_id}
X-Request-ID: request_id - хедер для трассировки
Content-Type: application/json

{
  "video_id": 123,          
  "description": "123opisanie",
  "tags": ["kotiki", "video"]
}

изменяет значение полей в БД и проставляет статус COMPLETED, возвращает 200 OK

GET /video/{user_id}
возвращает массив вида
[
    {
        "id": 3,
        "userId": 123,
        "channel": "telegram",
        "status": "PROCESSING",
        "tags": [
            ""
        ],
        "description": "",
        "path": "/123/unique file name",
        "filename": "kakoe to video"
    },
    {
        "id": 5,
        "userId": 123,
        "channel": "telegram",
        "status": "COMPLETED",
        "tags": [
            "kotiki",
            "video"
        ],
        "description": "123opisanie",
        "path": "/1ssss23/unique file name",
        "filename": "kakoe to video"
    }
]


