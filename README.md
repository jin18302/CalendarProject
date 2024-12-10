# 프로젝트기간
2024.12.04~2024.12.10

# 개발환경
```jdk17``` ```intellij```

# 프로젝트설명
-일정추가 </br>
-전체일정조회
-일정조회
-일정수정
-일정삭제 




| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 | /calendar                                  | ```post```       | { "name":"String",  "password":"String",  "text":"String" } | { "name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 전체일정조회 |   "/{name}" ,  "/{name}/{day}" ,  "/{day}" | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"} ..... | ```200```        |
| 일정조회     | /{id}                                      | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 일정수정     | /{id}                                      | ```path```       | { "name":String "password":"String" "text":"String" }       | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 삭제         | /{id}                                      | ```delect```     | 없음                                                        | 없음                                                                                            | ```204```        |
