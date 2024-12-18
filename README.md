# 프로젝트기간
2024.12.04~2024.12.10

# 개발환경
```jdk17``` ```intellij```

# 프로젝트설명
-일정추가 </br>
사용자로부터 입력받은 정보와, id, CreationDate, ModificationDate를 자동생성하여 db에 추가, 비밀번호 반환하지않음</br>
</br>
-전체일정조회</br>
작성자명이나, 작성일을 기준으로 조건을 충족하는 데이터조회</br>
</br>
-일정조회</br>
입력받은 id를 기준으로 조건에 충족하는 데이터조회</br>
</br>
-일정수정</br>
수정내용과 비밀번호 입력받아 해당 id를 가진 데이터 수정 후 수정된 내용반환, 비밀번호 반환하지않음</br>
</br>
-일정삭제 </br>
id가 일치하는 데이터 삭제</br>
</br>
</br>
</br>
</br>
</br>

# ERD
![erd](https://github.com/user-attachments/assets/c29c8381-28f6-42ae-964e-775235d997b5)
</br>
</br>
</br>
</br>
</br>



# API명세서


| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 |                                  | ```post```       | { "name":"String",  "password":"String",  "text":"String" } | { "name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 전체일정조회 |   {"/all/{name}/{day}","/all","/all/{name}","/all//{day}"} | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"} ..... | ```200```        |
| 일정조회     | /{id}                                      | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 일정수정     | /{id}                                      | ```patch```       | { "name":String "password":"String" "text":"String" }       | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 삭제         | /{id}                                      | ```delete```     |  {"password":"String"}                                                        | 없음                                                                                            | ```204```        |
